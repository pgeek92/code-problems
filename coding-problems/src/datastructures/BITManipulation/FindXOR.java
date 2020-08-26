package datastructures.BITManipulation;

public class FindXOR {

	public static void main(String[] args) {
		System.out.println(findXOR(new int[] {1, 2, 3, 4}));

	}
	
	public static int findXOR(int[] arr) {
		int arrL = arr.length;
		if(arrL == 1) {
			return arr[0];
		} else {
			return 0;
		}
	}

}
