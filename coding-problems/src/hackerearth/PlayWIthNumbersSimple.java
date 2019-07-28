/**
 * Using Simple Approach
 * 
 * You are given an array of n numbers and q queries. For each query you have to print the floor of the expected value(mean) of the subarray from L to R.
 * 
 * 
 * First line contains two integers N and Q denoting number of array elements and number of queries.
 * 
 * Next line contains N space seperated integers denoting array elements.
 * 
 * Next Q lines contain two integers L and R(indices of the array).
 * 
 * 
 * print a single integer denoting the answer.
 * 
 * :
 * 
 * 1<= N ,Q,L,R <= 10^6
 * 
 * 1<= Array elements <= 10^9
 * 
 * NOTE
 * 
 * Use Fast I/O
 * 
 * Problem setter : Sheldon Tauro
 * 
 * SAMPLE INPUT 
 * 5 3
 * 1 2 3 4 5
 * 1 3
 * 2 4
 * 2 5
 * 
 * SAMPLE OUTPUT 
 * 2 
 * 3
 * 3
 * Time Limit:	1.5 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, 
 * Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, 
 * Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, 
 * Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayWIthNumbersSimple {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String[] NQ = br.readLine().split(" ");
		final int[] A = new int[Integer.parseInt(NQ[0])];
		String[] arrayInput = br.readLine().split(" ");
		long sum[] = new long[Integer.parseInt(NQ[0])];
		long sums = 0;
		for (int i = 0; i < Integer.parseInt(NQ[0]); i++) {
			A[i] = Integer.parseInt(arrayInput[i]);
			sums = sums + A[i];
			sum[i] = sums;
		}
		
		StringBuilder op = new StringBuilder();

		for (int i = 0; i < Integer.parseInt(NQ[1]); i++) {
			final String[] query = br.readLine().split(" ");
			int start = Integer.parseInt(query[0]) - 1;
			int end = Integer.parseInt(query[1]) - 1;

			long sum0 = sum[end] - sum[start] + A[start];

			long mean = sum0 / (end - start + 1);
			op.append(mean).append("\n");
		}
		System.out.println(op.toString());
	}
}
