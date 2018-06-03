/**
 * One Swap to Palindrome
 * You are given T tasks to perform. In each task, you are given a string S of length N. 
 * You are allowed to select any two indices i and j (i!=j) of the given string and 
 * perform exactly one swap between the characters at these indices.
 * 
 * If it is possible to make the new string a palindrome then print "Yes", else print "No".
 * 
 * Note:
 * 
 * A string is said to be palindrome if it reads same as its reverse form. For example: "madam" , "dad" etc.
 * 
 * INPUT
 * 
 * First line contain an integer T denoting total number of tasks to perform.
 * 
 * Each of the following T lines contains a string S.
 * 
 * OUTPUT
 * 
 * For each task, print a single line with "Yes" if it is possible to make palindrome otherwise print "No" without any quotes.
 * 
 * Constraints:
 * 1<= T<= 5
 * 2 <= N <= 100000
 * 
 * String contains only lowercase English alphabets.
 * 
 * Sample Input
 * 1
 * bbg
 * 
 * Sample Output
 * Yes
 * 
 * Explanation
 * We can swap indices pair (1,2) [ 0-based ] , so that final string will be "bgb" which is a palindrome.
 * 
 * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: C++, C++14, Clojure, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift
 *  
 */

package codewars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class OneSwapToPalindrome {
	public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         */
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());                // Reading input from STDIN
        for(int itr = 0; itr < T; itr++){
            String input = br.readLine();
            int lengthOfString = input.length();
            int n = (lengthOfString*(lengthOfString - 1))/2;
            possibleString(input, n, lengthOfString);
        }    
    }
    
    public static void possibleString(String input, int n, int lengthOfString){
        String strOp = null;
        String reverse = new StringBuffer(input).reverse().toString();
        if(input.equals(reverse)){
            strOp = "Yes";    // Writing output to STDOUT
        }
            
        OUTER: for(int i = 0; i < n; i++){
            INNER: for(int j = i+1; j < lengthOfString; j++){
                String methodOutput = swap(input, i, j);
                reverse = new StringBuffer(methodOutput).reverse().toString();
                if(methodOutput.equals(reverse)){
                    strOp = "Yes";    // Writing output to STDOUT
                    break OUTER;
                }else{
                    strOp = "No";
                    continue INNER;
                }
            }
        }
        System.out.println(strOp);        
    }
    
    public static String swap(String str, int i, int j){
        StringBuffer sb = new StringBuffer(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
