package company.samsungR_D;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EfficientOddSumProblem {
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
        System.out.println(Arrays.stream(new EfficientOddSumProblem().solve(A, queries)).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
	}
	
	public int[] solve(final int[] A, final Query[] queries) {
		Arrays.parallelSort(queries);
		int start = queries[0].left;
		int end = start;
		final int[] freq = new int[1000001];
		final int[] answer = new int[queries.length];
		freq[A[start]]++;
		for(Query query : queries) {
			while(start < query.left) {
				freq[A[start]]--;
				start++;
			}
			while (start > query.left) {
                start--;
                freq[A[start]]++;
            }
            while (end < query.right) {
                end++;
                freq[A[end]]++;
            }
            while (end > query.right) {
                freq[A[end]]--;
                end--;
            }
            answer[query.index] = sum(freq);
        }
        return answer;
	}
	
	public int sum(int[] freq) {
		int sum = 0;
		for(int i = 1; i < freq.length; i++) {
			if(freq[i] % 2 != 0) {
				sum = sum + freq[i] * i;
			}
		}
		return sum;
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
		final int leftBlockIndex = this.left / EfficientOddSumProblem.BLOCK_SIZE;
		final int otherLeftBlockindex = other.left / EfficientOddSumProblem.BLOCK_SIZE;
		return leftBlockIndex - otherLeftBlockindex != 0 ? leftBlockIndex - otherLeftBlockindex
				: right - other.right;
	}

	@Override
	public String toString() {
		return "Query {index=" + index + ", left=" + left + ", right=" + right + "}";
	}
}
