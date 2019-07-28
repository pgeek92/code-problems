/**
 * Given a number N, check whether it is sparse or not. A number is said to be a sparse number 
 * if in the binary representation of the number no two or more consecutive bits are set.
 * 
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is number 'N'.
 * 
 * Output:
 * Print '1' if the number is sparse and '0' if the number is not sparse.
 * 
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 * 
 * Example:
 * Input:
 * 2
 * 2
 * 3
 * 
 * Output:
 * 1
 * 0
 * 
 * Explanation:
 * Testcase 1: Binary Representation of 2 is 10, which is not having consecutive set bits. So, it is sparse number.
 * Testcase 2: Binary Representation of 3 is 11, which is having consecutive set bits in it. So, it is not a sparse number.
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int noOfTests = in.nextInt();
			int[] outputArr = new int[noOfTests];
			for(int i = 0; i < noOfTests; i++) {
				int N = in.nextInt();
				outputArr[i] = checkSparse(N); 
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
	
	public static int checkSparse(int num) {
		if((num & (num >> 1)) >= 1) {
			return 0;
		} else {
			return 1;
		}
	}
}
