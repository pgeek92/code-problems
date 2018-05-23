/**
 * We need a function prime_bef_aft() that gives the largest prime below a certain given value n,
 * 
 * befPrime or bef_prime (depending on the language),
 * 
 * and the smallest prime larger than this value,
 * 
 * aftPrime/aft_prime (depending on the language).
 * 
 * The result should be output in a list like the following:
 * 
 * primeBefAft == {befPrime, aftPrime}
 * If n is a prime number it will give two primes, n will not be included in the result.
 * 
 * Let's see some cases:
 * 
 * primeBefAft(100) --> {97, 101}
 * 
 * primeBefAft(97) --> {89, 101}
 * 
 * primeBefAft(101) --> {97, 103}
 * 
 */


package basicProgramming;

public class BeforeAfterPrimes {

	public static long[] primeBefAft(long num) {
		long[] outputArray = new long[2];

		for (long i = num - 1; i > 1; i--) {
			if (isPrime(i)) {
				outputArray[0] = i;
				break;
			}
		}
		for (long i = num + 1;; i++) {
			if (isPrime(i)) {
				outputArray[1] = i;
				break;
			}
		}

		return outputArray;
	}

	public static boolean isPrime(long num) {
		for (long i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return num != 1;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < primeBefAft(100).length; i++) {
			System.out.println(primeBefAft(100)[i]);
		}
	}
}
