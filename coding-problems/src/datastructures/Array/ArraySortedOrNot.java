/**
 * https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted/0
 */
package datastructures.Array;

import java.util.Scanner;

public class ArraySortedOrNot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for(int i = 0; i < noOfTests; i++) {
			int sizeOfArray = in.nextInt();
			int[] array = new int[sizeOfArray];
			int flag = 1;
			for(int j = 0; j < sizeOfArray; j++) {
				array[j] = in.nextInt();
			}
			
			for(int k = 0; k < sizeOfArray-1; k++) {
				if(!(array[k+1] >= array[k])) {
					flag = 0;
					break;
				}
			}
			System.out.println(flag);
		}
		in.close();
	}

}
