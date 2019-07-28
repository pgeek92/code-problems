/**
 * AMAZON
 * 
 * Given an integer an N. The task is to print the position of first set bit found 
 * from right side in the binary representation of the number.
 * 
 * Input:
 * The first line of the input contains an integer T, denoting the number of test cases. 
 * Then T test cases follow. The only line of the each test case contains an integer N.
 * 
 * Output:
 * For each test case print in a single line an integer denoting the position of the 
 * first set bit found form right side of the binary representation of the number. 
 * If there is no set bit print "0".
 * 
 * Constraints:
 * 1 <= T <= 200
 * 0 <= N <= 106
 * 
 * Example:
 * Input:
 * 2
 * 18
 * 12
 * 
 * Output:
 * 2
 * 3
 * 
 * Explanation:
 * Binary representation of the 18 is 010010, the first set bit from the right 
 * side is at position 2.
 */
package datastructures.BITManipulation;

import java.util.*;

class Program1 {
    public static int INT_SIZE = 32;
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int noOfTests = in.nextInt();
			int[] values = new int[noOfTests];
			for(int i = 0; i < values.length; i++) {
				values[i] = in.nextInt();
			}
			for(int i = 0; i < values.length; i++) {
				System.out.println(getFirstSetBit(values[i]));
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
