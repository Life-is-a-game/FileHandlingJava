package fileHandling;

import java.io.*;

public class FileReader03 {

	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("src/testlog.txt");
			BufferedReader buff = new BufferedReader(f);
			
			String line = "";
			int count = 0;
			
			while((line = buff.readLine()) != null && count < 3) {
				System.out.println(line);
				count++;
			}
			
			buff.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
