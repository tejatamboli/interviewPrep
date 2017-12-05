package Collection;

/* Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 */

public class buySellStocks {
	    public int maxProfit(int[] prices) {
	        int maxPro = 0;
	        int minPrice = Integer.MAX_VALUE;
	        for(int i = 0; i < prices.length; i++){
	            minPrice = Math.min(minPrice, prices[i]);
	            maxPro = Math.max(maxPro, prices[i] - minPrice);
	        }
	        return maxPro;
	    }
}

/* Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0|| prices.length==1) return 0;
        int max_pro=0;
        for(int i=prices.length-1;i>0;i--){
            if(prices[i]-prices[i-1]>0) 
                max_pro+=prices[i]-prices[i-1];
        }
        return max_pro;    
    }
}


/* Leetcode: https://leetcode.com/problems/factorial-trailing-zeroes/description/
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
class Solution1 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        
    }
}