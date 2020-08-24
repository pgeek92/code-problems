package datastructures.BITManipulation;

public class CountSetBits {

	public static void main(String[] args) {
		System.out.println(countSetBits(254));
		System.out.println(countSetBitsBrianKernighanAlgo(254));
		
		// Used in built method to count no of set bits in a given number
		System.out.println(Integer.bitCount(254));
	}
	
	/**
	 * Time Complexity : Theta (log N)
	 * Space Complexity : O(1)
	 * 
	 * @param num
	 * @return
	 */
	public static int countSetBits(int num) {
		int count = 0;
		while (num > 0) {
			count += num & 1;
			num >>= 1;
		}
		
		return count;
	}
	
	/**
	 * Time Complexity : O(log N)
	 * Space Complexity : O(1)
	 * 
	 * @param num
	 * @return
	 */
	public static int countSetBitsBrianKernighanAlgo(int num) {
		int count = 0;
		while (num > 0) {
			num &= (num - 1);
			count++;
		}
		
		return count;
	}
}
