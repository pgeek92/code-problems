package datastructures.BITManipulation;

public class SwapANumber {

	public static void main(String[] args) {
		int a = 10, b = 5;
		System.out.println("a = " + a + ", b = " + b);
		swapANumberOne(a, b);
		swapANumberTwo(a, b);
		swapANumberThree(a, b);
	}
	
	public static void swapANumberOne(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a = " + a + ", b = " + b);
	}
	
	public static void swapANumberTwo(int a, int b) {
		a = a * b;
		b = a / b;
		a = a / b;
		
		System.out.println("a = " + a + ", b = " + b);
	}
	
	public static void swapANumberThree(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println("a = " + a + ", b = " + b);
	}

}
