package namasteDSA;

public class EvenOrOdd {

	public static void main(String[] args) {
		checkEvenOrOddA(12);
	}

	/** 
	 * Approach 1 : Using Modulo Operator
	 * 
	 **/
	public static void checkEvenOrOddA(int number) {
		if(number % 2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
	}
	
	
	/**
	 * Approach 2 : A number is even or odd can be determined by examining it's LSB (least significant bit)
	 * 
	 * Understanding the LSB: In binary representation, all even numbers have their LSB (the rightmost bit) as 0, 
	 * while all odd numbers have their LSB as 1.
	 * 
	 * Bitwise AND with 1: Perform a bitwise AND operation between the number and 1.
	 * If the number is even, its LSB is 0. Performing number & 1 will result in 0 & 1, which is 0.
	 * If the number is odd, its LSB is 1. Performing number & 1 will result in 1 & 1, which is 1.
	 * 
	 * Checking the result:
	 * If the result of number & 1 is 0, the number is even.
	 * If the result of number & 1 is 1, the number is odd.
	 * @param number
	 */
	public static void checkEvenOrOddB (int number) {
		if((number & 1) == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
	}
}
