import java.util.Scanner;
import java.io.DataInputStream;
import java.io.IOException;
/**
 Exercise 4.1:
To "capitalize" a string means to change the first letter of each word in the string to upper case (if it is not already upper case). For example, a capitalized version of "Now is the time to act!" is "Now Is The Time To Act!". Write a subroutine named printCapitalized that will print a capitalized version of a string to standard output. The string to be printed should be a parameter to the subroutine. Test your subroutine with a main() routine that gets a line of input from the user and applies the subroutine to it.

Note that a letter is the first letter of a word if it is not immediately preceded in the string by another letter. Recall from Exercise 3.4 that there is a standard boolean-valued function Character.isLetter(char) that can be used to test whether its parameter is a letter. There is another standard char-valued function, Character.toUpperCase(char), that returns a capitalized version of the single character passed to it as a parameter. That is, if the parameter is a letter, it returns the upper-case version. If the parameter is not a letter, it just returns a copy of the parameter.
 */
public class ex1 {

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		String entrada = in.readLine();
		
		capitalize(entrada);
	}

	
	private static void capitalize(String input) {
		String strCap = "";
		
		for(int i=0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isLetter(c)) {
				if (i > 0) {
					char cBefore = input.charAt(i-1);
					if(!Character.isLetter(cBefore)) {
						strCap += Character.toUpperCase(c);
					} else {
						strCap += c;
					}
				} else {
					strCap += Character.toUpperCase(c);
				}
			} else {
				strCap += c;
			}
		}
		
		System.out.print(strCap);
	}
}
