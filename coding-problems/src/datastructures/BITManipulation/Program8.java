/**
 * You are given a decimal number n. You need to find the gray code of the number n and conver it into decimal.
 * To see how it's done, refer here.
 * 
 * Input:
 * The first line contains an integer T, the number of test cases. For each test case, there is an integer n denoting the number
 * 
 * Output:
 * For each test case, the output is gray code equivalent of n.
 * 
 * Constraints:
 * 1 <= T <= 100
 * 0 <= n <= 108
 * 
 * Example:
 * Input
 * 2
 * 7
 * 10
 * Output
 * 4
 * 15
 * 
 * Explanation:
 * Testcase1: 7 is represented as 111 in binary form. The gray code of 111 is 100, in the binary form whose decimal equivalent is 4.
 * 
 * Testcase2: 10 is represented as 1010 in binary form. The gray code of 1010 is 1111, in the binary form whose decimal equivalent 
 * is 15.
 * 
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int T = in.nextInt();
			while(T --> 0) {
				int N = in.nextInt();
				System.out.println(N ^ (N >> 1));
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
}
