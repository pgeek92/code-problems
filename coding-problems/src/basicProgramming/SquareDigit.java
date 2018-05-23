/**
 * you are asked to square every digit of a number.
 * 
 * For example, if we run 9119 through the function, 811181 will come out, 
 * because 92 is 81 and 12 is 1.
 * 
 * Note: The function accepts an integer and returns an integer
 * 
 */

package basicProgramming;

public class SquareDigit {

	public static void main(String[] args) {
		System.out.println(squareDigits(34));
	}

	public static int squareDigits(int n) {
		int remainder = 0;
		String s = "";
		while (n != 0) {
			remainder = n % 10;
			n /= 10;
			s = remainder * remainder + s;
		}
		return Integer.valueOf(s);
	}
}
