/**
 * Given two strings s and t , write a function to determine if t is 
 * an anagram of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? 
 * How would you adapt your solution to such case?
 * 
 */
package datastructures.String;

import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {

	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "ba";
		System.out.println(approach1(str1, str2));
		System.out.println(approach2(str1, str2));
		System.out.println(approach3(str1, str2));
		System.out.println(followUp(str1, str2));
	}
	
	/**
	 * Approach #1 (Sorting)
	 * 
	 * <p>
	 * <b>Algorithm</b>
	 * 
	 * <p>
	 * An anagram is produced by rearranging the letters of s into t. 
	 * Therefore, if t is an anagram of s, sorting both strings will result 
	 * in two identical strings. Furthermore, if s and t have different lengths, 
	 * t must not be an anagram of s and we can return early.
	 * 
	 * <p>
	 * <b>Complexity analysis</b>
	 * 
	 * <p>
	 * <i>Time complexity</i> : O(nlogn). Assume that n is the length of s, 
	 * sorting costs O(nlogn) and comparing two strings costs O(n). 
	 * Sorting time dominates and the overall time complexity is O(nlogn).
	 * 
	 * <p>
	 * <i>Space complexity</i> : O(1). Space depends on the sorting implementation which, usually, 
	 * costs O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray() makes a copy of the string 
	 * so it costs O(n) extra space, but we ignore this for complexity analysis because:
	 * 
	 * It is a language dependent detail.
	 * It depends on how the function is designed. For example, the function parameter types can be changed to char[].
	 * 
	 * @param str1
	 * @param str2
	 * @return <code>true</code> or <code>false</code>
	 */
	
	private static boolean approach1(String str1, String str2) {
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		
		int str1Length = str1Array.length;
		int str2Length = str2Array.length;
		
		if(str1Length != str2Length) {
			return false;
		}
		
		Arrays.sort(str1Array);
		Arrays.sort(str2Array);
		
		return Arrays.equals(str1Array, str2Array);
	}

	/**
	 * Approach #2 (Hash Table)
	 * 
	 * <p>
	 * <b>Algorithm</b>
	 * 
	 * <p>
	 * To examine if t is a rearrangement of s, we can count occurrences of each letter in the
	 * two strings and compare them. Since both s and t contain only letters from a-z, 
	 * a simple counter table of size 26 is suffice.
	 * 
	 * Do we need two counter tables for comparison? Actually no, 
	 * because we could increment the counter for each letter in s and decrement 
	 * the counter for each letter in t, then check if the counter reaches back to zero.
	 * 
	 * <p>
	 * <b>Complexity analysis</b>
	 * 
	 * <p>
	 * <i>Time complexity</i> : O(n). Time complexity is O(n) because accessing 
	 * the counter table is a constant time operation..
	 * 
	 * <p>
	 * <i>Space complexity</i> : O(1). Although we do use extra space, the space complexity is 
	 * O(1) because the table's size stays constant no matter how large n is:
	 * 
	 * @param str1
	 * @param str2
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean approach2(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		int[] counter = new int[26];
		for(int i = 0; i < str1.length(); i++) {
			counter[str1.charAt(i) - 'a']++;
			counter[str2.charAt(i) - 'a']--;
		}
		
		for(int count : counter) {
			if(count != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Approach #3 (Bit Manipulation)
	 * 
	 * <p>
	 * The above implementation can be further optimized by using bit 
	 * manipulation. If we start at a value of 0 and XOR all the characters 
	 * of both strings, we should return an end value of 0 if they are 
	 * anagrams because there would be an even occurrence of all characters in the anagram
	 * 
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * 
	 * <p>
	 * <i>Space Complexity</i> : O(1)
	 * @param str1
	 * @param str2
	 * @return <code>true</code> or <code>false</code>
	 */
	
	private static boolean approach3(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		int value = 0;
		for(int i = 0; i < str1.length(); i++) {
			value = value ^ (int) str1.charAt(i);
			value = value ^ (int) str2.charAt(i);
		}
		
		return value == 0;
	}
	
	/**
	 * <b>Follow up</b>
	 * 
	 * <p>
	 * What if the inputs contain unicode characters? 
	 * How would you adapt your solution to such case?
	 * 
	 * <p>
	 * <b>Answer</b>
	 * 
	 * <p>
	 * Use a hash table instead of a fixed size counter. 
	 * Imagine allocating a large size array to fit the entire range of 
	 * unicode characters, which could go up to more than 1 million. 
	 * A hash table is a more generic solution and could adapt to any 
	 * range of characters
	 * 
	 * @param str1
	 * @param str2
	 * @return <code>true</code> or <code>false</code>
	 */
	private static boolean followUp(String str1, String str2) {
		HashMap<Character, Integer> smap = new HashMap<>();
		int sl = str1.length();
		int tl = str2.length();
		if (sl != tl) {
			return false;
		}
		for (int i = 0; i < sl; i++) {
			smap.put(str1.charAt(i), smap.getOrDefault(str1.charAt(i), 0) + 1);
			smap.put(str2.charAt(i), smap.getOrDefault(str2.charAt(i), 0) - 1);
		}
		for (char c : smap.keySet()) {
			if (smap.get(c) != 0) {
				return false;
			}
		}

		return true;
	}
}
