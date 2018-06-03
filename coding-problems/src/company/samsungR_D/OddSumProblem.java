/**
 * Samsung R&D Hiring Challenge
 * 
 * Odd sum problem
 * You are given an array A containing N integers. You have to answer Q queries.
 * 
 * Queries are of form:
 * 
 * L R
 * 
 * Here you have to fInd sum of all numbers , for those  which has odd frequency in subarray 
 * L to R
 * 
 * INPUT CONSTRAINTS
 * 1 <= N, Q <= 10^5
 * 1 <= A[i] <= 10^9
 * 1 <= L <= R <= N
 * 
 * INPUT FORMAT
 * 
 * First line of input contains a single integer N, next line contains 
 * N space separated integers, elements of array A. Next line of input contains a 
 * single integer Q. Q lines follow each containing two space separated integer L and R.
 * 
 * OUTPUT Fvv
 * 
 * For each query, print the answer to the query in new line.
 * 
 * Hint:
 * 
 * Mo's Algorithm - Very Important
 * 
 * Sample Input
 * 5
 * 1 2 2 2 1
 * 3
 * 1 3
 * 1 4
 * 1 5
 * 
 * Sample Output
 * 1
 * 7
 * 6
 * 
 * Explanation
 * For query 1: 1 has frequency 1 and 2 has frequency 2 so, answer is 1
 * 
 * For query 2: 1 has frequency 1 and 2 has frequency 3 So, answer is 7
 * 
 * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 * Marking Scheme: Marks are awarded if any testcase passes
 * Allowed Languages: C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, 
 * Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), Julia, Kotlin, Lisp, Lisp (SBCL), 
 * Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, Racket, Ruby, 
 * Rust, Scala, Swift, Visual Basic
 * 
 */

package company.samsungR_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
import java.math.BigInteger;
public class OddSumProblem {
	public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] A = new BigInteger[N];
        String[] arrayInput = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            A[i] = new BigInteger(arrayInput[i]);
        }
        int Q = Integer.parseInt(br.readLine());
        int[] LR = new int[2];
        for(int i = 0; i < Q; i++){
            String[] LRInput = br.readLine().split(" ");
            LR[0] = Integer.parseInt(LRInput[0]);
            LR[1] = Integer.parseInt(LRInput[1]);
            System.out.println(sumOfSubArray(A, LR[0], LR[1]));
        }
    }
    
    public static BigInteger sumOfSubArray(BigInteger[] A, int L, int R){
        Map<BigInteger, BigInteger> hm = new HashMap<BigInteger, BigInteger>();
        BigInteger two = new BigInteger("2");
        BigInteger sum = BigInteger.ZERO;
        for(int i = L-1; i < R; i++){
            if(hm.containsKey(A[i])){
                hm.put(A[i], (hm.get(A[i])).add(BigInteger.ONE));
            }else{
              hm.put(A[i] , BigInteger.ONE);  
            } 
        }
        
        for(Map.Entry<BigInteger, BigInteger> entry : hm.entrySet()){
            if((entry.getValue()).mod(two) != BigInteger.ZERO){
                sum = sum.add((entry.getKey()).multiply(entry.getValue()));
            }
        }
        return sum;
    }
}
