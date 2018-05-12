/**
 * Poisonous gas
 * 
 * You are in a battle field and your enemy has an army of N soldiers. 
 * Each soldier has a strength denoted by an array A. 
 * Your enemy will select some soldiers such that total strength of selected soldiers is maximum. 
 * You have a poisonous gas and you can use it on the selected soldiers as many times as you want. 
 * If the total strength is even, the poisonous gas will decrease the total strength of 
 * the selected soldiers to half of the total strength, otherwise it will not affect them. 
 * Your task is to tell if its possible to reduce the total strength to 1 or not.
 * 
 * Input Format:
 *  
 * First line contains an integer T, denoting the number of test cases.
 * 
 * First line of each test case contains an integer N, denoting the number of soldiers.
 * 
 * Second line of each test case contains N space-separated integers, denoting the strength of the soldiers.
 * 
 * Output Format:
 * 
 * For each test case, print Yes if its possible to reduce the total strength to 1, otherwise print No. 
 *  
 * Constraints: 
 * 
 * 1 <= T <= 10 
 * 1 <= N <= 10^5 
 * -10^9 <= A[] <= 10^9 
 *  
 * Sample Input
 * 2
 * 5
 * 76 56 -21 76 -45 
 * 2
 * 8 -4
 * 
 * Sample Output
 * No
 * Yes
 * 
 * Explanation
 * 
 * Test case 1: n = 5 and maximum total strength is 76 + 56 + 76 = 208. You can not reduce 208 to 1 by using the poisonous gas.
 * 
 * Test case 2: n = 2 and maximum total strength is 8. First time when you will use the poisonous gas, 
 * total strength will reduce to 4. Second time when you will use the poisonous gas, total strength will reduce to 2. 
 * Third time when you will use the poisonous gas, total strength will reduce to 1. 
 * Therefore, the answer is Yes
 * 
 * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: Java, Java 8
 * 
 */


package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PoisonousGas {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLineInput = br.readLine();
		String secondLineInput;
		int N = 0;
		int T = Integer.parseInt(firstLineInput);
		int []A;
		int maximumStrengthSum = 0;
		for(int i = 0; i < T; i++){
			secondLineInput = br.readLine();
			N = Integer.parseInt(secondLineInput);
			A = new int[N];
        
			String input = br.readLine();
			String[] arrayInputs = input.split(" ");
			for(int k = 0; k < arrayInputs.length; k++){
				A[k] = Integer.parseInt(arrayInputs[k]);
			}
			
			maximumStrengthSum = maxSubArraySum(A);
			int temp = maximumStrengthSum;
			while(temp % 2 == 0){
				temp = temp / 2;
			}
			if(temp == 1){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
    
    static int maxSubArraySum(int []A){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i = 0;i < A.length; i++){
            maxEndingHere += A[i];
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
