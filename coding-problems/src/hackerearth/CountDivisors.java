/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/count-divisors/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountDivisors {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArray = br.readLine().split(" ");
        int l = Integer.parseInt(inputArray[0]);
        int r = Integer.parseInt(inputArray[1]);
        int k = Integer.parseInt(inputArray[2]);
        int count = 0;
        if(l <= r){
            for(int i = l; i <= r; i++){
                if(i % k == 0){
                    count++;
                }
            }
        }
        
        System.out.println(count);
	}

}
