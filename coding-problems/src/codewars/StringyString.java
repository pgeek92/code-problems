/**
 * write me a function stringy that takes a size and returns a string of alternating '1s' and '0s'.
 * 
 * the string should start with a 1.
 * 
 * a string with size 6 should return :'101010'.
 * 
 * with size 4 should return : '1010'.
 * 
 * with size 12 should return : '101010101010'.
 * 
 * The size will always be positive and will only use whole numbers.
 * 
 */

package codewars;

public class StringyString {

	public static void main(String[] args) {
		System.out.println(stringy(12));
	}

	public static String stringy(int size) {
		String number = "1";
		for (int i = 1; i < size; i++) {
			if (i % 2 == 0) {
				number += "1";
			} else {
				number += "0";
			}
		}
		return number;
	}

}
