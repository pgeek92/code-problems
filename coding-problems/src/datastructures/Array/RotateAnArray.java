package datastructures.Array;

public class RotateAnArray {

	public static void main(String[] args) {
		int[] array = new int[] {5, 8, 10, 12, 15, 11};
		// rotate an array by 2 counter clockwise (anticlockwise)
		int rotateAnArrayBy = 2;
		
		// use either of the approach below at once
		simplestApproach(array, rotateAnArrayBy);
		printArrayElements(array);
		System.out.println();
		
		rotate(array, rotateAnArrayBy);
		printArrayElements(array);
		System.out.println();
		
		//Reversal Algorithm
		leftRotate(array, array.length, rotateAnArrayBy);
		printArrayElements(array);
		System.out.println();
		
		//Juggling Algorithm
		rotateByJuggling(array, array.length, rotateAnArrayBy);
		printArrayElements(array);
	}
	
	/**
	 * JUGGLING ALGORITHM
	 * 
	 * this algorithm taking O(n) time and O(1) space
	 * @param array
	 * @param arrayLength
	 * @param rotateAnArrayBy
	 */
	public static void rotateByJuggling(int[] array, int arrayLength, int rotateAnArrayBy) {
		int ptr = -1, temp;
		for(int i = 0; i < gcd(arrayLength, rotateAnArrayBy); i++) {
			int j = i;
			temp = array[i];
			
			while(true) {
				ptr = (j + rotateAnArrayBy) % arrayLength;
				
				if(ptr == i) {
					break;
				}
				
				array[j] = array[ptr];
				j = ptr;
			}
			array[j] = temp;
		}
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
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
	
	/**
	 * this method will take O(n*d) time
	 * 
	 * @param array
	 * @param rotateAnArrayBy
	 */
	public static void rotate(int[] array, int rotateAnArrayBy) {
		for(int i = 0; i < rotateAnArrayBy; i++) {
			rotateByOne(array, array.length);
		}
	}
	
	public static void rotateByOne(int[] array, int arrayLength) {
		int i, temp;
		temp = array[0];
		for(i = 0; i < array.length - 1; i++) {
			array[i] = array[i+1];
		}
		array[i] = temp;
	}

	/**
	 * This method will take an extra auxiliary space of O(d)
	 * @param array
	 * @param rotateAnArrayBy
	 */
	private static void simplestApproach(int[] array, int rotateAnArrayBy) {
		int[] tempArray = new int[rotateAnArrayBy];
		for(int i = 0; i < rotateAnArrayBy; i++) {
			tempArray[i] = array[i];
		}
		
		for(int i = 0; i < array.length; i++) {
			if(rotateAnArrayBy+i <= array.length-1) {
				array[i] = array[rotateAnArrayBy+i];
			}
			else {
				break;
			}
		}
		
		for(int i = array.length-rotateAnArrayBy; i < array.length; i++) {
			array[i] = tempArray[i-array.length+rotateAnArrayBy];
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

}
