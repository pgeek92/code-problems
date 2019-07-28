/**
 * ADOBE, INTEL, MICROSOFT, SAMSUNG, ORACLE
 * 
 * Given a positive integer N. The task is to check if N is a power of 2. That is N is 2x for some x.
 * 
 * Input:
 * The first line contains T denoting the number of test cases. Each test case contains a single positive integer N.
 * 
 * Output:
 * Print "YES" if it is a power of 2 else "NO" (Without the double quotes).
 * 
 * Constraints:
 * 1 <= T <= 100
 * 0 <= N <= 1018
 * 
 * Example:
 * Input :
 * 2
 * 1
 * 98
 * 
 * Output :
 * YES
 * NO
 * 
 * Explanation:
 * Testcase 1:  1 is equal to 2 raised to 0 (20 == 1).
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			long T = in.nextLong();
			while(T --> 0) {
				long N = in.nextLong();
				if(N > 1 && ((long)(N & (N-1)) == 0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}

}
