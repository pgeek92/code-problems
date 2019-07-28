/**
 * AMAZON
 * 
 * You are given a number N. Find the total count of set bits for all numbers from 1 
 * to N(both inclusive).
 * 
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. 
 * T testcases follow. The first line of each test case is N.
 * 
 * Output:
 * For each testcase, in a new line, print the total count of all bits.
 * 
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 103
 * 
 * Example:
 * Input:
 * 2
 * 4
 * 17
 * Output:
 * 5
 * 35
 * 
 * Explanation:
 * Testcase1:
 * An easy way to look at it is to consider the number, n = 4:
 * 0 0 0 = 0
 * 0 0 1 = 1
 * 0 1 0 = 1
 * 0 1 1 = 2
 * 1 0 0 = 1
 * Therefore , the total number of bits is 5.
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int noOfTests = in.nextInt();
			int[] outputArr = new int[noOfTests];
			for(int i = 0; i < noOfTests; i++) {
				int N = in.nextInt();
				outputArr[i] = countSetBitsForOneToN(N);
			}
			
			for(int i = 0; i < noOfTests; i++) {
				System.out.println(outputArr[i]);
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static int countSetBitsForOneToN(int N) {
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += countSetBitsOfN(i);
		}
		return sum;
	}
	
	public static int countSetBitsOfN(int number) {
		int count = 0;
		while (number > 0) {
			number = number & (number - 1);
			count++;
		}
		return count;
	}
}
