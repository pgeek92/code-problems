package datastructures.Hashing;

import java.util.HashSet;
import java.util.Set;

public class UnionArray {

	public static void main(String[] args) {
		int[] arr1 = new int[] {15, 20, 5, 15};
		int[] arr2 = new int[] {15, 15, 15, 5, 20, 10};
		System.out.println(unionArr(arr1, arr2));
	}
	
	/**
	 * Time complexity : O(M+N)
	 * Space Complexity : O(M+N)
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static int unionArr(int[] arr1, int[] arr2) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		for(int j = 0; j < arr2.length; j++) {
			set.add(arr2[j]);
		}
		
		return set.size();
	}

}
