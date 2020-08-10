/**
 * In this problem, you have to implement the int [] removeEven(int[] arr) 
 * method, which removes all the even elements from the array and 
 * returns back updated array.
 * 
 */
package datastructures.Array;

public class CheckRemoveEven {

	public static void main(String[] args) {
		int[] arr = removeEven(new int[] {1, 2, 4, 5, 10, 6, 3});
		for(Integer i : arr) {
			System.out.println(i);
		}
	}
	
	public static int[] removeEven(int[] arr) {
		int oddElements = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				oddElements++;
			}
		}
		
		int[] result = new int[oddElements];
		int result_index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				result[result_index++] = arr[i];
			}
		}
		return result; // change this and return the correct result array
	}

}
