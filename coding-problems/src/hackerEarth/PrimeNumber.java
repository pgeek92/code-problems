/**
 * You are given an integer N. You need to print the series of all prime numbers till N.
 * 
 * Input Format
 * 
 * The first and only line of the input contains a single integer N denoting the number till where you need to find the series of prime number.
 * 
 * Output Format
 * 
 * Print the desired output in single line separated by spaces.
 * 
 * Constraints
 * 
 * 1<=N<=1000
 * 
 * SAMPLE INPUT 
 * 9
 * SAMPLE OUTPUT 
 * 2 3 5 7
 * Time Limit:	5.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */

package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PrimeNumber {
	public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean prime[] = new boolean[N+1];
        for(int i=0;i<N;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=N; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*2; i <= N; i += p)
                    prime[i] = false;
            }
        }
         
        for(int i = 2; i <= N; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
