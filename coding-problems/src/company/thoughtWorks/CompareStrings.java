/**
 * Compare Strings
 * 
 * You have been given two strings, A and B (of length N each) and Q queries.
 * The strings contain only 0s and/or 1s.
 * 
 * For every query, you are given an index i. You have to update the value at index i to 1 in string B
 * and check if B is lexicographically equal to or larger than A or not.
 * 
 * if Yes, then print "YES" and if not, print "NO" (without quotes).
 * 
 * Input format 
 * 
 * 1. First line contains two space-separated integers N and Q.
 * 2. Next line contains the string A.
 * 3. Next line contains the string B.
 * 4. Next Q lines contains an integer i (1 - based indexing)
 * 
 * Output format
 * 
 * for each query, print the desired output in a new line.
 * 
 * input constraints
 * 1 <= N,Q <=10^6
 * 1 <= i <= N
 * 
 * Sample Input										Sample Output
 * 5 5												NO
 * 11111											NO
 * 00010											NO
 * 1 												NO
 * 2												YES
 * 3
 * 4
 * 5
 * 
 * Explanation
 * 
 * After 1st query; B = 10010 < A. (NO)
 * After 2nd Query; B = 11010 < A. (NO)
 * After 3rd Query; B = 11110 < A. (NO)
 * After 4th Query; B = 11110 < A. (NO)
 * After 5th Query; B = 11111 = A. (YES)
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

package company.thoughtWorks;

import java.util.*;
public class CompareStrings {
	public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        String[] NQ = s.nextLine().split(" ");
        char[] A = s.nextLine().toCharArray();
        char[] B = s.nextLine().toCharArray();
        int AC = 0, BC = 0;
        int Q = Integer.parseInt(NQ[1]);
        
        for(int i = 0; i < A.length; i++) {
        	if(A[i] == '1') AC++;
        	if(B[i] == '1') BC++;
        }
        
        while(Q-->0) {// here Q --> 0 means Q>0 and Q-- in Java 8
        	int index = s.nextInt() - 1;
        	if(B[index] != '1') BC++;
        	if(BC < AC) {
        		System.out.println("NO");
        	}else {
        		System.out.println("YES");
        	}
        }
    }
}
