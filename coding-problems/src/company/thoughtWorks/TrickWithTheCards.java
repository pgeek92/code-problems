/**
 * Mr. X is performing a trick with the cards. He has N cards, lets name them 1.....N, on a round table. 
 * So card 1 is in between 2nd card and Nth card. Initially all cards are upside down. 
 * His trick involves making all cards face up.
 * 
 * His trick is whenever he taps on a card, it flips (if card was originally upside down, after 
 * flipping its faces up, and vice-versa), but he is no ordinary magician, he makes the two 
 * adjacent cards (if any) also to flip with the single tap. Formally, if he taps ith card, 
 * then i-1, i, i+1 cards are flipped. (Note that if he taps Nth card, then he flips (N-1)th, 
 * Nth and 1st card.)
 * 
 * Our magician needs a helper, to assist him in his magic tricks. He is looking for 
 * someone who can predict minimum number of taps needed to turn all the cards facing up.
 * 
 * Input : 
 * First line of input contains T, the number of test cases. Then T lines follows, 
 * each line contains N, the number of cards for that particular case.
 * 
 * Output : 
 * Print the output for each case in a single line.
 * 
 * Constraints : 
 * 1 <= T <= 10^5 
 * 0 <= N <= 10^15
 * 
 * SAMPLE INPUT 
 * 2
 * 2
 * 3
 * 
 * SAMPLE OUTPUT 
 * 1
 * 1
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

package company.thoughtWorks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrickWithTheCards {
	public static void main(String args[]) throws Exception {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			long N = Long.parseLong(br.readLine());
			if (N <= 0L) {
				System.out.println(0);
			} else if (N <= 2L) {
				System.out.println(1);
			} else if (N % 3L == 0) {
				System.out.println(N / 3L);
			} else {
				System.out.println(N);
			}
		}
	}
}
