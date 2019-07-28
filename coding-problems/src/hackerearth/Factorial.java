/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-factorial/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());                // Reading input from STDIN
        System.out.print(factorial(N));
	}
	
	public static int factorial(int N){
        if(N == 0 || N == 1){
            return 1;
        }else{
            return N * factorial(N-1);
        }
    }

}
