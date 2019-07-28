/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/modify-the-string/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleString {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuffer str = new StringBuffer(S);
        convertOpposite(str);
        System.out.println(str);
	}
	public static void convertOpposite(StringBuffer str){
        int strLength = str.length();
        for(int i = 0; i < strLength; i++){
            Character c = str.charAt(i);
            if(Character.isLowerCase(c)){
                str.replace(i, i+1, Character.toUpperCase(c)+"");
            }else{
                str.replace(i, i+1, Character.toLowerCase(c)+"");
            }
        }
    }
}
