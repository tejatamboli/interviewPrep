package dp;

/* Leetcode: https://leetcode.com/problems/maximal-square/description/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Top, Left, and Top Left decides the size of the square. If all of them are same, then the size of square increases by 1. 
If they’re not same, they can increase by 1 to the minimal square. 
If you take an example and work it out, it’ll be much easier to understand when it comes to dynamic programming. :)
 */

public class maximalSquare {	
	    public int maximalSquare1(char[][] m) {
	        if(m == null || m.length == 0)
	            return 0;
	        int[][]dp = new int[m.length+1][m[0].length+1];
	        int max = Integer.MIN_VALUE;
	        int max_i = 0, max_j = 0;
	        
	        for(int i = 1; i <= m.length; i++) {
	            for(int j = 1; j <= m[0].length; j++) {
	                if(m[i-1][j-1] == '1') {
	                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
	                    //System.out.println("i: " + i + " j: " + j + " dp: " + dp[i][j]);
	                    if(dp[i][j] > max) {
	                        max = dp[i][j];
	                        max_i = i;
	                        max_j = j;
	                    }
	                }
	            }
	        }
	        System.out.print("Square starts from: ( " + (max_i-max) + " , " + (max_j - max) + " ) to: ");
	        System.out.println("( " + max_i + " , " + max_j + " )");
	        return max * max;      
	    }
}
