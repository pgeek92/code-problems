/**
 * For two strings A and B, we define the similarity 
 * of the strings to be the length of the longest prefix 
 * common to both strings. For example, the similarity of 
 * strings "abc" and "abd" is 2, while the similarity of 
 * strings "aaa" and "aaab" is 3.
 * 
 * Calculate the sum of similarities of a string S with each of it's suffixes.
 * 
 * Input Format
 * 
 * The first line contains the number of test cases t. 
 * Each of the next t lines contains a string to process, .
 * 
 * Constraints
 * 1 <= t <= 10
 * 1 <= |S| <= 100000 
 * S is composed of characters in the range ascii[a-z]
 * Output Format
 * 
 * Output t lines, each containing the answer for the corresponding test case.
 * 
 * Sample Input
 * 2
 * ababaa  
 * aa
 * 
 * Sample Output
 * 11  
 * 3
 * Explanation
 * 
 * For the first case, the suffixes of the string are "ababaa", "babaa", 
 * "abaa", "baa", "aa" and "a". The similarities of these strings with the 
 * string "ababaa" are 6,0,3,0,1, & 1 respectively. Thus, 
 * the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.
 * 
 * For the second case, the answer is 2 + 1 = 3.
 * */

package company.nearbuy;

import java.util.Scanner;

public class UsernameDisparity {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while(tc--> 0) {
			String s = in.next();
			int[] zArr = calculateZArray(s.toCharArray());
			int sum = s.length();
			for(int i = 0; i < zArr.length; i++) {
				sum += zArr[i];
			}
			System.out.println(sum);
		}
	}

	public static int[] calculateZArray(char[] input) {
		int[] zArr = new int[input.length];
		int left = 0;
		int right = 0;
		for (int k = 1; k < input.length; k++) {
			if (k > right) {
				left = right = k;
				right = repeatableCode(input, zArr, left, right, k);
			} else {
				// We're operating inside zArr box
				int k1 = k - left;
				// if value doesn't stretches till right bound then just copy it. Just to reduce
				// comparisons
				if (zArr[k1] < right - k + 1) {
					zArr[k] = zArr[k1];
				} else { // otherwise try to see of there are more matches
					left = k;
					right = repeatableCode(input, zArr, left, right, k);
				}
			}
		}
		return zArr;
	}

	private static int repeatableCode(char[] input, int[] zArr, int left, int right, int k) {
		while (right < input.length && input[right] == input[right - left]) {
			right++;
		}
		zArr[k] = right - left;
		right--;
		return right;
	}
}
