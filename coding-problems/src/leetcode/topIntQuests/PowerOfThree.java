/**
 * Given an integer, write a function to determine if it is a power of three.
 */
package leetcode.topIntQuests;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThreeA(27));
		System.out.println(isPowerOfThreeB(27));
		System.out.println(isPowerOfThreeC(27));
	}
	
	/**
	 * Simple Naive approach
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThreeA(int n) {
		if(n == 1) return true;
		
		boolean result = false;
		while(n > 0) {
			int rem = n%3;
			if(rem == 0) {
				n /= 3;
				if(n == 1) {
					return true;
				}
			} else {
				return false;
			}
		}
		
		return result;
	}
	
	/**
	 * Recursive approach
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThreeB(int n) {
		if(n == 0) 
	        return false;
	 
	    if(n == 1) 
	        return true;
	 
	    if(n > 1) 
	        return n%3==0 && isPowerOfThreeB(n/3);
	    else
	        return false;
	}
	
	/**
	 * Fastest Approach
	 * 
	 * n is of type int. In Java, this means it is a 4 byte, signed integer. The 
	 * maximum value of this data type is 2147483647. System.out.println(Integer.MAX_VALUE)
	 * 
	 * Maximum value of n, that's also a power of 3 is 1162261467 = 3^19
	 * so, 3 is a prime number, the only divisors of 3^19 are 3^0, 3^1, ...., 3^19, so we need to
	 * check if 3^19 is divisible by n or not
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThreeC(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

}
