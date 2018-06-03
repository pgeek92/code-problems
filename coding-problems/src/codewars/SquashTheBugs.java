/**
 * Simple challenge - eliminate all bugs from the supplied code so that the code runs and outputs the expected value. 
 * Output should be the length of the longest word, as a number.
 * 
 * There will only be one 'longest' word.
 * 
 */

package codewars;

public class SquashTheBugs {

	public static void main(String[] args) {
		System.out.println(findLongest("Hi, How are you ?"));
	}

	public static int findLongest(final String str) {
		String[] spl = str.split(" ");
		int longest = 0;
		for (int i = 0; i < spl.length; i++) {
			if (spl[i].length() > longest) {
				longest = spl[i].length();
			}
		}
		return longest;
	}

}
