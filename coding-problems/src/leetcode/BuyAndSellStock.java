
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
package leetcode;

public class BuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	/**
	 * Algorithm : One Pass Approach
	 * The points of interest are the peaks and valleys in the given graph. 
	 * We need to find the largest price following each valley, which difference could be the max profit.
	 * We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit 
	 * (maximum difference between selling price and minprice) obtained so far respectively.
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
        int maximumProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            if(prices[i] - min > maximumProfit) {
                maximumProfit = prices[i] - min;
            }
        }
        return maximumProfit;
	}
}
