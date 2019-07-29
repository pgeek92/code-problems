/**
 * https://www.hackerearth.com/challenges/hiring/HSBC-java-developer-hiring/algorithm/alice-and-marks-hsbc-b18d5d01/
 */
package company.HSBC;

import java.util.Scanner;

public class SamHeight {

	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            int out = solve(arr, S);
            System.out.println(out);
        }
        sc.close();
    }
    static int solve(int[] arr, int S){
        int lessHeightCount = 0;
        int moreHeightCount = 0;
        for(int height : arr){
            if(height < S){
                lessHeightCount++;
            }else{
                moreHeightCount++;
            }
        }
        return Math.abs(moreHeightCount-lessHeightCount);
    }

}
