/**
 * https://practice.geeksforgeeks.org/problems/greater-on-right-side/0
 */
package datastructures.Array;

import java.util.Scanner;

public class GreaterOnRightSide {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		while(noOfTests --> 0) {
			int arraySize = in.nextInt();
			int[] array = new int[arraySize];
			for(int i = 0; i < arraySize; i++) {
				array[i] = in.nextInt();
			}
			greaterOnRightSide(array, arraySize);
			printArray(array, arraySize);
		}
		in.close();
	}
	
	public static void printArray(int[] array, int arraySize) {
		for(int i = 0; i < arraySize; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] greaterOnRightSide(int[] array, int arraySize) {
		int max = 0;
	     for(int j = 0;j < arraySize-1; j++){
	         max = array[j+1];
	         for(int k = j+1; k < arraySize-1; k++){
	             if(array[k+1] > max){
	                 max = array[k+1];
	             }
	         }
	         array[j] = max;
	     }
	     array[arraySize-1] = -1;
	     return array;
	}
}
