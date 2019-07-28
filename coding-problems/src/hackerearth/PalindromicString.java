/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicString {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        char[] nameToCharArray = name.toCharArray();
        char[] resultantArray = new char[name.length()];
        int j = 0;
        for(int i = nameToCharArray.length-1; i >= 0; i--){
            resultantArray[j] = nameToCharArray[i];
            j++;            
        }
        if(name.equals(new String(resultantArray))){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
	}

}
