/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
package leetcode;

public class MergeSortedArray {

	public static void main(String[] args) {
		merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
	}
	
	/**
	 * Algorithm : 3 Pointers Approach (Start from the end)
	 * Time Complexity : O(m+n)
	 * Space Complexity : O(1)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m-1;
		int p2 = n-1;
		
		for(int p = m + n - 1; p >= 0; p--) {
			if(p2 < 0) {
				break;
			}
			
			if(p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p] = nums1[p1];
				p1--;
			} else {
				nums1[p] = nums2[p2];
				p2--;
			}
		}
		
		for(Integer i : nums1) {
			System.out.println(i);
		}
	}
}
