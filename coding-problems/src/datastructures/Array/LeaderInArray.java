/**
 * https://www.geeksforgeeks.org/leaders-in-an-array/
 */
package datastructures.Array;

public class LeaderInArray {

	public static void main(String[] args) {
		int[] array = new int[] {5, 3, 20, 15, 8, 3};
		
		simplestApproach(array);
		
		System.out.println();
		
		efficientApproach(array);
		
	}

	/**
	 * This method is taking O(n) time
	 * @param array
	 */
	private static void efficientApproach(int[] array) {
		int maxFromRight = array[array.length-1];
		System.out.print(maxFromRight + " ");
		
		for(int i = array.length-2; i >=0; i--) {
			if(maxFromRight < array[i]) {
				maxFromRight = array[i];
				System.out.print(maxFromRight + " ");
			}
		}
	}

	/**
	 * time taken is O(n*n)
	 * @param array
	 */
	private static void simplestApproach(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int j;
			for(j = i+1; j < array.length; j++) {
				if(array[i] <= array[j]) {
					break;
				}
			}
			if(j == array.length) {
				System.out.print(array[i] + " ");
			}
		}
	}

}
