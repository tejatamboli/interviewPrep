package Collection;

/* Given a grid of size m by n, write an algorithm that computes all paths from 0,0 to m,n such that 
 * you can always step horizontally or vertically but cannot reverse. 
 */

public class findPAthInMaze {
	public static void main(String[] args) {
		int[][] mat = {{1,2,3,8},{4,5,6,7}};
		printPaths(mat, mat.length, mat[0].length);
	}
	
	public static void printPaths(int[][] mat, int m, int n) {
		int[] path = new int[m+n];
		getPaths(mat, m, n, 0, 0, path, 0);
	}
	
	public static void getPaths(int[][] mat, int m, int n, int i, int j, int[] path, int p_i) {
		
		if(i == m-1) {
			for(int k = j; k < n; k++)
				path[p_i+k-j] = mat[i][k];
			System.out.println();
			for(int k = 0; k < (m+n-1); k++)
				System.out.print(" " + path[k]);
			return;
		}
		if(j == n-1) {
			for(int k = i; k < m; k++)
				path[p_i+k-i] = mat[k][j];
			System.out.println();
			for(int k = 0; k <(m+n-1); k++)
				System.out.print(" " + path[k]);
			return;
		}
		
		path[p_i] = mat[i][j];
		getPaths(mat, m, n, i+1, j, path, p_i+1);
		getPaths(mat, m, n, i, j+1, path, p_i+1);		
	}
}

/*
 *  Leetcode: https://leetcode.com/problems/unique-paths/discuss/
 * 
 class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i < n; i++)
            grid[0][i] = 1;
        for(int i = 0; i < m; i++)
            grid[i][0] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++)
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
        }
        return grid[m-1][n-1];
    }
}
*/
