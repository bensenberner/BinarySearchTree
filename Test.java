import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
	public static void main(String[] args) throws IOException {
		
		//http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream("/Users/benjaminlerner/Documents/workspace/HW2/src/palindromes.txt");
			reader = new BufferedReader(new InputStreamReader(fis));
			/*
			String line = reader.readLine();
			System.out.println(palDetect(line));
			String line2 = reader.readLine();
			System.out.println(palDetect(line2));
			/*
			String line1 = reader.readLine();
			System.out.println(palDetect(line1));
			String line2 = reader.readLine();
			System.out.println(palDetect(line2));
			String line3 = reader.readLine();
			System.out.println(palDetect(line3));
			String line4 = reader.readLine();
			System.out.println(palDetect(line4));
			*/
			
			String line = reader.readLine();
			while(line != null) {
				System.out.println((palDetect(line)));
				line = reader.readLine();
			}
			
			
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		System.out.println("test: " + palDetect("Abba"));
	}

	public static String palDetect(String s) {
		MyStack stacked = new MyStack();
		String theString = s;
		String[] words = theString.replaceAll("[^a-zA-Z]", "").toLowerCase().split("");
		if (words.length % 2 == 1) {
			for (int i = 1; i < ((words.length + 1) / 2); i++) {
				//System.out.println("push" + words[i]);
				stacked.push(words[i]);
			}
			//System.out.println("testing");
			/*
			for(String i : stacked.theArray){
				System.out.println(i);
			}
			*/
			//System.out.println("testing2");
			for (int i = ((words.length + 1) / 2); i < words.length; i++) {
				//System.out.println("check" + words[i]);
				String test = stacked.pop().toString();
				//System.out.println("t1: " + test);
				//System.out.println("t2: " + words[i]);
				if (!test.equals(words[i])) {
					return("'" + theString + "'" + " is not an even palindrome");
				}
			}
		}
		else {
			for (int i = 1; i < (words.length / 2); ++i) {
				stacked.push(words[i]);
			}
			for (int i = (((words.length) / 2) + 1); i < words.length; ++i) {
				if (!stacked.pop().equals(words[i])) {
					System.out.println(words[i]);
					return("'" + theString + "'" + " is not an odd palindrome");
				}
			}
		}
		return("'" + theString + "'" + " is a palindrome");
	}
}