/**
 * Given a text and pattern String, find if permutation of the String exist
 * in the text
 * 
 * Example :
 * 		     text    : geeksforgeeks
 * 			 pattern : ekeg
 * Output  : true
 * Example :
 * 		     text    : geeksforgeeks
 * 			 pattern : gks
 * Output  : false 
 */
package datastructures.String;

import java.util.Arrays;

public class Problem5 {

	public static void main(String[] args) {
		String text = "geeksforgeeks";
		String pattern = "eekg";
		System.out.println(isPatternOrAnagramPatternFoundInText(text, pattern));
	}
	
	public static boolean isPatternOrAnagramPatternFoundInText(String text, String pattren) {
		int countTxtW[] = new int[256];
		int countPat[] = new int[256];
		
		for(int i = 0; i < pattren.length(); i++) {
			countTxtW[text.charAt(i)]++;
			countPat[pattren.charAt(i)]++;
		}
		
		for(int i = pattren.length(); i < text.length(); i++) {
			if(Arrays.equals(countTxtW, countPat)) {
				return true;
			}
			countTxtW[text.charAt(i)]++;
			countTxtW[text.charAt(i - pattren.length())]--;
		}
		return false;
	}
}
