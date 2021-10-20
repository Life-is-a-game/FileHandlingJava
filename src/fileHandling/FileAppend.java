package fileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) {
		try {
			FileWriter fW = new FileWriter("src/testlog.txt", true);
			BufferedWriter buff = new BufferedWriter(fW);
			
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the amount of lines that you wish to append to the file");
			
			
			String[] input = new String[s.nextInt()];
			s.nextLine();
			
			for(int i = 0; i < input.length; i++) {
				input[i] = s.nextLine();
			}
			
			for(String str : input) {
				buff.newLine();
				buff.write(str);
			}
			
			buff.close();
			s.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
