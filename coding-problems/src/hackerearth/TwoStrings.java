/**
 * Given two strings of equal length, you have to tell whether they both strings are identical.
 * 
 * Two strings S1 and S2 are said to be identical, if any of the permutation of string S1 is equal to the string S2. See Sample explanation for more details.
 * 
 * Input :
 * 
 * First line, contains an intger 'T' denoting no. of test cases.
 * Each test consists of a single line, containing two space separated strings S1 and S2 of equal length.
 * Output:
 * 
 * For each test case, if any of the permutation of string S1 is equal to the string S2 print YES else print NO.
 * Constraints:
 * 
 * 1<= T <=100
 * 1<= |S1| = |S2| <= 10^5
 * String is made up of lower case letters only.
 * Note : Use Hashing Concept Only . Try to do it in O(string length) .
 * 
 * SAMPLE INPUT 
 * 3
 * sumit mitsu
 * ambuj jumba
 * abhi hibb
 * 
 * SAMPLE OUTPUT 
 * YES
 * YES
 * NO
 * 
 * Explanation
 * For first test case,
 * 
 * mitsu can be rearranged to form sumit .
 * 
 * For second test case,
 * 
 * jumba can be rearranged to form ambuj .
 * 
 * For third test case,
 * 
 * hibb can not be arranged to form abhi.
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
public class TwoStrings {
public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] arrayOfS1S2 = br.readLine().split(" ");
            char[] S1 = arrayOfS1S2[0].toCharArray();
            char[] S2 = arrayOfS1S2[1].toCharArray();
            Arrays.sort(S1);
			Arrays.sort(S2);
			if(Arrays.equals(S1, S2)){
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
        }
    }
}
