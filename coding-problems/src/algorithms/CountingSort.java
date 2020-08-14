/**
 * For simplicity, consider the data in the range 0 to 9. 
 * Input data: 1, 4, 1, 2, 7, 5, 2
 *   1) Take a count array to store the count of each unique object.
 *   Index:     0  1  2  3  4  5  6  7  8  9
 *   Count:     0  2  2  0   1  1  0  1  0  0
 * 
 *   2) Modify the count array such that each element at each index 
 *   stores the sum of previous counts. 
 *   Index:     0  1  2  3  4  5  6  7  8  9
 *   Count:     0  2  4  4  5  6  6  7  7  7
 * 
 * The modified count array indicates the position of each object in 
 * the output sequence.
 *  
 *   3) Output each object from the input sequence followed by 
 *   decreasing its count by 1.
 *   Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
 *   Put data 1 at index 2 in output. Decrease count by 1 to place 
 *   next data 1 at an index 1 smaller than this index
 *   
 *   
 */
package algorithms;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] result = countingSortNonNegativeIntegers(new int[] {1, 4, 1, 2, 5, 7, 2});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		System.out.println();
		
		result = countingSortWithNegativeIntegers(new int[] {-5, -10, 0, -3, 8, 5, -1, 10});
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] countingSortNonNegativeIntegers(int[] arr) {
		int n = arr.length;
		int[] outArr = new int[n];
		int[] count = new int[10];
		for(int i = 0; i < n; i++) {
			++count[arr[i]];
		}
		
		for(int i = 1; i <= 9; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = 0; i < n; i++) {
			outArr[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}
		
		return outArr;
	}
	
	/**
	 * We have negative numbers in it. Because there are no negative array 
	 * indices. So what we do is, we find the minimum element and 
	 * we will store count of that minimum element at zero index
	 * 
	 * Time Complexity O(N)
	 * 
	 * @param arr
	 * @return
	 */

	public static int[] countingSortWithNegativeIntegers(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int[] count = new int[range];
		int[] outArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = 0; i < arr.length; i++) {
			outArr[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}
		
		return outArr;
	}
}
