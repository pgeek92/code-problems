/**
 * Given two strings, check if they are rotations of each other
 * (rotations can be cloclwise or counter clockwise)
 * Example : str1 = "ABCD", str2 = "CDAB"
 * Output  : true
 * 
 * Example : str1 = "ABAA", str2 = "AAAB"
 * Output  : true
 * 
 * Example : str1 = "ABAB", str2 = "ABBA"
 * Output  : false
 */
package datastructures.String;

public class Problem6 {

	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 = "CDAC";
		System.out.println(areRotations(str1, str2));
	}
	
	public static boolean areRotations(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		str1 = str1+str1;
		if(str1.indexOf(str2) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
