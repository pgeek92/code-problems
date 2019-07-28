/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/prime-number-8/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        boolean prime[] = new boolean[N+1];
        for(int i=0;i<N;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=N; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*2; i <= N; i += p)
                    prime[i] = false;
            }
        }
         
        for(int i = 2; i <= N; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
	}
}
