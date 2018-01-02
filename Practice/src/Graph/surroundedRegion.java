package Graph;

/* Leetcode: https://leetcode.com/problems/surrounded-regions/discuss/41633
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */

public class surroundedRegion {
	class Solution {
	    public void solve(char[][] board) {
	        if(board == null || board.length == 0)
	            return;
	        if (board.length < 2 || board[0].length < 2)
			    return;
	        
	        int m = board.length;
	        int n = board[0].length;
	        
	        //for first and last column
	        for(int i = 0; i < m; i++) {
	                if(board[i][0] == 'O')
	                    dfs(board, i, 0);
	                if(board[i][n-1] == 'O')
	                    dfs(board, i, n-1);
	        }
	        //for first and last row
	        for(int i = 0; i < n; i++) {
	                if(board[0][i] == 'O')
	                    dfs(board, 0, i);
	                if(board[m-1][i] == 'O')
	                    dfs(board, m-1, i);
	        }
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if(board[i][j] == 'O')
	                    board[i][j] = 'X';
	                if(board[i][j] == '*')
	                    board[i][j] = 'O';
	            }
	        }
	    }
	    
	    public void dfs(char[][] board, int r, int c) {
	        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1)
			    return;
	        if(board[r][c] == 'O')
	            board[r][c] = '*';
	        if(r > 1 && board[r-1][c] == 'O')
	            dfs(board, r-1, c);
	        if(r < board.length-2 && board[r+1][c] == 'O')
	            dfs(board, r+1, c);
	        if(c > 1 && board[r][c-1] == 'O')
	            dfs(board, r, c-1);
	        if(c < board[r].length-2 && board[r][c+1] == 'O')
	            dfs(board, r, c+1);
	    }
	}

}
