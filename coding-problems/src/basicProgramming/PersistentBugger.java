/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.
 * 
 * For example:
 * 
 * persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
 *                       // and 4 has only one digit
 * 
 * persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
 *                        // 1*2*6 = 12, and finally 1*2 = 2
 * 
 * persistence(4) == 0 // because 4 is already a one-digit number
 * 
 */

package basicProgramming;

public class PersistentBugger {

	public static void main(String[] args) {
		System.out.println(persistence(1234));
	}

	public static int persistence(long n) {
		Long nextNumberToCheck = n;
		int counter = 0;

		while (nextNumberToCheck.toString().length() != 1) {
			nextNumberToCheck = multiplyDigitsFromLong(nextNumberToCheck);
			counter++;
		}

		return counter;
	}

	public static long multiplyDigitsFromLong(long number) {
		Long numberObject = number;
		long multiplication = 1;

		for (char characterDigit : numberObject.toString().toCharArray()) {
			multiplication *= Long.parseLong(String.valueOf(characterDigit));
		}

		return multiplication;
	}

}
