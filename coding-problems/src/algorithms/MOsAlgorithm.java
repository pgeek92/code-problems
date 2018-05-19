/**
 * Given a sequence of n numbers a1, a2, ..., an and a number of d-queries. A d-query is a pair (i, j) (1 ≤ i ≤ j ≤ n). For each d-query (i, j), you have to return the number of distinct elements in the subsequence ai, ai+1, ..., aj.
 * 
 * Input
 * 
 * Line 1: n (1 ≤ n ≤ 30000).
 * Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 106).
 * Line 3: q (1 ≤ q ≤ 200000), the number of d-queries.
 * In the next q lines, each line contains 2 numbers i, j representing a d-query (1 ≤ i ≤ j ≤ n).
 * 
 * Output
 * 
 * For each d-query (i, j), print the number of distinct elements in the subsequence ai, ai+1, ..., aj in a single line.
 * 
 * Example
 * 
 * Input
 * 5
 * 1 1 2 1 3
 * 3
 * 1 5
 * 2 4
 * 3 5
 * 
 * Output
 * 3
 * 2
 * 3
 *  
 */

package algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MOsAlgorithm {
    public static int BLOCK_SIZE = 0;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] A = new int[N];
        String[] arrayInput = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
        	A[i] = Integer.parseInt(arrayInput[i]);
        }
        final int Q = Integer.parseInt(br.readLine());
        final Query[] queries = new Query[Q];
        for(int i = 0; i < Q; i++) {
        	String[] queryInput = br.readLine().split(" ");
        	queries[i] = new Query(i, Integer.parseInt(queryInput[0])-1, Integer.parseInt(queryInput[1])-1);
        }
        BLOCK_SIZE = (int) Math.sqrt(A.length);
        System.out.println(Arrays.stream(new MOsAlgorithm().solve(A, queries))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")));
    }

    public int[] solve(final int[] a, final Query[] queries) {
        Arrays.parallelSort(queries);
        int start = queries[0].left, end = start;
        final int frequencies[] = new int[1000001];
        final int answers[] = new int[queries.length];
        frequencies[a[start]]++;
        int count = 1;
        for (final Query query : queries) {
            while (start < query.left) {
                frequencies[a[start]]--;
                if (frequencies[a[start]] == 0) {
                    count--;
                }
                start++;
            }
            while (start > query.left) {
                start--;
                frequencies[a[start]]++;
                if (frequencies[a[start]] == 1) {
                    count++;
                }
            }
            while (end < query.right) {
                end++;
                frequencies[a[end]]++;
                if (frequencies[a[end]] == 1) {
                    count++;
                }
            }
            while (end > query.right) {
                frequencies[a[end]]--;
                if (frequencies[a[end]] == 0) {
                    count--;
                }
                end--;
            }
            answers[query.index] = count;
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
        final int leftBlockIndex = this.left / MOsAlgorithm.BLOCK_SIZE;
        final int otherLeftBlockIndex = other.left / MOsAlgorithm.BLOCK_SIZE;
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
