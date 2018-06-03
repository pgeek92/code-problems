/**
 * You take your son to the forest to see the monkeys. 
 * You know that there are a certain number there (n), 
 * but your son is too young to just appreciate the full number, 
 * he has to start counting them from 1.
 * 
 * As a good parent, you will sit and count with him. Given the number (n), 
 * populate an array with all numbers up to and including that number, but excluding zero.
 * 
 * For example, if n = 10:
 * 
 * return [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 
 */

package codewars;

public class MonkeyCounter {
	public static int[] monkeyCount(final int n) {
		int[] monkeyCountArray = new int[n];
		for (int i = 0; i < n; i++) {
			monkeyCountArray[i] = i + 1;
		}
		return monkeyCountArray;
	}
	
	public static void main(String[] args) {
		System.out.println(monkeyCount(12));
	}
}
