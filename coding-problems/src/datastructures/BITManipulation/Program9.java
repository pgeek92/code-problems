/**
 * Given N in Gray code equivalent. Find its binary equivalent.
 * 
 * Input:
 * The first line contains an integer T, number of test cases. For each test cases, 
 * there is an integer N denoting the number in gray equivalent.
 * 
 * Output:
 * For each test case, in a new line, the output is the decimal equivalent number N of binary form.
 * 
 * Constraints:
 * 1 <= T <= 100
 * 0 <= n <= 108
 * 
 * Example:
 * Input
 * 2
 * 4
 * 15
 * Output
 * 7
 * 10
 * 
 * Explanation:
 * Testcase1. 4 is represented as 100 and its binary equivalent is 111 whose decimal equivalent is 7.
 * Testcase2. 15 is represented as 1111 and its binary equivalent is 1010 i.e. 10 in decimal.
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int T = in.nextInt();
			while(T --> 0) {
				int N = in.nextInt();
				int output = 0;
				for (; N != 0; N = N >> 1) 
					output ^= N;
				System.out.println(output);
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
}
