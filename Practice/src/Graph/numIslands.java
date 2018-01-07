package Graph;


/* Leetcode: https://leetcode.com/problems/number-of-islands/discuss/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class numIslands {
	
	    static int[] rComb = {-1, 0, 0, 1};
		static int[] cComb = {0, 1, -1, 0};
	    
	    public int numIslands1(char[][] grid) {
	        if(grid == null || grid.length == 0)
	            return 0;
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        int count = 0;
	        for(int i = 0; i < grid.length; i++) {
	            for(int j = 0; j < grid[0].length; j++) {
	                if(grid[i][j] == '1' && !visited[i][j]) {
	                    count++;
	                    dfs(grid, visited, i, j);
	                }
	            }
	        }
	        return count;
	    }
	    
	    public void dfs(char[][]g, boolean[][] visited, int r, int c) {
	        visited[r][c] = true;
	        for(int i = 0; i < 4; i++) {
	            int r1 = r + rComb[i];
	            int c1 = c + cComb[i];
	            if(r1 >= 0 && r1 < g.length && c1 >= 0 && c1 < g[0].length && g[r1][c1] == '1' && !visited[r1][c1])
	                dfs(g, visited, r1, c1);
	        }
	    }
	    
	    
	

}
