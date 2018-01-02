package Design;

/* Leetcode: https://leetcode.com/problems/game-of-life/discuss/73223
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.


To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let’s count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell’s 1st state by doing >> 1.
For each cell’s 1st bit, check the 8 pixels around itself, and set the cell’s 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1

 */

public class gameOfLife {
	    
	    int[] rcnt = {-1, 0, 1, 1, 1, 0, -1, -1};
	    int[] ccnt = {-1, -1, -1, 0, 1, 1, 1, 0};
	    
	    public void gameOfLife1(int[][] board) {
	        if(board == null || board[0].length == 0)
	            return;
	        int m = board.length, n = board[0].length;
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                int lives = getLiveCount(board, i, j, m, n);
	                if(board[i][j] == 1 && lives >= 2 && lives <= 3) {
	                    board[i][j] = 3; //live in the next state
	                }
	                if(board[i][j] == 0 && lives == 3)
	                    board[i][j] = 2; // live in the next state
	            }
	        }
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                board[i][j] = board[i][j] >> 1;  // Get the 2nd state.
	            }
	        }
	    }
	    
	    public int getLiveCount(int[][]b, int i, int j, int m, int n) {
	        int lives = 0;
	        for(int k = 0; k < 8; k++) {
	            int x = i+rcnt[k];
	            int y = j+ccnt[k];
	            if(x < 0 || x >= m || y < 0 || y >= n)
	                continue;
	            lives += b[x][y] & 1; //just get the current state of live members         
	        }
	        return lives; 
	    }
}
