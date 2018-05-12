/**
 * Bob and Array Queries
 * 
 * Bob has an array A[] of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

 * There are three types of operations that can be performed:

 * 1 X: Update the value of A[X] to  2 * A[X] + 1.
 * 2 X: Update the value A[X] to  A[x]/2 , where  is Greatest Integer Function.
 * 3 X Y: Take all the A[i] such that  X <= i <= Y and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
 * Note: It is guaranteed that there is at least 1 type-3 query in the every test case. All the array elements will fit into 64 bit integers.

 * Input Format:
 * First line consists of two space-separated integers N and Q.
 * Next, Q lines consist of Q operations of either of the 3 types as described above.

 * Output Format:
 * For each type-3 query print the answer that is the no. of '1' in the resulting string.

 * Constraints:
 * 1 <= N <= 50000000
 * 1 <= Q <= 10^5
 * 
 * Sample Input
 * 5 5
 * 1 1
 * 1 2
 * 1 3
 * 3 1 3
 * 3 2 4

 * Sample Output
 * 3
 * 2

 * Explanation
 
 * Initially, A=[0,0,0,0,0]
 * After 1st query, A=[1,0,0,0,0]

 * After 2nd query, A=[1,1,0,0,0]
 * After 3rd query, A=[1,1,1,0,0]

 * For 4th query, no. of '1' in binary representation of A[1]=A[2]=A[3]=1. So, answer=3.

 * For 5th query, answer is 2.

 * Note: Your code should be able to convert the sample input into the sample output. 
 * However, this is not enough to pass the challenge, because the code will be run on multiple test cases. 
 * Therefore, your code must solve this problem statement.
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: Java, Java 8.
 * 
 */

package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BobAndArrayQueries {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayOfFirstInput = br.readLine().split(" "); // Reading input from STDIN
        int A[] = new int[Integer.parseInt(arrayOfFirstInput[0])];
        Arrays.fill(A, 0);
        int count;
        for(int i = 0; i < Integer.parseInt(arrayOfFirstInput[1]); i++){
            count = 0;
            String msg = br.readLine();
            String[] arrayOfSecondInput = msg.split(" ");
            if(Integer.parseInt(arrayOfSecondInput[0]) == 1){
                A[Integer.parseInt(arrayOfSecondInput[1])-1] = 2*A[Integer.parseInt(arrayOfSecondInput[1])-1] + 1;
            }else if(Integer.parseInt(arrayOfSecondInput[0]) == 2){
                A[Integer.parseInt(arrayOfSecondInput[1])-1] = (int) Math.floor(A[Integer.parseInt(arrayOfSecondInput[1])-1]/2);
            }else{
                for(int j = Integer.parseInt(arrayOfSecondInput[1])-1; j < Integer.parseInt(arrayOfSecondInput[2]); j++)
                {
                    if(A[j] == 1){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
	}
}
