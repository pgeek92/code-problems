/**
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/z-algorithm/practice-problems/algorithm/ascii-value/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASCIIValue {

	public static void main(String[] args) throws IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        char character = name.charAt(0); // This gives the character 'a'
        System.out.println((int) character);
	}

}
