package datastructures.Array;

public class CheckSum {

	public static void main(String[] args) {
		int n = 9;
		int[] arr = new int[] {2, 4, 5, 7, 8};
		if(arr.length > 0) {
			int[] result = findSum(arr, n);
			
			if((result[0] + result[1]) != n) {
				System.out.println("Not Found");
			} else {
				System.out.println("Number 1 : " + result[0]);
				System.out.println("Number 2 : " + result[1]);
				System.out.println("Sum : " + (n));
			}
		} else {
			System.out.println("Input Array is Empty !");
		}
		
	}
	
	/**
	 * Time Complexity : O(n*n)
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int[] findSum(int[] arr, int n) {
		int[] result = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == n) {
					result[0] = arr[i];
					result[1] = arr[j];
					return result;
				}
			}
		}
		return arr;
	}
}
