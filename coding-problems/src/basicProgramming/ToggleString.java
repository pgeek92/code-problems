/**
 * You have been given a String S consisting of uppercase and lowercase English alphabets. You need to change the case of each alphabet in this String. That is, all the uppercase letters should be converted to lowercase and all the lowercase letters should be converted to uppercase. You need to then print the resultant String to output.
 * 
 * Input Format
 * The first and only line of input contains the String S
 * 
 * Output Format
 * Print the resultant String on a single line.
 * 
 * Constraints
 * 1 <= |S| <= 100
 * 
 * where S denotes the length of string S.
 * 
 * SAMPLE INPUT 
 * abcdE
 * 
 * SAMPLE OUTPUT 
 * ABCDe
 * 
 * Time Limit:	5.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 *  
 */

package basicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ToggleString {
	public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuffer str = new StringBuffer(S);
        convertOpposite(str);
        System.out.println(str);
    }
    
    public static void convertOpposite(StringBuffer str){
        int strLength = str.length();
        for(int i = 0; i < strLength; i++){
            Character c = str.charAt(i);
            if(Character.isLowerCase(c)){
                str.replace(i, i+1, Character.toUpperCase(c)+"");
            }else{
                str.replace(i, i+1, Character.toLowerCase(c)+"");
            }
        }
    }
}
