/**
 * 
 * AMAZON, SAMSUNG
 * 
 * You are given two numbers A and B. Write a program to count number of bits 
 * needed to be flipped to convert A to B.
 * 
 * Input:
 * The first line of input contains an integer T denoting the number of 
 * test cases. T testcases follow. The first line of each test case is A 
 * and B separated by a space.
 * 
 * Output:
 * For each testcase, in a new line, print the number of bits needed to be flipped.
 * 
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ A, B ≤ 103
 * 
 * Example:
 * Input:
 * 1
 * 10 20
 * Output:
 * 4
 * 
 * Explanation:
 * Testcase1:
 * A  = 01010
 * B  = 10100
 * Number of bits need to flipped = set bit count in A XOR B value i.e. 4
 * 
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int noOfTests = in.nextInt();
			int[] outputArr = new int[noOfTests];
			for(int i = 0; i < noOfTests; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				outputArr[i] = countSetBitsOfN(A ^ B);
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
	
	public static int countSetBitsOfN(int number) {
		int count = 0;
		while (number > 0) {
			number = number & (number - 1);
			count++;
		}
		return count;
	}
}
