/**
 * Using MOs ALgorithm
 * 
 * You are given an array of n numbers and q queries. For each query you have to print the floor of the expected value(mean) of the subarray from L to R.
 * 
 * 
 * First line contains two integers N and Q denoting number of array elements and number of queries.
 * 
 * Next line contains N space seperated integers denoting array elements.
 * 
 * Next Q lines contain two integers L and R(indices of the array).
 * 
 * 
 * print a single integer denoting the answer.
 * 
 * :
 * 
 * 1<= N ,Q,L,R <= 10^6
 * 
 * 1<= Array elements <= 10^9
 * 
 * NOTE
 * 
 * Use Fast I/O
 * 
 * Problem setter : Sheldon Tauro
 * 
 * SAMPLE INPUT 
 * 5 3
 * 1 2 3 4 5
 * 1 3
 * 2 4
 * 2 5
 * 
 * SAMPLE OUTPUT 
 * 2 
 * 3
 * 3
 * Time Limit:	1.5 sec(s) for each input file.
 * Memory Limit:	256 MB
 * Source Limit:	1024 KB
 * Marking Scheme:	Marks are awarded when all the testcases pass.
 * Allowed Languages:	C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, 
 * Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, 
 * Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, 
 * Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic
 * 
 */

package codewars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlayWithNumbers {
	public static int BLOCK_SIZE = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] NQ = br.readLine().split(" ");
        final int[] A = new int[Integer.parseInt(NQ[0])];
        String[] arrayInput = br.readLine().split(" ");
        for(int i = 0; i < Integer.parseInt(NQ[0]); i++) {
        	A[i] = Integer.parseInt(arrayInput[i]);
        }
        
        final Query[] queries = new Query[Integer.parseInt(NQ[1])];
        for(int i = 0; i < Integer.parseInt(NQ[1]); i++) {
        	String[] queryInput = br.readLine().split(" ");
        	queries[i] = new Query(i, Integer.parseInt(queryInput[0])-1, Integer.parseInt(queryInput[1])-1);
        }
        BLOCK_SIZE = (int) Math.sqrt(A.length);
        System.out.println(Arrays.stream(solve(A, queries))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")));
	}
	
	public static int[] solve(final int[] a, final Query[] queries) {
        Arrays.parallelSort(queries);
        int start = queries[0].left, end = start-1;
        final int answers[] = new int[queries.length];
        int sum = 0;
        for (final Query query : queries) {
            while (start < query.left) {
            	sum -= a[start]; 
                start++;
            }
            while (start > query.left) {
                start--;
                sum += a[start];
            }
            while (end < query.right) {
                end++;
                sum += a[end];
            }
            while (end > query.right) {
                sum -= a[end];
                end--;
            }
            answers[query.index] = (int) Math.floor(sum/(end-start+1));
        }
        return answers;
    }
}

class Query implements Comparable<Query> {
    final int index, left, right;

    public Query(final int index, final int left, final int right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(final Query other) {
        final int leftBlockIndex = this.left / PlayWithNumbers.BLOCK_SIZE;
        final int otherLeftBlockIndex = other.left / PlayWithNumbers.BLOCK_SIZE;
        return leftBlockIndex - otherLeftBlockIndex != 0
                ? leftBlockIndex - otherLeftBlockIndex : right - other.right;
    }

    @Override
    public String toString() {
        return "Query{" +
                "index=" + index +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
