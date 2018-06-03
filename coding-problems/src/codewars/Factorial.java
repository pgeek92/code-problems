/**
 * You have been given a positive integer N. You need to find and print the Factorial of this number. 
 * The Factorial of a positive integer N refers to the product of all number in the range from 1 to N. 
 * You can read more about the factorial of a number here.
 * 
 * Input Format:
 * The first and only line of the input contains a single integer N denoting the number whose factorial you need to find.
 * 
 * Output Format
 * Output a single line denoting the factorial of the number N.
 * 
 * Constraints
 * 1 <= N <= 10
 * 
 * SAMPLE INPUT 
 * 2
 * 
 * SAMPLE OUTPUT 
 * 2
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */

package codewars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Factorial {

	public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(factorial(N));
    }
    
    public static int factorial(int N){
        if(N == 0 || N == 1){
            return 1;
        }else{
            return N * factorial(N-1);
        }
    }
}
