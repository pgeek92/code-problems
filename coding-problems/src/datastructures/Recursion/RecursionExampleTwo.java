package datastructures.Recursion;

public class RecursionExampleTwo {

	public static void main(String[] args) {
		int[] arr = {5,2,6,1,3};
		System.out.println(sum(arr.length-1, arr));

	}
	
	public static int sum(int n, int[] arr) {
		if(n == 0) {
			return arr[0];
		}
		return arr[n] + sum(n-1, arr);
	}

}
