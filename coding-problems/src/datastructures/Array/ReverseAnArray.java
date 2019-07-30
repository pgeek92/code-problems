package datastructures.Array;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 4, 2, 5, 0};
		
		int[] reversedArray = simplestApproach(array);
		printArrayElements(reversedArray);
		
		System.out.println();
		
		efficientApproach(array);
		printArrayElements(array);
	}

	/**
	 * This method is not taking any extra space
	 * @param array
	 */
	private static void efficientApproach(int[] array) {
		int forwardPtr = 0;
		int backwardPtr = array.length-1;
		
		while(forwardPtr < backwardPtr) {
			swap(array, forwardPtr, backwardPtr);
			forwardPtr++;
			backwardPtr--;
		}
	}

	/**
	 * Utility method to print the array elements
	 * @param array
	 */
	private static void printArrayElements(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	/**
	 * Utility method to swap the array elements
	 * @param array
	 * @param forwardPtr
	 * @param backwardPtr
	 */
	public static void swap(int[] array, int forwardPtr, int backwardPtr) {
		int temp = array[forwardPtr];
		array[forwardPtr] = array[backwardPtr];
		array[backwardPtr] = temp;
	}

	/**
	 * Taken auxiliary space of O(n)
	 * @param array
	 */
	private static int[] simplestApproach(int[] array) {
		int[] reversedArray = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			reversedArray[i] = array[array.length-i-1];
		}
		return reversedArray;
	}

}
