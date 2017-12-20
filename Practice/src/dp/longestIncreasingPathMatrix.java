package dp;

/* Leetcode: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

public class longestIncreasingPathMatrix {
	int[] row = {0, 1, 0, -1};
    int[] col = {1, 0, -1, 0};
    
    public int longestIncreasingPath(int[][] mat) {
        if(mat.length == 0) return 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(mat, i, j, m, n, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    public int dfs(int[][]mat, int i, int j, int m, int n, int[][]dp) {
        if(dp[i][j] != 0)
            return dp[i][j];
        int max = 1;
        for(int k = 0; k < 4; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if(x < 0 || x >= m || y < 0 || y >= n || mat[x][y] <= mat[i][j])
                continue;
            int len = 1+dfs(mat, x, y, m, n, dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }

}
