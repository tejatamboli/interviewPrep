package Design;

/* Leetcode: https://leetcode.com/problems/design-tic-tac-toe/description/
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, 
or diagonal row wins the game.

 */


	class TicTacToe {

	    /** Initialize your data structure here. */
	    private int[] rows;
	    private int[] cols;
	    private int size;
	    private int diagonal;
	    private int anti_diagonal;
	        
	    public TicTacToe(int n) {
	        size = n;
	        rows = new int[n];
	        cols = new int[n];
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) {
	        int add = 0;
	        add = player == 1 ? 1 : -1;
	        if(row == col)
	            diagonal += add;
	        if(col == size - 1 - row)
	            anti_diagonal += add;
	        rows[row] += add;
	        cols[col] += add;
	        if(Math.abs(rows[row]) == size || 
	           Math.abs(cols[col]) == size || 
	           Math.abs(diagonal) == size ||
	           Math.abs(anti_diagonal) == size)
	            return player;
	        return 0;          
	    }
	}

	/**
	 * Your TicTacToe object will be instantiated and called as such:
	 * TicTacToe obj = new TicTacToe(n);
	 * int param_1 = obj.move(row,col,player);
	 */
