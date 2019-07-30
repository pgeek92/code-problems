/**
 * https://www.youtube.com/watch?v=utE_1ppU5DY
 */
package algorithms;

public class JugglingAlgorithm {

	public static void main(String[] args) {
		int[] array = new int[] {5, 8, 10, 12, 15, 11};
		// rotate an array by 2 counter clockwise (anticlockwise)
		int rotateAnArrayBy = 2;
		
		rotateByJuggling(array, array.length, rotateAnArrayBy);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
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

}
