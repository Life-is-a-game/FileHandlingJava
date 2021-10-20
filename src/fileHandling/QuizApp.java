package fileHandling;

import java.util.*;
import java.io.*;

public class QuizApp {
	
	private static String quest = "";
	private static List<String> answers = new ArrayList<String>();
	private static HashMap<String, String> lookup = new HashMap<String, String>();

	public static void main(String[] args) {
		
		Quiz[] qArray = initialise();
		if(qArray != null) {
			game(qArray);
		}
		
	}
	
	protected static Quiz[] initialise() {
		System.out.println("Welcome to the general knowledge quiz");
		
		try {
			FileReader f = new FileReader("src/quiz.txt");
			BufferedReader buff = new BufferedReader(f);
			
			String line = "";
			int lines = 0;
			
			while((line = buff.readLine()) != null) {
				lines++;
			}
			buff.close();
			
			Quiz[] qA = new Quiz[lines];
			
			
			File file = new File("src/quiz.txt");
			int counter = 0;
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				String liner = scan.nextLine();
				
				if(liner.startsWith("Q:")) {
					String s = liner.replaceAll("Q: ", "");
					s = s.replaceAll("Q:", "");
					quest = s;
				}
				else if(liner.startsWith("A:")) {
					String a = liner.replaceAll("A: ", "");
					a = a.replaceAll("A:", "");
					String tA = "";
					
					if(liner.endsWith(" ##")) {
						a = a.replaceAll(" ##", "");
						tA = a;
						lookup.put(quest, tA);
					}
					answers.add(a);
				}
				else if(liner.isEmpty()){
					String[] ans = new String[answers.size()];
					for(int in = 0; in < answers.size(); in++) {
						ans[in] = answers.get(in);
					}
					
					
					qA[counter] = new Quiz(quest, ans);
							
					counter++;
					answers.clear();
					quest = "";
				}
			}
			scan.close();
			
			int am = 0;
			
			for(Quiz q : qA) {
				if(q != null) {
					am++;
				}
				else {
					
				}
			}
			
			Quiz[] qA2 = new Quiz[am];
			
			System.arraycopy(qA, 0, qA2, 0, am);
			
			return qA2;
		}
		catch(IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	protected static void game(Quiz[] quizArr) {
		boolean flag = true;
		int iterator = 0;
		while(flag) {
			try {
				System.out.println(greeting(iterator));
				Scanner scnr = new Scanner(System.in);
				String a = "";
				a = a.toLowerCase();
				if(scnr.hasNextLine()) {
					a = scnr.nextLine();
				}
				
				switch(a) {
					case "p":
						for(int fin = 0; fin < quizArr.length; fin++) {
							System.out.println(quizArr[fin].getQuestion());
							for(String s : quizArr[fin].getAnsArr()) {
								System.out.println(s);
							}
							try {
								System.out.println("\nPlease input the number corresponding to the correct value. E.g. 1 is the first option");
								int gamma = 0;
								if(scnr.hasNextInt()) {
									gamma = scnr.nextInt();
								}
								scnr.nextLine();
								
								int index = 0;
								switch(gamma) {
									default:
										index = gamma - 1;
										break;
								}
								
								String question = quizArr[fin].getQuestion();
								
								if(lookup.get(question) == quizArr[fin].getAnsArr()[index]) {
									System.out.println("Correct! \n\n");
									if(fin == quizArr.length - 1) {
										System.out.println("Congratulations, you have beaten the quiz! \n");
									}
									continue;
								}
								else {
									System.out.println("Unfortunately, that was incorrect\n\n");
									break;
								}
							}
							catch(Exception e){
								System.out.println(e);
								break;
							}
						}
						break;
					case "q":
						flag = false;
						scnr.close();
						break;
					default:
						System.out.println("Invalid Choice");
						break;
				}
			}
			catch(Exception e) {
				System.out.println(e);
				flag = false;
			}
		}
	}
	protected static String greeting(int it) {
		
		switch(it) {
			case 0:
				return "Do you wish to play the quiz or exit? Input P to play or Q to quit.";
			default:
				return "Do you wish to play the quiz again or exit? Input P to play or Q to quit.";
		}
	}

}
