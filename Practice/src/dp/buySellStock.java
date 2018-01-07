package dp;

/* Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one 
share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

I just come across this problem, and it’s very frustating since I’m bad at DP.

So I just draw all the actions that can be done.

Here is the drawing (Feel like an elementary …)
//diagram at: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928

There are three states, according to the action that you can take.

Hence, from there, you can now the profit at a state at time i as:

s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
Then, you just find the maximum of s0[n] and s2[n], since they will be the maximum profit we need (No one can buy stock and left with more profit that sell right :) )

Define base case:

s0[0] = 0; // At the start, you don't have any stock if you just rest
s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
s2[0] = INT_MIN; // Lower base case

 */

public class buySellStock {
	    public int maxProfit(int[] prices) {
	        if (prices.length <= 1) 
	            return 0;
	        
	        int[] s0 = new int[prices.length];
	        int[] s1 = new int[prices.length];
	        int[] s2 = new int[prices.length];
	        
	        s0[0] = 0; // At the start, you don't have any stock if you just rest
	        s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
	        s2[0] = Integer.MIN_VALUE; // Lower base case
	        
	        for(int i = 1; i < prices.length; i++) {
	            s0[i] = Math.max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
	            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
	            s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
	        }
	        //Then, you just find the maximum of s0[n] and s2[n], since they will be the maximum profit we need 
	        //(No one can buy stock and left with more profit that sell right)
	        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);    
	    }
}
