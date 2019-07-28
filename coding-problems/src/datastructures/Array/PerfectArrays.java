/**
 * https://practice.geeksforgeeks.org/problems/perfect-arrays/0
 */
package datastructures.Array;

import java.util.Scanner;

public class PerfectArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for(int i = 0; i < noOfTests; i++) {
			int sizeOfArray = in.nextInt();
			int[] array = new int[sizeOfArray];
			int flag = 0;
			for(int j = 0; j < sizeOfArray; j++) {
				array[j] = in.nextInt();
			}
			
			for(int k = 0; k < sizeOfArray; k++) {
				if(array[k] != array[sizeOfArray-k-1]) {
					flag = 1;
					break;
				}
			}
			
			System.out.println(flag == 1 ? "NOT PERFECT" : "PERFECT");
		}
		in.close();
	}

}
