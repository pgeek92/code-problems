/**
 * When provided with a letter, return its position in the alphabet.
 * 
 * Input :: "a"
 * 
 * Ouput :: "Position of alphabet: 1"
 * 
 */

package basicProgramming;

public class FindThePosition {
	public static String position(char alphabet) {
		String alphabetString = "abcdefghijklmnopqrstuvwxyz";
		int position = 0;
		for (int i = 0; i < alphabetString.length(); i++) {
			if (alphabet == alphabetString.charAt(i)) {
				position = i + 1;
			}
		}
		return "Position of alphabet: " + position;
	}
	
	public static void main(String[] args) {
		System.out.println(position('p'));
	}
}
