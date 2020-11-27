package leetcode.topIntQuests;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {

	public static void main(String[] args) {
		System.out.println(naiveSoln(new int[] {3, 4, 7, 2, -3, 1, 4, 2}, 7));
		System.out.println(optimizedSoln(new int[] {3, 4, 7, 2, -3, 1, 4, 2}, 7));
	}
	
	/**
	 * Time complexity : O(n*n) We need to consider every subarray possible.
	 * Space complexity : O(1). Constant space is used.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int naiveSoln(int[] nums, int k) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum == k) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Time complexity : O(n). The entire nums array is traversed only once.
	 * 
	 * Space complexity : O(n). Hashmap map can contain upto n distinct entries in the worst case.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int optimizedSoln(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int count = 0, sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
