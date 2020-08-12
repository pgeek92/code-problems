package datastructures.Array;

import java.util.HashMap;

public class GetPairsCount {

	public static void main(String[] args) {
		System.out.println(getCount(new int[] {1, 5, 7, -1, 5}, 6));
	}
	
	/**
	 * Time Complexity : O(N)
	 * 
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static int getCount(int[] arr, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(!hm.containsKey(arr[i])) {
				hm.put(arr[i], 0);
			}
			hm.put(arr[i], hm.get(arr[i]) + 1);
		}
		
		int count = 0;
		
		// Iterate through each element and increment the 
		// count (Important to see, that every pair will be countet twice)
		for(int i = 0; i < arr.length; i++) {
			if(hm.get(sum - arr[i]) != null) {
				count += hm.get(sum - arr[i]);
			}
			
			// If (arr[i], arr[i]) pair satisfies the condition, then
			// we need to ensure that the count is decreased by one
			// such that the pair (arr[i], arr[i]) will not considered
			if((sum - arr[i]) == arr[i]) {
				count--;
			}
		}
		
		return count/2;
	}

}
