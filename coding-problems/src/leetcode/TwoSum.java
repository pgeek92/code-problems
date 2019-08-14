/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 6, 3, 8};
		int target = 13;
		int[] outputArray = onePassHashTableApproach(nums, target);
		for(int i = 0; i < 2; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}
	
	/**
	 * Time Complexity : O(N^2) 
	 * Space Complexity : O(1)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] bruteForceApproach(int[] nums, int target) {
		int arrLength = nums.length;
        int[] returnArray = new int[2];
        for(int i = 0; i < arrLength; i++) {
            int diff = target - nums[i];
            for(int j = i+1; j < arrLength; j++) {
                if(nums[j] == diff) {
                    returnArray[0] = i;
                    returnArray[1] = j;
                    break;
                }
            }
        }
        return returnArray;
	}
	
	/**
	 * Time Complexity : O(N) 
	 * Space Complexity : O(N)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] onePassHashTableApproach(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    return new int[2];
	}

}
