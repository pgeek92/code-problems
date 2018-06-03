/**
 * A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only applicable to the natural numbers.
 * 
 * Here's how it works (Ruby example given):
 * 
 * digital_root(16)
 * => 1 + 6
 * => 7
 * 
 * digital_root(942)
 * => 9 + 4 + 2
 * => 15 ...
 * => 1 + 5
 * => 6
 * 
 * digital_root(132189)
 * => 1 + 3 + 2 + 1 + 8 + 9
 * => 24 ...
 * => 2 + 4
 * => 6
 * 
 * digital_root(493193)
 * => 4 + 9 + 3 + 1 + 9 + 3
 * => 29 ...
 * => 2 + 9
 * => 11 ...
 * => 1 + 1
 * => 2
 * 
 */

package codewars;

public class DigitalRoot {

	public static void main(String[] args) {
		System.out.println(digitalRoot(12));
	}

	public static int digitalRoot(int n) {
		int remainder = 0;
		int sum = 0;
		while (n > 0) {
			remainder = n % 10;
			n = n / 10;
			sum += remainder;
		}
		if (sum > 9)
			return digitalRoot(sum);
		else
			return sum;
	}
}
