/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/intelligent-girl-1/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntelligentGirl {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberString = br.readLine();
        int lenStr = numberString.length();
        int[] outArr = new int[lenStr+1];
        for(int i = lenStr - 1, j = lenStr; i >= 0 && j > 0; i--, j--){
            if(numberString.charAt(i) % 2 == 0){
                outArr[i] = outArr[j] + 1;
            }else{
                outArr[i] = outArr[j];
            }
        }
        for(int i = 0; i < lenStr; i++){
            System.out.print(outArr[i] + " ");
        }
	}

}
