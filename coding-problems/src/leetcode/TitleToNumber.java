/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *     ...
 * Example 1:
 * 
 * Input: "A"
 * Output: 1
 * Example 2:
 * 
 * Input: "AB"
 * Output: 28
 * Example 3:
 * 
 * Input: "ZY"
 * Output: 701
 *  
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW"
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TitleToNumber {

	public static void main(String[] args) {

	}
	
	/**
	 * Time complexity : O(N) where N is the number of characters in the input string
	 * Space Complexity : O(1)
	 * @param s
	 * @return
	 */
	public static int titleToNumberR2L(String s) {
		int result = 0;
		Map<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
		for(int i = 0; i < 26; i++) {
			int c = i + 65;
			alphabetMap.put((char) c, i + 1);
		}
		
		int n = s.length();
		for(int i = 0; i < n; i++) {
			char currentChar = s.charAt(n - i - 1);
			result += (alphabetMap.get(currentChar) * Math.pow(26, i));
		}
		
		return result;
	}
	
	/**
	 * Time complexity : O(N) where N is the number of characters in the input string
	 * Space Complexity : O(1)
	 * @param s
	 * @return
	 */
	public static int titleToNumberL2R(String s) {
		int result = 0;
		int n = s.length();
		for(int i = 0; i < n; i++) {
			result *= 26;
			result += (s.charAt(i) - 'A' + 1);
		}
		
		return result;
	}

}
