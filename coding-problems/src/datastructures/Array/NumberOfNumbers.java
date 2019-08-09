/**
 * https://practice.geeksforgeeks.org/problems/find-number-of-numbers/1
 */
package datastructures.Array;

import java.util.Scanner;

public class NumberOfNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		while (noOfTests --> 0) {
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			for(int i = 0; i < arraySize; i++) {
				array[i] = in.nextInt();
			}
			int k = in.nextInt();
			System.out.println(num(array, arraySize, k));
		}
		in.close();
	}
	
	public static int num (int[] array, int arraySize, int k) {
		int count = 0;
		for(int i = 0; i < arraySize; i++) {
			while(array[i] != 0) {
				int rem = array[i]%10;
				array[i] = array[i]/10;
				if(rem == k) {
					count++;
				}
			}
		}
		return count;
	}
}
