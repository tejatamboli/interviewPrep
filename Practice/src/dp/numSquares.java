package dp;

/*
 * https://leetcode.com/problems/perfect-squares/description/
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

public class numSquares {
	    public int numSquares1(int n) {
	        int[] dp = new int[n+1];
	        dp[0] = 0;
	        for(int i = 1; i <= n; i++) {
	            int j = 1;
	            int min = Integer.MAX_VALUE;
	            while((i-j*j) >= 0) {
	                min = Math.min(dp[i-j*j] + 1, min);
	                j++;
	            }
	            dp[i] = min;
	        }
	        return dp[n];
	    }
}
