import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PalindromeDetect {
	public static void main(String[] args) throws IOException {
		
		//http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
		FileInputStream fis = null;
		BufferedReader reader = null;
		
		//reads in line-by-line, tests if each line in the document is a palindrome, prints if it is or not
		try {
			fis = new FileInputStream("/Users/benjaminlerner/Documents/workspace/HW2/src/palindromes.txt");
			reader = new BufferedReader(new InputStreamReader(fis));
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
		//System.out.println("test: " + palDetect("Abba"));
	}

	public static String palDetect(String s) {
		MyStack stacked = new MyStack();
		String theString = s;
		//creates an array composed only out of the letters of the palindrome
		String[] words = theString.replaceAll("[^a-zA-Z]", "").toLowerCase().split("");
		//since it counts a space at the beginning, these for loops are actually for even-length palindromes
		if (words.length % 2 == 1) {
			//pushes half the characters onto the stack
			for (int i = 1; i < ((words.length + 1) / 2); i++) {
				stacked.push(words[i]);
			}
			//pops the characters off and checks to see if it is the same as the next character in the array
			//due to last-in-first-out, this allows me to check starting from the middle, working my way outwards.
			for (int i = ((words.length + 1) / 2); i < words.length; i++) {
				String test = stacked.pop().toString();
				if (!test.equals(words[i])) {
					return("'" + theString + "'" + " is not an even palindrome");
				}
			}
		}
		//these are for odd-length palindromes. everything is mostly the same.
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