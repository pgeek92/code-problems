package namasteDSA;

public class LargestNumber {

	public static void main(String[] args) {
		System.out.println(findLargest(new int[] {2, -6, 4, 8, 1, -9}));
	}
	
	public static int findLargest(int[] arr) {
		int largest = Integer.MIN_VALUE;
		for(int number : arr) {
			if(number > largest) {
				largest = number;
			}
		}
		
		return largest;
	}

}
