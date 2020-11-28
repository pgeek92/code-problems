package datastructures.Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {

	public static void main(String[] args) {
		System.out.println(naiveSoln(new int[] {10, 20, 10, 30}));
		Integer[] arr = Arrays.stream(new int[] {10, 20, 10, 30}).boxed().toArray(Integer[] :: new);
		System.out.println(optimizedSoln(arr));
	}
	
	/**
	 * Time Complexity : O(N*N)
	 * Space Complexity : O(1)
	 * 
	 * @param arr
	 * @return
	 */
	private static int naiveSoln(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param arr
	 * @return
	 */
	private static int optimizedSoln(Integer[] arr) {
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));
		return s.size();
	}

}
