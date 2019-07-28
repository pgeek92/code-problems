/**
 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/life-the-universe-and-everything/
 */
package hackerearth;

import java.util.*;

public class LifeTheUniverseAndEverything {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        while(true){
            int number = s.nextInt();
            if(number == 42){
                break;
            }
            System.out.println(number);
        }
        s.close();
	}
}
