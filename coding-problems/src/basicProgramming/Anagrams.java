/**
 * Given two strings, a and b , that may or may not be of the same length, determine the minimum number of character deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
 * 
 * Input :
 * 
 * test cases,t
 * two strings a and b, for each test case
 * Output:
 * 
 * Desired O/p
 * 
 * Constraints :
 * 
 * string lengths<=10000
 * 
 * Note :
 * 
 * Anagram of a word is formed by rearranging the letters of the word.
 * 
 * For e.g. -> For the word RAM - MAR,ARM,AMR,RMA etc. are few anagrams.
 * 
 * SAMPLE INPUT 
 * 1
 * cde
 * abc
 * SAMPLE OUTPUT 
 * 4
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, 
 * Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, 
 * Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, 
 * Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 * 
 * Solution : 
 * The idea is to make character count arrays for both the strings and store frequency of each 
 * character. Now iterate the count arrays of both strings and difference in frequency of any 
 * character abs(count1[str1[i]-‘a’] – count2[str2[i]-‘a’]) in both the strings is the number of 
 * character to be removed in either string.
 * 
 * Time Complexity : O(N)
 * Spae Complexity : O(Alphabet_Size -> 26)
 * 
 */

package basicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Anagrams {
public static void main(String args[] ) throws Exception {
        
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String A = br.readLine();
            String B = br.readLine();
            System.out.println(deleteChars(A, B));
        }
    }
    
    public static int deleteChars(String A, String B){
        final int CHAR_SIZE = 26;
        int[] countA = new int[CHAR_SIZE];
        
        for(int i = 0; i < A.length(); i++){
            countA[A.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < B.length(); i++){
            countA[B.charAt(i) - 'a']--;
        }
        
        int delChars = 0;
        for(int i = 0; i < CHAR_SIZE; i++){
            delChars += Math.abs(countA[i]);
        }
        
        return delChars;
    }
}
