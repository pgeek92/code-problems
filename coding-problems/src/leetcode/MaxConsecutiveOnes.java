/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
package leetcode;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,1,1,0,1}));
	}
	
	/**
	 * Algorithm : One Pass
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param nums
	 * @return
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxCount = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) { 
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		
		return Math.max(maxCount, count);
	}

}
