/**
 * Bob and Beauty of the Array
 * Bob is having a array A  of N elements . Bob wants to determine the beauty of the array and 
 * the beauty of the array is defned as :- 
 * 
 * Determine Bitwise OR of maximum and minimum elements  of every subset of size greater 
 * than or equal to  2 and add them. 
 * 
 * As the answer can be quite large , you have to report it by taking modulo with 1000000007 .
 * 
 * Input
 * 
 * First line of the input will contain N , denoting the number of elements of the array.
 * 
 * Second line will contain N spaced integers denoting elements of the array .
 * 
 * 
 * Constraints
 * 1 <= N <= 200000
 * 1 <= A[i] <= 1000
 * 
 * 
 * Output:
 * 
 * For each query you have to output single integer denoting beauty of the array .
 * 
 * Hint:
 * 
 * Hashing
 * 
 * Sample Input
 * 3
 * 2 5 5
 * Sample Output
 * 26
 * Explanation
 * Array contains 3 integers . Thus all subsets having size >= 2 are :- 
 * 
 * { { 2, 5 } , { 2 , 5} , {5 , 5} , {2 , 5 , 5 } } , thus bitwise OR of the maximum and minimum elements of those subsets are
 * 
 * { 7 , 7 , 5 , 7 } respectively , thus summation of all is 7 + 7 + 5 + 7 = 26%1000000007 = 26 .
 * 
 * Note: Your code should be able to convert the sample input into the sample output. 
 * However, this is not enough to pass the challenge, because the code will be run on multiple 
 * test cases. Therefore, your code must solve this problem statement.
 * 
 */

package challenges.samsungR_D;

public class BobAndBeautyOfTheArray {

}
