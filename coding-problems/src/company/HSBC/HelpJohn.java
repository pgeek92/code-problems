/**
 * https://www.hackerearth.com/challenges/hiring/HSBC-java-developer-hiring/algorithm/not-decided-1ca0c947/
 */
package company.HSBC;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class HelpJohn {

	static TreeSet<Integer> ts = new TreeSet<Integer>();
    public static void main(String[] args) throws IOException {
    	
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i_arr=0; i_arr<N; i_arr++)
        {
            solve(sc.nextInt());
        }
        sc.close();
    }
    static void solve(int N){
    	Integer smaller =ts.lower(N);
    	Integer larger  = ts.higher(N);
    	if(smaller == null){
    		smaller = -1;
    	}
    	if(larger  == null){
    		larger = -1;
    	}
        System.out.println(smaller + " " + larger);
        ts.add(N);
    }
}
