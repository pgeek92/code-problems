/**
 * Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, 
 * if the given number is 23 (00010111), it should be converted to 43(00101011). Here, 
 * every even position bit is swapped with adjacent bit on right side(even position bits are highlighted in binary 
 * representation of 23), and every odd position bit is swapped with adjacent on left side.
 * 
 * Input:
 * The first line of input contains T, denoting the number of testcases. Each testcase contains single line.
 * 
 * Output:
 * For each testcase in new line, print the converted number.
 * 
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100
 * 
 * Example:
 * Input:
 * 2
 * 23
 * 2
 * 
 * Output:
 * 43
 * 1
 * 
 * Explanation:
 * Testcase 1: BInary representation of the given number; 00010111 after swapping 00101011
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int T = in.nextInt();
			while(T --> 0) {
				int N = in.nextInt();
				int evenBits = N & 0xAAAA;
				int oddBits = N & 0x5555;
				evenBits >>= 1;
				oddBits <<= 1;
				System.out.println(evenBits | oddBits);
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
}
