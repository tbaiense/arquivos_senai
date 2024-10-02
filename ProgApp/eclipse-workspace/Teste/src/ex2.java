import java.io.DataInputStream;
import java.io.IOException;

/**
 * Exercise 4.2:

The hexadecimal digits are the ordinary, base-10 digits '0' through '9' plus the letters 'A' through 'F'. In the hexadecimal system, these digits represent the values 0 through 15, respectively. Write a function named hexValue that uses a switch statement to find the hexadecimal value of a given character. The character is a parameter to the function, and its hexadecimal value is the return value of the function. You should count lower case letters 'a' through 'f' as having the same value as the corresponding upper case letters. If the parameter is not one of the legal hexadecimal digits, return -1 as the value of the function.

A hexadecimal integer is a sequence of hexadecimal digits, such as 34A7, ff8, 174204, or FADE. If str is a string containing a hexadecimal integer, then the corresponding base-10 integer can be computed as follows:

value = 0;
for ( i = 0; i < str.length();  i++ )
   value = value*16 + hexValue( str.charAt(i) );

Of course, this is not valid if str contains any characters that are not hexadecimal digits. Write a program that reads a string from the user. If all the characters in the string are hexadecimal digits, print out the corresponding base-10 value. If not, print out an error message.
 */
public class ex2 {

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		
		String entrada = in.readLine();
		
		if (isHex(entrada)) {
			int value = 0;
			for (int i = 0; i < entrada.length();  i++ )
			   value = value*16 + hexValue( entrada.charAt(i) );
			
			System.out.print("Decimal value: " + value);
		} else {
			System.out.print("ERRO: Valor não hexadecimal");
		}
		
	}
	private static int hexValue(char c) {
		c = Character.toUpperCase(c);
		
		return switch(c) {
			case '0' -> 0;
			case '1' -> 1;
			case '2' -> 2;
			case '3' -> 3;
			case '4' -> 4;
			case '5' -> 5;
			case '6' -> 6;
			case '7' -> 7;
			case '8' -> 8;
			case '9' -> 9;
			case 'A' -> 10;
			case 'B' -> 11;
			case 'C' -> 12;
			case 'D' -> 13;
			case 'E' -> 14;
			case 'F' -> 15;
			default -> -1;
		};
	}
	
	private static boolean isHex(String str) {
		for(int i=0; i<str.length(); i++) {
			char c = Character.toUpperCase(str.charAt(i));
			if (Character.isLetter(c)) {
				if (c > 'F') {
					return false;	
				}
			} else if (!Character.isDigit(c)) {
				return false;
			}
			
		}
		return true;
	}
}
