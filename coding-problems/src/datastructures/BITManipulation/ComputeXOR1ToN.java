package datastructures.BITManipulation;

public class ComputeXOR1ToN {

	public static void main(String[] args) {
		System.out.println(computeXORFrom1ToN(12));
	}
	
	public static int computeXORFrom1ToN(int num) {
		if(num % 4 == 0) {
			return num;
		}
		if(num % 4 == 1) {
			return 1;
		}
		if(num % 4 == 2) {
			return num + 1;
		} else {
			return 0;
		}
	}

}
