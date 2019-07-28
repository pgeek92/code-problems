/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
 */
package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeatingArrangement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            seatingArrangement(Integer.parseInt(br.readLine()));
        }
	}
	public static void seatingArrangement(int N){
        int remainder = 0;
        remainder = N%12;
        switch(remainder){
            case 0:
			System.out.println(""+(N-11)+" WS");
			break;
			
			case 1:
			System.out.println(""+(N+11)+" WS");
			break;
 
			case 2:
			System.out.println(""+(N+9)+" MS");
			break;
 
			case 3:
			System.out.println(""+(N+7)+" AS");
			break;
 
			case 4:
			System.out.println(""+(N+5)+" AS");
			break;
 
			case 5:
			System.out.println(""+(N+3)+" MS");
			break;
 
			case 6:
			System.out.println(""+(N+1)+" WS");
			break;
 
			case 7:
			System.out.println(""+(N-1)+" WS");
			break;
 
			case 8:
			System.out.println(""+(N-3)+" MS");
			break;
 
			case 9:
			System.out.println(""+(N-5)+" AS");
			break;
 
			case 10:
			System.out.println(""+(N-7)+" AS");
			break;
 
			case 11:
			System.out.println(""+(N-9)+" MS");
			break;
        }
    }
}
