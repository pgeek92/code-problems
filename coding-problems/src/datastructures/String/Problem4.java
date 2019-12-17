/**
 * Lexicographic rank of given String
 * Example : STRING
 * Output  : 598
 * 
 * Given a string, find its rank among all its permutations sorted lexicographically. 
 * For example, rank of "abc" is 1, rank of "acb" is 2, and rank of "cba" is 6
 * 
 */
package datastructures.String;

public class Problem4 {

	public static void main(String[] args) {
		String str = "string";
		System.out.println(lexicographicRank(str));
	}
	
	public static int lexicographicRank(String str) {
		int rank = 1;
		int strLength = str.length();
		int mul = factorial(strLength);
		int count[] = new int[256];
		for(int i = 0; i < strLength; i++) {
			count[str.charAt(i)]++;
		}
		
		for(int i = 1; i < 256; i++) {
			count[i] += count[i-1];
		}
		
		for(int i = 0; i < strLength; i++) {
			mul /= (strLength-i);
			rank += count[str.charAt(i) - 1] * mul;
			for(int j = str.charAt(i); j < 256; j++) {
				count[j]--;
			}
		}
		
		return rank;
	}
	
	public static int factorial(int number) {
		return number <= 1 ? 1 : number * factorial(number - 1);
	}
}
