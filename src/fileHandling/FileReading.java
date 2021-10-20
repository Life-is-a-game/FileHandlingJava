package fileHandling;

import java.io.*;

public class FileReading {

	public static void main(String[] args) {
		
		try {
			FileReader f = new FileReader("src/testlog.txt");
			BufferedReader buff = new BufferedReader(f);
			
			String line = "";
			
			while((line = buff.readLine()) != null) {
				System.out.println(line);
			}
			
			buff.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
