/**
 * Program to find first non-repeating character from left in a given String
 * 
 * Example : geeksforgeeks
 * output  : f
 */
package datastructures.String;

import java.util.HashMap;

public class Problem3 {

	public static final int NO_OF_CHARS = 256;
	public static char count[] = new char[NO_OF_CHARS];
	public static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);
	
	public static void main(String[] args) {
		String str = "aac";
		int index = approach1(str);

		System.out.println(index == -1 ? "Either all characters are repeating or string " + "is empty"
				: "First non-repeating character is " + str.charAt(index));
		
		index = approach2(str);
		System.out.println(index == -1 ? "Either all characters are repeating or string " + "is empty"
				: "First non-repeating character is " + str.charAt(index));
	}

	/**
	 * Using two traversals
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * @param str
	 * @return
	 */
	public static int approach1(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
		
		int index = -1, i;

		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return index;
	}
	
	/**
	 * Using only one traversal
	 * <p>
	 * <i>Time Complexity</i> : O(n)
	 * @param str
	 * @return
	 */
	public static int approach2(String str) 
	{ 
		getCharCountArray(str); 
		int result = Integer.MAX_VALUE, i; 
	
		for (i = 0; i < str.length(); i++) 
		{ 
			// If this character occurs only once and appears 
			// before the current result, then update the result 
			if (hm.get(str.charAt(i)).count == 1 && result > hm.get(str.charAt(i)).index){ 
				result = hm.get(str.charAt(i)).index; 
			} 
				
		} 
		
	return result; 
	} 
	
	public static void getCharCountArray(String str) 
	{ 
		for (int i = 0; i < str.length(); i++) 
		{ 
			if(hm.containsKey(str.charAt(i))) 
			{ 
				hm.get(str.charAt(i)).incCount(); 
			} 
			
			else
			{ 
				hm.put(str.charAt(i), new CountIndex(i)); 
			} 
				
		}	 
	} 
}

class CountIndex 
{ 
	int count,index; 
	
	public CountIndex(int index) { 
		this.count = 1; 
		this.index = index; 
	} 
	
	public void incCount() { 
		this.count++; 
	} 
}
