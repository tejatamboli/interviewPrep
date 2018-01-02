package dp;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/coin-change/description/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the 
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination 
 * of the coins, return -1.
Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
 */


public class minCoinsRequired {
	
	    public int coinChange(int[] coins, int amount) {
	        int[] dp = new int[amount + 1];
	        int sum = 0;
	        
	        Arrays.sort(coins);
	        
	        while(++sum <= amount) {
	            int min = -1;
	            for(int coin: coins) {
	                System.out.println("coin: " + coin + " sum: " + sum);
	                if(sum < coin)
	                    break;
	                if(dp[sum-coin] != -1) {
	                    int temp = dp[sum-coin]+1;
	        System.out.println("sum-coin: " + (sum-coin) + " dp: " + dp[sum-coin]);
	                    min = min<0 ? temp : (temp < min ? temp : min);
	                    System.out.println("min: " + min);
	                }
	            }
	            dp[sum] = min;
	        }
	        return dp[amount];
	    }
}

/* 1 2 5 total = 11
sum = 1-1 = 0
temp = min = 1
dp[1] = 1
sum = 2
dp[2] = 1
sum = 3
dp[3] = 2
dp[4] = 2
*/
