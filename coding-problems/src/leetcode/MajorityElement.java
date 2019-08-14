/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than floor(n/2) times.
 * 
 * You may assume that the array is non-empty and the majority element 
 * always exist in the array.
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = new int[] {3, 2, 3};
		System.out.println(bruteForceApproach(nums));
		System.out.println(hashMapApproach(nums));
		System.out.println(boyerMooreVootingAlgorithm(nums));
	}
	
	/**
	 * Time Complexity : O(N^2)
	 * Space Complexity : O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static int bruteForceApproach(int[] nums) {
		int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }
        return -1;  
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * @param nums
	 * @return
	 */
	public static int hashMapApproach(int[] nums) {
		int elementIndex = 0;
        Map<Integer, Integer> valueToOccurenceMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(valueToOccurenceMap.containsKey(nums[i])) {
                int count = valueToOccurenceMap.get(nums[i])+1;
                if(count > nums.length / 2) {
                    elementIndex = i;
                    break;
                } else {
                    valueToOccurenceMap.put(nums[i], count);
                }
            } else {
                valueToOccurenceMap.put(nums[i], 1);    
            }
        }
        return nums[elementIndex];
	}
	
	/**
	 * If the elements are sorted in monotonically increasing (or decreasing) order, the majority 
	 * element can be found at index floor(n/2) (and floor(n/2) + 1, if n is even).
	 * 
	 * Time Complexity : O(nlogn)
	 * Space Complexity : O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static int sortingApproach(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * ALGORITHM : Boyer Moore Vooting Algorithm
	 * 
	 * Basic idea of the algorithm is that if we cancel out each 
	 * occurrence of an element e with all the other elements that are 
	 * different from e then e will exist till end if it is a majority 
	 * element
	 * 
	 * @param nums
	 * @return
	 */
	public static int boyerMooreVootingAlgorithm(int[] nums) {
		int cand = findCandidate(nums);
		if(isMajority(nums, cand)) {
			return cand;
		} else {
			return -1;
		}
	}
	
	public static int findCandidate(int nums[])  
    { 
        int maj_index = 0, count = 1; 
        int i; 
        for (i = 1; i < nums.length; i++)  
        { 
            if (nums[maj_index] == nums[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                maj_index = i; 
                count = 1; 
            } 
        } 
        return nums[maj_index]; 
    } 
  
    /* Function to check if the candidate occurs more 
       than n/2 times */
    public static boolean isMajority(int nums[], int cand)  
    { 
        int i, count = 0; 
        for (i = 0; i < nums.length; i++)  
        { 
            if (nums[i] == cand) 
                count++; 
        } 
        if (count > nums.length / 2)  
            return true; 
        else
            return false; 
    }

}
