/**
 * Given a character C, print the ASCII value of that character.
 * 
 * Input:
 * First and only line in input contains a character C.
 * 
 * Output:
 * Print the ASCII value of the character C.
 * 
 * Constraints:
 * C belongs to ASCII Characters
 * 
 * ASCII characters
 * 
 * SAMPLE INPUT 
 * b
 * SAMPLE OUTPUT 
 * 98
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 *  * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */

package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ASCIIValue {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        char character = name.charAt(0); // This gives the character 'a'
        System.out.println((int) character);

	}

}
