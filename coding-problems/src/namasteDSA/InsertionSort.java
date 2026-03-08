package namasteDSA;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(insertionSort(new int[] {7, 4, 3, 5, 1, 2})));
	}
	
	public static int[] insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int currentElement = arr[i];
			int previousIndex = i-1;
			
			while(previousIndex >= 0 && arr[previousIndex] > currentElement) {
				arr[previousIndex + 1] = arr[previousIndex];
				previousIndex--;
			}
			
			arr[previousIndex + 1] = currentElement;
		}
		return arr;
	}
}
