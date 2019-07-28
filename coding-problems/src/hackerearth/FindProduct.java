/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/
 */
package hackerearth;

import java.util.Scanner;

public class FindProduct {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long answer = 1;
        for(int i = 0; i < N; i++){
            answer = (answer*s.nextLong()) % 1000000007;
        }
        System.out.println(answer);
        s.close();
	}

}
