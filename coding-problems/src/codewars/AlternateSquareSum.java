/**
 * Write a method alternate_sq_sum() (JS: alternateSqSum ) that takes an array of integers as input and finds the sum of squares of the elements at even positions (i.e., 2nd, 4th, etc.) plus the sum of the rest of the elements at odd position.
 * 
 * NOTE:
 * The values at even position need to be squared. For a language with zero-based indices, this will occur at oddly-indexed locations. For instance, in Python, the values at indices 1, 3, 5, etc. should be squared because these are the second, fourth, and sixth positions in the list.
 * 
 * For Example:
 * alternateSqSum(new int[] {11, 12, 13, 14, 15}) // should return 379
 * Explanation:
 * Elements at indices 0, 2, 4 are 11, 13, 15 and they are at odd positions as 11 is at position #1, 13 is at position #3 and 15 at #5.
 * 
 * Elements at indices 1, 3 are 12 and 14 and they are at even position. So we need to add 11, 13, 15 as they are and square of 12 and 14
 * 
 * --> 11 + 13 + 15 + 12^2 + 14^2
 * = 11 + 13 + 15 + 144 + 196
 * = 379
 * 
 * For empty arrays, result should be 0 (zero)
 *  
 */

package codewars;

public class AlternateSquareSum {

	public static void main(String[] args) {
		System.out.println(alternateSqSum(new int[] {11, 12, 13, 14, 15}));
	}

	public static int alternateSqSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0)
				sum = sum + arr[i] * arr[i];
			else
				sum += arr[i];
		}
		return sum;
	}

}
