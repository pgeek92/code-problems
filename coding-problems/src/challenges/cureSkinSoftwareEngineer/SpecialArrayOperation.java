/**
 * You are given an array A of size N. You can perform an operation in which you will remove the largest and the smallest element from the array and add  their difference back into the array. So, the size of the array will decrease by 1 after each oepration. You are given Q tasks and in each task, you are given an integer K. For each task, you have to tell sum of all the elements in the array after K operations.
 * 
 * Input:
 * 
 * First line contains two space-separated integers N and Q, denoting the number of elements in array and number of queries respectively.
 * 
 * Next line contains N space-separated integers denoting elements of the array.
 * 
 * Next Q lines contain a single integer K.
 * 
 * Output:
 * 
 * For each task, print answer in a new line.
 * 
 * Constraints:
 * 
 * 2 <= N <= 105
 * 
 * 1 <= Q <= 105
 * 
 * 0 <= A[i] <= 109
 * 
 * 0 <= K < N
 * 
 * SAMPLE INPUT 
 * 5 2
 * 3 2 1 5 4
 * 1
 * 2
 * SAMPLE OUTPUT 
 * 13
 * 9
 * Explanation
 * After 1st operation, the array will become, A = [3,2,4,4]. So, sum of elements = 13.
 * 
 * After 2nd operation, the array will become, A = [3,2,4]. So, sum of elements = 9.
 * 
 * Time Limit:	1.0 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded if any testcase passes.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, 
 * Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, 
 * Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, 
 * Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 * 
 */

package challenges.cureSkinSoftwareEngineer;

import java.util.*;

public class SpecialArrayOperation {
	public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            int ele = in.nextInt();
            minPq.add(ele); //add() method Adds an element into priority queue
            maxPq.add(ele);
            totalSum += ele;
        }
        int[] arK = new int[q];
        int maxK = 0;
        for (int i = 0; i < q; i++) {
            arK[i] = in.nextInt();
            maxK = Math.max(maxK, arK[i]);
        }
        Map<Integer, Long> map = new HashMap<>();
        map.put(0,totalSum);
        for (int j = 0; j < maxK; j++) {
            int max = maxPq.poll(); //poll() method retrieves and remove head element from priority queue
            int min = minPq.poll();
            maxPq.add(max - min);
            minPq.add(max - min);
            totalSum -= (2* min);
            map.put(j + 1, totalSum);
        }
        for (int i = 0; i < q; i++){
            System.out.println(map.get(arK[i]));
        }
    }
}
