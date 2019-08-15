/**
 * https://leetcode.com/articles/missing-number/
 */
package leetcode;

public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] {1, 2, 3}));
	}
	
	public static int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
