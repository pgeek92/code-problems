package datastructures.BITManipulation;

public class EqualSumAndXOR {

	public static void main(String[] args) {
		System.out.println(findCount(7));
		System.out.println(findCountEfficient(7));

	}
	
	/**
	 * Naive Approach, Time Complexity : O(N)
	 * 
	 * @param num
	 * @return
	 */
	public static int findCount(int num) {
		int count = 0;
		for(int i = 0; i <= num; i++) {
			if((num + i) == (num ^ i)) {
				count++;
			}
		}
		
		return count;
	}

	/**
	 * Efficient Approach, Time Complexity : O(log N)
	 * 
	 * @param num
	 * @return
	 */
	public static int findCountEfficient(int num) {
		int countUnsetBits = 0;
		while (num > 0) {
			if((num & 1) == 0) {
				countUnsetBits++;
			}
			num >>= 1;
		}
		// Return 2 ^ countUnsetBits
		return 1 << countUnsetBits;
	}
}
