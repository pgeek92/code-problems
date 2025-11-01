package namasteDSA;

public class SecondLargest {

	public static void main(String[] args) {
		int[] arr = {5, 6, 6};
	    System.out.println(secondLargest(arr));
	}
	
	public static String secondLargest(int[] arr) {
		if(arr.length < 2) {
			return "Array should have at least two numbers";
		}
		
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for(int number : arr) {
			if(number > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = number;
			} else if (number > secondLargest && number != firstLargest) {
				secondLargest = number;
			}
		}
		
		return (secondLargest == Integer.MIN_VALUE) ? "No second largest found" : String.valueOf(secondLargest);
	}

}
