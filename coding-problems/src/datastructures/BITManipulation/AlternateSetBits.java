package datastructures.BITManipulation;

public class AlternateSetBits {

	public static void main(String[] args) {
		System.out.println(bitsAreInAltOrder(5));

	}
	
	public static boolean bitsAreInAltOrder(int n) {
		int num = n ^ (n >> 1);
		if(((num + 1) & num) == 0) {
			return true;
		}
		return false;
	}
}
