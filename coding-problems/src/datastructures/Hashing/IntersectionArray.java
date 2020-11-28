package datastructures.Hashing;

import java.util.HashSet;
import java.util.Set;

public class IntersectionArray {

	public static void main(String[] args) {
		int[] arr1 = new int[] {10, 15, 20, 15, 30, 30, 5};
		int[] arr2 = new int[] {30, 5, 30, 80};
		System.out.println(optimizedSoln(arr1, arr2));

	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static int optimizedSoln(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		int count = 0;
		for(int j = 0; j < arr2.length; j++) {
			if(set.contains(arr2[j])) {
				count++;
				set.remove(arr2[j]);
			}
		}
		return count;
	}

}
