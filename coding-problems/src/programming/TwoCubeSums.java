/**
 * Create a function
 * 
 * boolean hasTwoCubeSums(int n)
 * which checks if a given number n can be written as the sum of two cubes in two different ways: n = a³+b³ = c³+d³. All the numbers a, b, c and d should be different and greater than 0.
 * 
 * E.g. 1729 = 9³+10³ = 1³+12³.
 * 
 * hasTwoCubeSums(1729); // true
 * hasTwoCubeSums(42);   // false
 * 
 */

package programming;

public class TwoCubeSums {

	public static void main(String[] args) {
		System.out.println(hasTwoCubeSums(1729));
	}

	public static boolean hasTwoCubeSums(int n) {
		int counter = 0;
		for (int i = 1; i <= Math.floor(Math.cbrt(n)); i++) {
			for (int j = i + 1; j <= Math.floor(Math.cbrt(n)); j++) {
				if (Math.pow(i, 3) + Math.pow(j, 3) == n)
					counter++;
			}
		}
		if (counter == 2)
			return true;
		return false;
	}
}
