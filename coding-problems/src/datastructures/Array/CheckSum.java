/**
 * In this problem, you have to implement the int[] findSum(int[] arr, int n) 
 * method, which will take a number n, and an array arr as input and returns 
 * an array of two integers that add up to n in an array. 
 * You are required to return only one such pair. 
 * If no such pair found then simply return the array
 * 
 */
package datastructures.Array;

import java.util.LinkedHashSet;

public class CheckSum {

	public static void main(String[] args) {
		int n = 9;
		int[] arr = new int[] {2, 4, 5, 7, 8};
		if(arr.length > 0) {
			int[] result = findSum(arr, n);
			
			if((result[0] + result[1]) != n) {
				System.out.println("Not Found");
			} else {
				System.out.println("Number 1 : " + result[0]);
				System.out.println("Number 2 : " + result[1]);
				System.out.println("Sum : " + (n));
			}
		} else {
			System.out.println("Input Array is Empty !");
		}
		
		System.out.println(findSumTwoPointer(null, 9));
		System.out.println(findSumTwoPointer(new int[] {2}, 9));
		System.out.println(findSumTwoPointer(new int[] {-3, 0, 1, 2, 7, 8, 10}, 9));
		
		System.out.println(findSumHashing(new int[] {-3, 0, 1, 2, 7, 8, 10}, 9));
	}
	
	/**
	 * Time Complexity : O(n*n)
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] findSum(int[] arr, int n) {
		int[] result = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == n) {
					result[0] = arr[i];
					result[1] = arr[j];
					return result;
				}
			}
		}
		return arr;
	}
	
	/**
	 * Two Pointer approach (but in this approach, Array should be sorted one)
	 * or, if given array is unsorted, then we need to sort an array either using
	 * MergeSort, HeapSort or QuickSort according to minimum time complexity
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static String findSumTwoPointer(int[] arr, int n) {
		if(arr == null) {
			return "()";
		}
		
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int currentSum = arr[left] + arr[right];
			if(currentSum < n) {
				left++;
			} else if (currentSum > n) {
				right--;
			} else {
				return "(" + arr[left] + ", " + arr[right] + ")";
			}
		}
		
		return "()";
	}
	
	/**
	 * Best approach is to use Hashing technique, where Time Complexity is O(N), Auxiliary Space is O(N)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static String findSumHashing(int[] arr, int n) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(set.contains(n - arr[i])) {
				return "(" + arr[i] + ", " + (n - arr[i]) + ")";
			}
			set.add(arr[i]);
		}
		
		return "()";
	}
}
