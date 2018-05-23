/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 * 
 * Notes:
 * 
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 * 
 */

package basicProgramming;

public class Scramblies {

	public static void main(String[] args) {
		System.out.println(scramble("katas", "steak"));
	}

	public static boolean scramble(String str1, String str2) {

		String s3 = "";
		StringBuilder s = new StringBuilder(str1);
		StringBuilder s1 = new StringBuilder(str2);
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s1.charAt(i) == s.charAt(j)) {
					s3 += s.charAt(j);
					s.deleteCharAt(j);
					break;
				}
			}
		}
		if (s3.equals(str2))
			return true;
		return false;
	}
}
