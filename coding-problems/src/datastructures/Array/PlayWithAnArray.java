/**
 * https://practice.geeksforgeeks.org/problems/play-with-an-array/1
 */
package datastructures.Array;

import java.util.Arrays;
import java.util.Scanner;

public class PlayWithAnArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int[] b = formatArray(a, n);
			int flag = 1;
			if (b.length == a.length) {
				for (int i = 1; i < n; i += 2)
					if (b[i] < b[i - 1])
						flag = 0;
				if (flag == 0)
					System.out.println("0");
				else {
					Arrays.sort(a);
					Arrays.sort(b);
					for (int i = 0; i < n; i++) {
						if (a[i] != b[i])
							flag = 0;
					}
					System.out.println(flag);
				}
			} else
				System.out.println("0");
		}
		sc.close();
	}

	public static int[] formatArray(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

				}
			}
		}
		return a;
	}
}
