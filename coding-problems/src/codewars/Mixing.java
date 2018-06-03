/**
 * Given two strings s1 and s2, we want to visualize how different the two strings are. 
 * We will only take into account the lowercase letters (a to z). 
 * First let us count the frequency of each lowercase letters in s1 and s2.
 * 
 * s1 = "A aaaa bb c"
 * 
 * s2 = "& aaa bbb c d"
 * 
 * s1 has 4 'a', 2 'b', 1 'c'
 * 
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * 
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. 
 * In the following we will not consider letters when the maximum of their occurrences is less 
 * than or equal to 1.
 * 
 * We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" 
 * where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. 
 * In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.
 * 
 * The task is to produce a string in which each lowercase letters of s1 or s2 appears as many 
 * times as its maximum if this maximum is strictly greater than 1; these letters will be 
 * prefixed by the number of the string where they appear with their maximum value and :. 
 * If the maximum is in s1 as well as in s2 the prefix is =:.
 * 
 * In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the 
 * prefix) will be in decreasing order of their length and when they have the same length sorted 
 * in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); 
 * the different groups will be separated by '/'. See examples and "Example Tests".
 * 
 * Hopefully other examples can make this clearer.
 * 
 * s1 = "my&friend&Paul has heavy hats! &"
 * s2 = "my friend John has many many friends &"
 * mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1="Are the kids at home? aaaaa fffff"
 * s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 * 
 */

package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mixing implements Comparator<String> {
	public static String mix(String s1, String s2) {
		String result2 = "";
		int length1 = s1.length() > s2.length() ? s1.length() : s2.length();
		Map<String, String> map = new HashMap<String, String>();
		for (char i = 'a'; i <= 'z'; i++) {
			int count1 = 0, count2 = 0;
			String s3 = "", s4 = "";
			for (int j = 0; j < length1; j++) {
				if (j < s1.length()) {
					if (s1.charAt(j) == i) {
						s3 += i;
						count1++;
					}
				}
				if (j < s2.length()) {
					if (s2.charAt(j) == i) {
						s4 += i;
						count2++;
					}
				}
			}
			if (count1 == 0 && count2 == 0)
				result2 += "";
			else if (count1 > 1 | count2 > 1) {
				if (count1 > count2)
					map.put(s3, "1");
				else if (count1 == count2)
					map.put(s3, "=");
				else if (count1 < count2)
					map.put(s4, "2");
			}
		}
		List<String> s12 = new ArrayList<String>();
		s12.addAll(map.keySet());
		Collections.sort(s12, new Mixing());
		for (String ss : s12) {
			String frq = map.get(ss);
			result2 += frq + ":" + ss + "/";
		}
		String intArray[] = result2.split("\\/");
		int n = intArray.length;
		String temp = "";
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (intArray[j - 1].length() == intArray[j].length()) {
					// swap the elements!
					if ((intArray[j - 1].charAt(0) == '1' && (intArray[j].charAt(0) == '1'
							| intArray[j].charAt(0) == '=' | intArray[j].charAt(0) == '2'))
							| (intArray[j - 1].charAt(0) == '2'
									&& (intArray[j].charAt(0) == '2' | intArray[j].charAt(0) == '='))
							| (intArray[j - 1].charAt(0) == '=' && intArray[j].charAt(0) == '='))
						continue;
					else {
						temp = intArray[j - 1];
						intArray[j - 1] = intArray[j];
						intArray[j] = temp;
					}
				}
			}
		}
		String ss = "";
		ss = String.join("/", intArray);
		return ss;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(mix("Are they here", "yes, they are here")); }
	 */
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() > o2.length())
			return -1;
		else if (o1.length() < o2.length())
			return 1;
		return o1.compareTo(o2);
	}
	
	public static void main(String[] args) {
		System.out.println(mix("Are they here", "yes, they are here"));
	}
}
