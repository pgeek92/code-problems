/**
 * Soumika has a string S and its starting index is 1. The string S consists of characters from . 
 * As she is very intelligent, she wants to test his brother Vinay Tendulkar. 
 * She asked her brother Vinay Tendulkar to count the number of even numbered characters 
 * ( i.e  ) for every index i . For an index i, the result should be calculated from i to the 
 * end of the string. As Vinay doesn't know about programming, he wants you to help him find 
 * the solution.
 * 
 * Input:
 * First line contains a string S.
 * 
 * Output:
 * Print |S| space-separated integers,the result of every index.
 * 
 * Constraints:
 * 1 ≤ |S| ≤ 4
 * 
 * SAMPLE INPUT 
 * 574674546476
 * 
 * SAMPLE OUTPUT 
 * 7 7 7 6 5 5 4 4 3 2 1 1
 * Explanation
 * Given string S is .
 * for index 1
 * Number of even numbers from 5 to end of the string is 7 so the result of index 1 is 7.
 * for index 2
 * Number of even numbers from 7 to end of the string is 7 so the result of index 2 is 7.
 * for index 3
 * Number of even numbers from 4 to end of the string is 7 so the result of index 3 is 7.
 * for index 3
 * Number of even numbers from 6 to end of the string is 6 so the result of index 4 is 6.....
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded if any testcase passes.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, 
 * Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, 
 * Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, 
 * Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 */

package challenges.thoughtWorks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntelligentGirl {
public static void main(String args[] ) throws Exception {
        
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberString = br.readLine();
        int lenStr = numberString.length();
        int[] outArr = new int[lenStr+1];
        for(int i = lenStr - 1, j = lenStr; i >= 0 && j > 0; i--, j--){
            if(numberString.charAt(i) % 2 == 0){
                outArr[i] = outArr[j] + 1;
            }else{
                outArr[i] = outArr[j];
            }
        }
        for(int i = 0; i < lenStr; i++){
            System.out.print(outArr[i] + " ");
        }
    }
}
