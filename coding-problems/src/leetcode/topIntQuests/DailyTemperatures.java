/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you 
 * how many days you would have to wait until a warmer temperature. If there is no future day for which 
 * this is possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer 
 * in the range [30, 100]
 * 
 */
package leetcode.topIntQuests;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		int[] ans = naiveSoln(T);
		
		Arrays.stream(ans).forEach(e-> System.out.print(e + " "));
		
		ans = optimizedSoln(T);
		
		System.out.println();
		Arrays.stream(ans).forEach(e-> System.out.print(e + " "));
	}
	
	/**
	 * Brute Force approach 
	 * Time Complexity : O(N*N), where N is the size of T array
	 * Space Complexity : O(W), where W is the number of allowed values in T[i]
	 * 
	 * @param T
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int[] naiveSoln(int[] T) {
		int arrLength = T.length;
        int count;
        int[] result = new int[T.length];
        outer : for(int i = 0; i < arrLength; i++) {
            count = 0;
            inner : for(int j = i+1; j < arrLength; j++) {
                if(T[j] > T[i]) {
                    count++;
                    result[i] = count;
                    break inner;
                } else {
                    count++;
                }
            }
        }
        
        return result;
	}
	
	/**
	 * This solution is based on the concept of Stack (Next Greater Element)
	 * Time Complexity : O(N)
	 * Space Complexity : O(W), where W is the number of allowed values in T[i]
	 * 
	 * @return
	 */
	public static int[] optimizedSoln(int[] T) {
		int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
	}
}
