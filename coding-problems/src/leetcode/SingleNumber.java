/**
 * Given a non-empty array of integers, every element appears twice 
 * except for one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(approachOne(new int[] {2, 2, 1}));
		System.out.println(approachTwo(new int[] {2, 2, 1}));
		System.out.println(approachThree(new int[] {2, 2, 1}));
		System.out.println(approachFour(new int[] {2, 2, 1}));
	}

	/**
	 * Very simple technique, Time Complexity : O(N*N)
	 * Space Complexity : O(N)
	 * 
	 * @param arr
	 * @return
	 */
	public static int approachOne(int[] arr) {
		int arrLength = arr.length;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i : arr) {
			if(!list.contains(i)) {
				list.add(i);
			} else {
				list.remove(new Integer(i));
			}
		}
		
		return list.get(0);
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param arr
	 * @return
	 */
	public static int approachTwo(int[] arr) {
		HashMap<Integer, Integer> mapKeyCount = new HashMap<Integer, Integer>();
		for(int i : arr) {
			mapKeyCount.put(i, mapKeyCount.getOrDefault(i, 0) + 1);
		}
		
		for(int i : arr) {
			if(mapKeyCount.get(i) == 1) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Simple Math Approach : 2 * (a + b + c) - (a + a + b + b + c) = c 
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param arr
	 * @return
	 */
	public static int approachThree(int[] arr) {
		int sumOfSet = 0, sumOfNums = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i : arr) {
			if(!set.contains(i)) {
				set.add(i);
				sumOfSet += i;
			}
			sumOfNums += i;
		}
		return 2 * sumOfSet - sumOfNums;
	}
	
	/**
	 * Bit Manipulation Approach : 
	 * 
	 * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
	 * 
	 * Space Complexity : O(1)
	 * Time Complexity : O(N)
	 * 
	 * @param arr
	 * @return
	 */
	public static int approachFour(int[] arr) {
		int temp = 0;
		for(int i : arr) {
			temp ^= i;
		}
		return temp;
	}	
}
