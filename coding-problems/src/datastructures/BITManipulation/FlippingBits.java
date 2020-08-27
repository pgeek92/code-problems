package datastructures.BITManipulation;

public class FlippingBits {

	public static void main(String[] args) {
		System.out.println(flippingBits(11));
	}
	
	/**
	 * Time Complexity : O(log N)
	 * Space Complexity : O(1)
	 * 
	 * @param num
	 * @return
	 */
	public static int flippingBits(int num) {
		int totalBits = (int)(Math.log(num) / Math.log(2));
		int M = 0;
		M = 1 << totalBits;
		M |= M - 1;
		
		return M ^ num;
	}

}
