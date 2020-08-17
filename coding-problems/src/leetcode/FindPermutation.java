/**
 * By now, you are given a secret signature consisting of character 'D' 
 * and 'I'. 'D' represents a decreasing relationship between two numbers, 
 * 'I' represents an increasing relationship between two numbers. And our secret signature 
 * was constructed by a special integer array, which contains uniquely all the different 
 * number from 1 to n (n is the length of the secret signature plus 1). 
 * For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], 
 * but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing 
 * special string that can't represent the "DI" secret signature.
 * 
 * On the other hand, now your job is to find the lexicographically smallest permutation of 
 * [1, 2, ... n] could refer to the given secret signature in the input.
 * 
 * Example 1:
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct secret 
 * signature "I", where the number 1 and 2 construct an increasing relationship.
 * 
 * Example 2:
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
 * but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 * Note:
 * 
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 */
package leetcode;

import java.util.Stack;

public class FindPermutation {

	public static void main(String[] args) {
		int[] resultantArr = findPermutationApproachOne("IIDDIIID");
		for(Integer i : resultantArr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		resultantArr = findPermutationApproachTwo("IIDDIIID");
		for(Integer i : resultantArr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		resultantArr = findPermutationApproachThree("IIDDIIID");
		for(Integer i : resultantArr) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * Approach (Stack Data Structure)
	 * 
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param s
	 * @return
	 */
	public static int[] findPermutationApproachOne(String s) {
		int[] resultantArr = new int[s.length() + 1];
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0;
		for(int i = 1; i <= s.length(); i++) {
			if(s.charAt(i-1) == 'I') {
				stack.push(i);
				while(!stack.isEmpty()) {
					resultantArr[j++] = stack.pop();
				}
			} else {
				stack.push(i);
			}
		}
		
		stack.push(s.length() + 1);
		while(!stack.isEmpty()) {
			resultantArr[j++] = stack.pop();
		}
		
		return resultantArr;
	}
	
	/**
	 * Approach (Reverse a subarray)
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * 
	 * @param s
	 * @return
	 */
	public static int[] findPermutationApproachTwo(String s) {
		int[] resultantArr = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            resultantArr[i] = i+1;
        }
        int i = 1;
        while (i <= s.length()) {
            int j = i;
            while (i <= s.length() && s.charAt(i - 1) == 'D') {
                i++;
            }
            reverse(resultantArr, j-1, i);
            i++;
        }
        return resultantArr;
	}
	
	public static void reverse(int[] a, int start, int end) {
		for(int i = 0; i < (end - start) / 2; i++) {
            int temp = a[i+start];
            a[i+start] = a[end-i-1];
            a[end-i-1] = temp;
        }
	}
	
	/**
	 * Approach (Two Pointer technique)
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * 
	 * @param s
	 * @return
	 */
	public static int[] findPermutationApproachThree(String s) {
		int[] res = new int[s.length() + 1];
        res[0]=1;
        int i = 1;
        while (i <= s.length()) {
            res[i]=i+1;
            int j = i;
            if(s.charAt(i-1)=='D')
            {
                while (i <= s.length() && s.charAt(i - 1) == 'D')
                    i++;
                for (int k = j - 1, c = i; k <= i - 1; k++, c--) {
                    res[k] = c;
                }
            }
            else
                i++;
        }
        return res;
	}
}
