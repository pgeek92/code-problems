/**
 * https://practice.geeksforgeeks.org/problems/value-equal-to-index-value/0
 */
package datastructures.Array;

import java.util.Scanner;

public class ValueEqualToIndexValue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for(int i = 0; i < noOfTests; i++) {
			int sizeOfArray = in.nextInt();
			int[] array = new int[sizeOfArray];
			int count = 0;
			for(int j = 0; j < sizeOfArray; j++) {
				array[j] = in.nextInt();
			}
			
			for(int k = 0; k < sizeOfArray; k++) {
				if(array[k] == k+1) {
					System.out.print(k+1 + " ");
				} else {
					count++;
				}
			}
			if(count == sizeOfArray) {
				System.out.print("Not Found");
			}
			System.out.println();
		}
		in.close();
	}
}
