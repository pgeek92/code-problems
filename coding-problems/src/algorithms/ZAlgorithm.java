/**
 * Z Algorithm for Pattern Matching
 * 
 * Time complexity = O(N+M) where N -> length of input where pattern to be matched
 *                                M -> length of pattern
 * Space complexity = O(N+M)
 * 
 * Z Array : 
 * For a string str[0..n-1], Z array is of same length as string. 
 * An element Z[i] of Z array stores length of the longest substring 
 * starting from str[i] which is also a prefix of str[0..n-1]. 
 * The first entry of Z array is meaning less as complete string is always prefix of itself.
 * 
 * http://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
 * http://www.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
 * https://www.youtube.com/watch?v=CpZh4eF8QBw - Thank you Tushar for the wonderful explanation
 * 
 */

package algorithms;

public class ZAlgorithm {
	public static void main(String[] args) {
		String input = "abaaa";
		int[] zArr = calculateZArray(input.toCharArray());
		int sum = input.length();
		for(int i = 0; i < zArr.length; i++) {
			sum += zArr[i];
		}
		System.out.println(sum);
	}
	
	public static int[] calculateZArray(char[] input) {
		int[] zArr = new int[input.length];
		int left = 0;
		int right = 0;
		for(int k = 1; k < input.length; k++) {
			if(k > right) {
				left = right = k;
				right = repeatableCode(input, zArr, left, right, k);
			}else {
				// We're operating inside zArr box
				int k1 = k - left;
				// if value doesn't stretches till right bound then just copy it. Just to reduce comparisons
				if(zArr[k1] < right - k + 1) {
					zArr[k] = zArr[k1];
				}else { // otherwise try to see of there are more matches
					left = k;
					right = repeatableCode(input, zArr, left, right, k);
				}
			}
		}
		return zArr;
	}
	
	private static int repeatableCode(char[] input, int[] zArr, int left, int right, int k) {
		while(right < input.length && input[right] == input[right - left]) {
			right++;
		}
		zArr[k] = right - left;
		right--;
		return right;
	}
}
