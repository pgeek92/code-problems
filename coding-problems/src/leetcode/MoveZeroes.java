package leetcode;

public class MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] {1,0,2,3,0});

	}
	
	public static void moveZeroes(int[] nums) {
		int p1 = 0;
		for(int p2 = 0; p2 < nums.length; p2++) {
			if(nums[p2] != 0) {
				nums[p1] = nums[p2];
				p1++;
			}
		}
		for(int p2 = p1; p2 < nums.length; p2++) {
			nums[p2] = 0;
		}
		
		for(Integer i : nums) {
			System.out.println(i);
		}
	}
}
