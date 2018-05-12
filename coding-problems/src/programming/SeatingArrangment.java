/**
 * Akash and Vishal are quite fond of travelling. They mostly travel by railways. They were travelling in a train one day and they got interested in the seating arrangement of their compartment. The compartment looked something like 
 * 
 * 
 * So they got interested to know the seat number facing them and the seat type facing them. The seats are denoted as follows : 
 * 
 * Window Seat : WS
 * Middle Seat : MS
 * Aisle Seat : AS
 * 
 * You will be given a seat number, find out the seat number facing you and the seat type, i.e. WS, MS or AS.
 * 
 * INPUT
 * First line of input will consist of a single integer T denoting number of test-cases. Each test-case consists of a single integer N denoting the seat-number.
 *  
 * OUTPUT
 * For each test case, print the facing seat-number and the seat-type, separated by a single space in a new line.
 * 
 * CONSTRAINTS
 * 1<=T<=105
 * 1<=N<=108
 * SAMPLE INPUT 
 * 2
 * 18
 * 40
 * 
 * SAMPLE OUTPUT 
 * 19 WS
 * 45 AS
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Visual Basic
 *  
 */

package programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SeatingArrangment {
	public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            seatingArrangement(Integer.parseInt(br.readLine()));
        }
    }
    
    public static void seatingArrangement(int N){
        int remainder = 0;
        remainder = N%12;
        switch(remainder){
            case 0:
			System.out.println(""+(N-11)+" WS");
			break;
			
			case 1:
			System.out.println(""+(N+11)+" WS");
			break;

			case 2:
			System.out.println(""+(N+9)+" MS");
			break;

			case 3:
			System.out.println(""+(N+7)+" AS");
			break;

			case 4:
			System.out.println(""+(N+5)+" AS");
			break;

			case 5:
			System.out.println(""+(N+3)+" MS");
			break;

			case 6:
			System.out.println(""+(N+1)+" WS");
			break;

			case 7:
			System.out.println(""+(N-1)+" WS");
			break;

			case 8:
			System.out.println(""+(N-3)+" MS");
			break;

			case 9:
			System.out.println(""+(N-5)+" AS");
			break;

			case 10:
			System.out.println(""+(N-7)+" AS");
			break;

			case 11:
			System.out.println(""+(N-9)+" MS");
			break;
        }
    }
}
