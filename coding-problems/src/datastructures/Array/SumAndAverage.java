/**
 * https://practice.geeksforgeeks.org/problems/java-arrays-set-1/0
 */
package datastructures.Array;

import java.util.Scanner;

public class SumAndAverage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for (int i = 0; i < noOfTests; i++) {
			int n = in.nextInt();
			int sum = 0;
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
				sum += arr[j];
			}
			float avg = (float)sum/n;
			System.out.print(sum + " ");
			System.out.printf("%.2f", avg);
			System.out.println();
		}
		in.close();
	}
}
