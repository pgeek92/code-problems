package datastructures.Recursion;

public class FibnonacciNumber {

	public static void main(String[] args) {
		System.out.println(fib(100));

	}
	
	/**
	 * Time Complexity : O(2^N)
	 * Space Complexity : O(N)
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		if(n <= 1) return n;
		return fib(n-1) + fib(n-2);
	}
}
