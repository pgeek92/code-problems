/**
 * https://www.hackerrank.com/challenges/arrays-ds/problem
 */
package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class ReverseArray {

	static int[] reverseArray(int[] a) {
		int[] reversedArray = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			reversedArray[i] = a[a.length - i - 1];
		}
		return reversedArray;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int arrCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[arrCount];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arrCount; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] res = reverseArray(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
		scanner.close();
	}

}
