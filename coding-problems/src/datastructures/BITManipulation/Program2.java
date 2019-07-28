/**
 * Given two numbers M and N. The task is to find the position of rightmost 
 * different bit in binary representation of numbers.
 * 
 * Input:
 * The input line contains T, denoting the number of testcases. 
 * Each testcase follows. First line of each testcase contains two space 
 * separated integers M and N.
 * 
 * Output:
 * For each testcase in new line, print the position of rightmost 
 * different bit in binary representation of numbers. If both M and N 
 * are same then print -1 in this case.
 * 
 * Constraints:
 * 1 <= T <= 100
 * 1 <= M <= 103
 * 1 <= N <= 103
 * 
 * Example:
 * Input:
 * 2
 * 11 9
 * 52 4
 * 
 * Output:
 * 2
 * 5
 * 
 * Explanation:
 * Binary representaion of the given numbers are: 1011 and 1001, 
 * 2nd bit from right is different.
 * 
 */
package datastructures.BITManipulation;

import java.util.Scanner;

public class Program2 {
	public static int INT_SIZE = 32;
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int noOfTests = in.nextInt();
			int M = 0;
			int N = 0;
			int[] outputValues = new int[noOfTests];
			for(int i = 0; i < noOfTests; i++) {
				M = in.nextInt();
				N = in.nextInt();
				outputValues[i] = getFirstSetBit(M ^ N);
			}
			for(int i = 0; i < outputValues.length; i++) {
				System.out.println(outputValues[i]);
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static int getFirstSetBit(int value){
	    if(value == 0) {
	        return 0;
	    } else {
	        int pos = 1;
	        for(int i = 0; i < INT_SIZE; i++) {
	            if((value & (1 << i)) == 0) {
	                pos++;
	            } else {
    	            break;
	            }
	        }
	        return pos;    
	    }
	}
}
