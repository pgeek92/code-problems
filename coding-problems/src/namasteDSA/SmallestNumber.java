package namasteDSA;

public class SmallestNumber {

	public static void main(String[] args) {
		System.out.println(smallestNumber(new int[] {-1, -2, -3, 5, 6, 9, 0}));

	}

	public static int smallestNumber(int[] arr) {
		int smallest = Integer.MAX_VALUE;
		for(int number : arr) {
			if(number < smallest) {
				smallest = number;
			}
		}
		return smallest;
	}
}
