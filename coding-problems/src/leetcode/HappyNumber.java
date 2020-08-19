/**
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the 
 * sum of the squares of its digits, and repeat the process until 
 * the number equals 1 (where it will stay), or it loops endlessly in 
 * a cycle which does not include 1. Those numbers for which this process 
 * ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example: 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappyUsingHashSet(116));
	}
	
	/**
	 * Simplest approach, without using any extra space
	 * A number cannot be a happy number if, at any step, the sum of the 
	 * square of digits obtained is a single-digit number except 1 or 7. 
	 * This is because 1 and 7 are the only single-digit happy numbers
	 * 
	 * Time Complexity : O(log N)
	 * Space Complexity : O(1)
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		if(n == 1 || n == 7) {
			return true;
		}
		int sum = n, x = n;
		
		while (sum > 9) {
			sum = 0;
			while (x > 0) {
				int d = x%10;
				sum += d*d;
				x /= 10;
			}
			
			if(sum == 1) {
				return true;
			} 
			x = sum;
		}
		
		if(sum == 7) {
			return true;
		}
		return false;
	}

	/**
	 * Time Complexity : O(log N)
	 * Space Complexity : O(log N)
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isHappyUsingHashSet(int n) {
		Set<Integer> seen = new HashSet<Integer>();
		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getNext(n);
		}
		return n == 1;
	}
	
	public static int getNext(int n) {
		int total = 0;
		while (n > 0) {
			int d = n % 10;
			n /= 10;
			total += d * d;
		}
		return total;
	}
	
	/**
	 * Time Complexity : O(log N)
	 * Space Complexity : O(1)
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isHappyNumberUsingFloydAlgo(int n) {
		int slowRunner = n;
		int fastRunner = getNext(n);
		while (fastRunner != 1 && slowRunner != fastRunner) {
			slowRunner = getNext(slowRunner);
			fastRunner = getNext(getNext(fastRunner));
		}
		
		return fastRunner == 1;
	}
}
