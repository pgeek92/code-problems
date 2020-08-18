/**
 * This is a follow up problem of H Index Part I
 */
package leetcode;

public class HIndexPartTwo {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] {0,1,2,5,6}));
	}
	
	public static int hIndex(int[] arr) {
		int n = arr.length;
	    int mid, left = 0, right = n - 1;
	    while (left <= right) {
	    	mid = left + (right - left) / 2;
	    	if (arr[mid] == n - mid) 
	    		return n - mid;
	    	else if (arr[mid] < n - mid) 
	    		left = mid + 1;
	    	else 
	    		right = mid - 1;
	    }
	    return n - left;
	}
}
