/**
 * Bugs
 * 
 * You are developer at XYZ company. You like to call the bugs in your code as enemies. 
 * You maintain an array A of the list of enemies in decreasing order of their difficulty i.e., 
 * the most difficult bug will be the first element of the array. Initally, there is no bugs in the code. 
 * You are given N tasks. Each task contains one of the following two types of operations:
 * 
 * 1. 1 P: Add a bug with difficulty P into the array A.
 * 
 * 2. 2: Sort the array in decreasing order and print the difficulty of (n / 3)th bug in the sorted array, where n is the size of the array A. If the number of bugs is less than 3, print Not enough enemies.
 * 
 *  
 * 
 * Input Format
 * 
 * First line contains an integer N, denoting the number of tasks.
 * 
 * The next N lines contain one of the two types of operations mentioned above.
 * 
 *  
 * 
 * Output Format
 * 
 * For every operation of type 2, print the difficulty of (n / 3)th bug in the sorted array, where n is the size of the array A. If the number of bugs is less than 3, print Not enough enemies.
 * 
 *  
 * 
 * Constraints:
 * 1 <= N <= 5*10^5
 * 1 <= P <= 10^9 
 * 
 * 
 * Sample Input
 * 10
 * 1 1
 * 1 7
 * 2
 * 1 9
 * 1 21
 * 1 8
 * 1 5
 * 2
 * 1 9
 * 2
 * 
 * Sample Output
 * Not enough enemies
 * 9
 * 9
 * 
 * Explanation
 * Task 1: Add 1 to the array. Current array is [1].
 * 
 * Task 2: Add 7 to the array. Current array is [7,1].
 * 
 * Task 3: Array size is less than 3. Output is "Not enough enemies".
 * 
 * Task 4: Add 9 to the array. Current array is [9,7,1].
 * 
 * Task 5: Add 21 to the array. Current array is [21,9,7,1].
 * 
 * Task 6: Add 8 to the array. Current array is [21,9,8,7,1].
 * 
 * Task 7: Add 5 to the array. Current array is [21,9,8,7,5,1].
 * 
 * Task 8: Array size is 6. n/3 is equal to 2. Number at rank 2 in array is 9. Output is 9.
 * 
 * Task 9: Add 9 to the array. Current array is [21,9,9,8,7,5,1].
 * 
 * Task 10: Array size is 7. n/3 is equal to 2. Number at rank 2 in array is 9. Output is 9.
 * 
 * Note: Your code should be able to convert the sample input into the sample output. However, 
 * this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 * 
 * Time Limit: 2.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), 
 * JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, 
 * Octave, Pascal, Perl, PHP, Python, Python 3, Racket, Ruby, Rust, Scala, Swift, Visual Basic
 * 
 */

package company.trustingSocial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Bugs {
	public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            if(Integer.parseInt(input[0]) == 1){
                arrayList.add(Integer.parseInt(input[1]));
            }
            if(Integer.parseInt(input[0]) == 2){
                Collections.sort(arrayList, Collections.reverseOrder());
                if(arrayList.size() < 3){
                    System.out.println("Not enough enemies");
                }else{
                    System.out.println(arrayList.get((arrayList.size()/3)-1));
                }
            }
        }
    }
}
