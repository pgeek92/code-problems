/**
 * Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764. 
 * The sum of the squared divisors is 2500 which is 50 * 50, a square!
 * 
 * Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square. 
 * 42 is such a number.
 * 
 * The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements, 
 * first the number whose squared divisors is a square and then the sum of the squared divisors.
 * 
 * #Examples:
 * 
 * list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
 * list_squared(42, 250) --> [[42, 2500], [246, 84100]]
 * The form of the examples may change according to the language, see Example Tests: for more details.
 * 
 */

package programming;

public class SumSquaredDivisors {
	public static String listSquared(long m, long n) {
		long sum = 0;
		String str = new String("[");
		for (long i = m; i <= n; i++) {
			sum = 0;
			for (long j = 2; j <= i; j++) {
				if (i % j == 0) {
					sum += j * j;
				}
			}
			if (Math.sqrt(sum + 1) % 1 == 0 && sum > 0) {
				sum = sum + 1;
				str += ("[" + i + ", " + sum + "], ");
			} else if (i == 1) {
				str += ("[" + i + ", " + 1 + "], ");
			}
		}
		if (str.length() > 1) {
			str = str.substring(0, str.length() - 2) + "]";
		} else {
			str += "]";
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(listSquared(1, 250));
	}
}
