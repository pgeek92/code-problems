/**
 * Given a string, we need to find the leftmost character that repeats
 * 
 * Example : geeksforgeeks
 * output  : 0 (g repeats and is the leftmost character)
 * 
 */
package datastructures.String;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) {
		String str = "prashant";

		System.out.println(approach1(str));
		System.out.println(approach2(str));
		System.out.println(approach3(str));
		System.out.println(approach4(str));
	}
	
	/**
	 * Brute force approach #1
	 * 
	 * <p>
	 * <i>Time Complexity</i> : O(n*n)
	 * 
	 * @param str
	 * @return
	 */
	public static int approach1(String str) {
		int strLength = str.length();
		for(int i = 0; i < strLength; i++) {
			for(int j = i+1; j < strLength; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * better solution with two traversals #2
	 * 
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * @param str
	 * @return
	 */
	public static int approach2(String str) {
		Map<Character, Integer> charToCountMap = new HashMap<Character, Integer>();
		int strLength = str.length();
		for(int i = 0; i < strLength; i++) {
			if(charToCountMap.containsKey(str.charAt(i))) {
				charToCountMap.put(str.charAt(i), charToCountMap.get(str.charAt(i)) + 1);
			} else {
				charToCountMap.put(str.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < strLength; i++) {
			if(charToCountMap.get(str.charAt(i)) > 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * better solution with only one traversal (left to right traversal) #3
	 * 
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * @param str
	 * @return
	 */
	public static int approach3(String str) {
		int index = 256;
		int strLength = str.length();
		int result = Integer.MAX_VALUE;
		int[] indexArray = new int[index];
		for(int i = 0; i < index; i++) {
			indexArray[i] = -1;
		}
		
		for(int i = 0; i < strLength; i++) {
			if(indexArray[str.charAt(i)] == -1) {
				indexArray[str.charAt(i)] = i;
			} else {
				result = Math.min(result, indexArray[str.charAt(i)]);
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	/**
	 * better solution with only one traversal (from right to left traversal) #4
	 * hence reduced extra comparison in else block
	 * 
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * @param str
	 * @return
	 */
	public static int approach4(String str) {
		int index = 256;
		int strLength = str.length();
		int result = Integer.MAX_VALUE;
		int[] indexArray = new int[index];
		for(int i = 0; i < index; i++) {
			indexArray[i] = -1;
		}
		
		for(int i = strLength - 1; i >= 0; i--) {
			if(indexArray[str.charAt(i)] == -1) {
				indexArray[str.charAt(i)] = i;
			} else {
				result = i;
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
}
