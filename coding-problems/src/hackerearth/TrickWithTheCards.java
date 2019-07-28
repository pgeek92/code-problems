/**
 * https://www.hackerearth.com/problem/algorithm/trick-with-the-cards/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrickWithTheCards {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            long N = Long.parseLong(br.readLine());
            if(N <= 0L){
                System.out.println(0);
            }else if(N <= 2L){
                System.out.println(1);
            }else if(N%3L == 0){
                System.out.println(N/3L);
            }else{
                System.out.println(N);
            }
        }
	}

}
