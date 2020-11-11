/**
 * Given a string s, the power of the string is the maximum length of a non-empty substring that 
 * contains only one unique character.
 * 
 * Return the power of the string.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * 
 * Example 2:
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * 
 * Example 3:
 * Input: s = "triplepillooooow"
 * Output: 5
 * 
 * Example 4:
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * 
 * Example 5:
 * Input: s = "tourist"
 * Output: 1
 * 
 * Constraints:
 * 1 <= s.length <= 500
 * s contains only lowercase English letters
 * 
 */
package leetcode;

public class ConsecutiveCharacters {

	public static void main(String[] args) {
		System.out.println(maxPower("leetcode"));
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * 
	 * @param s
	 * @return
	 */
	private static int maxPower(String s) {
		int count = 0;
        int maxCount = 0;
        char previous = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == previous) {
                // if same as previous one, increase the count
                count++;
            } else {
                // else, reset the count
                count = 1;
                previous = c;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
	}

}
