/**
 * Digits in a Number
 * 
 * Let's say 1, 2, 3 are the only digits which exists in a unique number system, so the numbers
 * will be 1, 2, 3, 11, 12, 13, 21, ........in ascending order.
 * 
 * 1st number is 1 and number of digits is 1
 * 4th will be 11 and number of digits is 2
 * 14th will be 112 and number of digits will be 3
 * 40th will be 1111 and number of digits will be 4
 * 
 * You have to find number of digits of Nth term in unique number system.
 * 
 * Input format 
 * 
 * 1. First line T contains number of testcases.
 * 2. Next T lines contains N.
 * 
 * Output format
 * 
 * Number of digits in Nth number.
 * 
 * input constraints
 * 1 <= T <=10^5
 * 1 <= N <=10^18
 * 
 * Sample Input										Sample Output
 * 4												1
 * 1												2
 * 4												3
 * 14 												4
 * 40												
 * 
 * Explanation
 * 
 * 1st number is 1 and number of digits is 1
 * 4th will be 11 and number of digits is 2
 * 14th will be 112 and number of digits will be 3
 * 40th will be 1111 and number of digits will be 4
 * 
 * <b>Note</b> : Your code should be able to convert the sample input into the sample output.
 * However, this is not enough to pass the challenge, because the code will run on multiple test cases. 
 * Therefore, your code must solve this problem statements.
 * 
 * Time Limit : 1.0 sec(s) for each input file
 * Memory Limit : 256 MB
 * Source Limit : 1024 KB
 * Marking Scheme : Marks are awarded if any testcases passes.
 * Allowed Languages : C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, 
 * JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp(SBCL), Lua, Objective-C, OCaml,
 * Octave, Pascal, Perl, PHP, Python, Python 3 R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic  
 *   
 */

package ThoughtworksAppDevHiringChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitsInInteger {
	public static void main(String args[] ) throws Exception {
	    
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            long N = Long.valueOf(br.readLine());
            long sum = numberAtNthTerm(N);
            System.out.println(countNoOfDigits(sum));
        }
    }
    
    static double logOfBase(long base, long num){
        return Math.log(num) / Math.log(base);
    }
        
    private static int mfunc(long n) {
        return (int) Math.floor(logOfBase(3, 2 * n + 1));
    }

    private static int b(int j, double m, long n) {
        return (int) Math.floor((2 * n + 1 - Math.pow(3, m)) / (2 * Math.pow(3, j)));
    }

    static long numberAtNthTerm(long N){
        long n = 1;
        long sum = 0;
        for (long i = 1; i <= N; i++) {
            int m = mfunc(n);
            for (int j = 0; j < m ; j++) {
                sum += ((1 + b(j, m, n) % 3) * Math.pow(10, j));
            }
            n++;
        } 
        return sum;
    }
        
    static int countNoOfDigits(long sum){
        int count = 0;
        while(sum > 0) {
    		sum = sum / 10;
		    count = count + 1; 
	    }
	    return count;
    }
}
