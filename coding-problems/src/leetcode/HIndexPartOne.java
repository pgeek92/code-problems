/**
 * Given an array of citations (each citation is a non-negative integer) 
 * of a researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has 
 * index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each."
 * 
 * Example:
 * 
 * Input: citations = [3,0,6,1,5]
 * Output: 3 
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
 *              received 3, 0, 6, 1, 5 citations respectively. 
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining 
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * 
 */
package leetcode;

import java.util.Arrays;

public class HIndexPartOne {

	public static void main(String[] args) {
		System.out.println(hIndexApproachOne(new int[] {3, 0, 6, 1, 5}));
		System.out.println(hIndexApproachTwo(new int[] {3, 0, 6, 1, 5}));
	}
	
	/**
	 * Time Complexity : O(NlogN)
	 * Space Complexity : O(1)
	 * 
	 * @param citArr
	 * @return
	 */
	public static int hIndexApproachOne(int[] citArr) {
		Arrays.sort(citArr);
        int i = 0;
        while (i < citArr.length && citArr[citArr.length - 1 - i] > i) {
            i++;
        }
        return i;
	}
	
	/**
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 * 
	 * @param citArr
	 * @return
	 */
	public static int hIndexApproachTwo(int[] citArr) {
		int n = citArr.length;
		int[] papersCount = new int[n+1];
		for(int i : citArr) {
			papersCount[Math.min(n, i)]++;
		}
		int k = n;
		for(int s = papersCount[n]; k > s; s+= papersCount[k]) {
			k--;
		}
		return k;
	}

}
