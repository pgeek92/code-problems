package leetcode;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * 
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * 
 * Example 1:
 * 
 * Input: 
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation: 
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *  
 * 
 * Example 2:
 * 
 * Input: 
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation: 
 * There is no index that satisfies the conditions in the problem statement.
 *  
 * 
 * Note:
 * 
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 * 
 * @author Prashant
 *
 */
public class PivotIndex {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(pivotIndex(nums));
		System.out.println(efficientSolution(nums));
	}

	public static int pivotIndex(int[] nums) {
		int pivotIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			int sumL = 0;
			int sumR = 0;
			for (int j = 0; j <= i - 1; j++) {
				sumL += nums[j];
			}
			for (int k = i + 1; k < nums.length; k++) {
				sumR += nums[k];
			}

			if (sumL == sumR) {
				pivotIndex = i;
				break;
			}
		}
		return pivotIndex;
	}
	
	/**
	 * O(N) time and O(1) space
	 * @param nums
	 * @return
	 */
	public static int efficientSolution(int[] nums) {
		int sum = 0;
		int sumL = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		for(int i = 0; i < nums.length; i++) {
			sum -= nums[i]; // getting right sum for index 'i'
			
			if(sumL == sum) {
				return i;
			}
			
			sumL += nums[i];
		}
		return -1;
	}

}
