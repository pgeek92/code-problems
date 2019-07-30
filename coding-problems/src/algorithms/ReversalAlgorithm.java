/**
 * https://www.youtube.com/watch?v=QOpU9-l5T7Y
 */
package algorithms;

public class ReversalAlgorithm {

	public static void main(String[] args) {
		int[] array = new int[] {5, 8, 10, 12, 15, 11};
		// rotate an array by 2 counter clockwise (anticlockwise)
		int rotateAnArrayBy = 2;
		
		leftRotate(array, array.length, rotateAnArrayBy);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void leftRotate(int[] array, int arrayLength, int rotateAnArrayBy) {
		reverseAnArray(array, 0, rotateAnArrayBy-1);
		reverseAnArray(array, rotateAnArrayBy, arrayLength-1);
		reverseAnArray(array, 0, arrayLength-1);
	}
	
	public static void reverseAnArray(int[] array, int forwardPtr, int backwardPtr) {
		while(forwardPtr < backwardPtr) {
			swap(array, forwardPtr, backwardPtr);
			forwardPtr++;
			backwardPtr--;
		}
	}
	
	public static void swap(int[] array, int forwardPtr, int backwardPtr) {
		int temp = array[forwardPtr];
		array[forwardPtr] = array[backwardPtr];
		array[backwardPtr] = temp;
	}

}
