package namasteDSA;

public class LinearSearch {

	public static void main(String[] args) {
		System.out.println(linearSearch(new int[] {1,2,3,0,9}, 5));
	}

	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int linearSearch(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) {
				return i;
			}
		}
		return -1;
	}
}
