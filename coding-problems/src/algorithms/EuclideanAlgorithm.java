/**
 * https://www.geeksforgeeks.org/java-program-for-basic-and-extended-euclidean-algorithms/
 */
package algorithms;

public class EuclideanAlgorithm {
	public static void main(String[] args) {
		System.out.println(gcd(60, 36));
	}

	/**
	 * This method will take O(log(min (a, b))) time
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
