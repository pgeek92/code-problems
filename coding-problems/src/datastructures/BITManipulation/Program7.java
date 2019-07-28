/**
 * Given a number N. The task is to find the length of the longest consecutive 1s in its binary representation.
 * 
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
 * Each test case contains an integer N.
 * 
 * Output:
 * For each test case, in a new line, print the length of the longest consecutive 1's in N's binary representation.
 * 
 * Constraints:
 * 1 <= T < 100
 * 1 <= N <= 103
 * 
 * Example:
 * Input:
 * 2
 * 14
 * 222
 * 
 * Output:
 * 3 
 * 4
 * 
 * Explanation:
 * Testcase 1: Binary representation of 14 is 1110, in which 111 is the longest consecutive set bits and length is 3.
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int T = in.nextInt();
			while(T --> 0) {
				int N = in.nextInt();
				System.out.println(maxConsecutiveOnes(N));
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static int maxConsecutiveOnes(int num) {
		int count = 0;
		while(num != 0) {
			num = (num & (num << 1));
			count++;
		}
		return count;
	}

}
