package datastructures.BITManipulation;

public class NumberIsPowerOf2 {

	public static void main(String[] args) {
		System.out.println(isNumPowerOfTwo(64));
	}
	
	public static boolean isNumPowerOfTwo(int num) {
		return num != 0 && ((num & (num - 1)) == 0);
	}

}
