/**
 * You have been given a String S. You need to find and print whether this string is a palindrome or not. If yes, print "YES" (without quotes), else print "NO" (without quotes).
 * 
 * Input Format
 * The first and only line of input contains the String S. The String shall consist of lowercase English alphabets only.
 * 
 * Output Format
 * Print the required answer on a single line.
 * 
 * Constraints 
 * 1 <= |S| <= 100
 * 
 * Note
 * String S consists of lowercase English Alphabets only.
 * 
 * SAMPLE INPUT 
 * aba
 * 
 * SAMPLE OUTPUT 
 * YES
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
public class PalindromicString {
	public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        char[] nameToCharArray = name.toCharArray();
        char[] resultantArray = new char[name.length()];
        int j = 0;
        for(int i = nameToCharArray.length-1; i >= 0; i--){
            resultantArray[j] = nameToCharArray[i];
            j++;            
        }
        if(name.equals(new String(resultantArray))){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
