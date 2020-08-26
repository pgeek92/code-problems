package datastructures.BITManipulation;

public class XORSum {

	public static void main(String[] args) {
		System.out.println(xorSum(new int[] {1, 2, 3}));

	}
	
	public static int xorSum(int[] arr) {
		int arrL = arr.length;
		int num = 0;
		
		for(int i = 0; i < arrL; i++) {
			num |= arr[i];
		}
		
		return num * (int)Math.pow(2, arrL-1);
	}

}
