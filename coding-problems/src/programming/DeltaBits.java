/**
 * Write a function convertBits to determine the number of bits required to convert 
 * positive integer A to positive integer B.
 * 
 * For example, you can change 31 to 14 by flipping the 4th and 0th bit:
 * 
 * 31  0 0 0 1 1 1 1 1
 * 14  0 0 0 0 1 1 1 0
 * ---  ---------------
 * bit  7 6 5 4 3 2 1 0
 * Thus 31 and 14 should return 2.
 * 
 */

package programming;

public class DeltaBits {

	public static void main(String[] args) {
		System.out.println(convertBits(1, 2));
	}

	public static int convertBits(int a, int b) {
		int bitwiseExclusive = a ^ b;
		return Integer.bitCount(bitwiseExclusive);
	}
}
