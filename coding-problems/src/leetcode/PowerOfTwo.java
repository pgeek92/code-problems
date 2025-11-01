/**
 * https://leetcode.com/problems/power-of-two/description/
 */
package leetcode;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwoA(1));
		System.out.println(isPowerOfTwoA(16));
		System.out.println(isPowerOfTwoA(3));
		
		System.out.println(isPowerOfTwoB(1));
		System.out.println(isPowerOfTwoB(16));
		System.out.println(isPowerOfTwoB(3));
		
		System.out.println(isPowerOfTwoC(1));
		System.out.println(isPowerOfTwoC(16));
		System.out.println(isPowerOfTwoC(3));

	}
	
	/**
	 * Approach : Recursion
	 * Time Complexity : O(log n)
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwoA(int n) {
		if(n == 1) {
			return true;
		} else if ((n % 2 != 0) || n < 1) {
			return false;
		}
		return isPowerOfTwoA(n/2);
		
	}
	
	/**
	 * Approach : Bit Manipulation
	 * Time Complexity : O(1)
	 * Space Complexity : O(1)
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwoB(int n) {
		if(n <= 0) {
			return false;
		}
		return (n & (-n)) == n;
	}
	
	/**
	 * Approach : Bit Manipulation
	 * Time Complexity : O(1)
	 * Space Complexity : O(1)
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwoC(int n) {
		if(n <= 0) {
			return false;
		}
		return (n & (n-1)) == 0; 
	}

}
