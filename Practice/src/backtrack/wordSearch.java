package backtrack;

/* LEetcode: https://leetcode.com/problems/word-search/discuss/
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

public class wordSearch {
	
	    static boolean[][] v;
	    public boolean exist(char[][] b, String word) {
	        v = new boolean[b.length][b[0].length];
	        for(int i = 0; i < b.length; i++) {
	            for(int j = 0; j < b[0].length; j++) {
	                if(word.charAt(0) == b[i][j]) {
	                    if(lookupWord(b, word, i, j, 0) == true)
	                        return true;
	                }
	            }
	        }
	        return false;
	    }
	    
	    public boolean lookupWord(char[][]b, String w, int i, int j, int index) {
	        if(index == w.length())
	            return true;
	        if(i < 0 || i >= b.length || j < 0 || j >= b[0].length || b[i][j] != w.charAt(index) || v[i][j])
	            return false;
	        v[i][j] = true;
	        if( lookupWord(b,w,i+1,j,index+1) ||
	            lookupWord(b,w,i,j+1,index+1) ||
	            lookupWord(b,w,i-1,j,index+1) ||
	            lookupWord(b,w,i,j-1,index+1))
	            return true;
	        
	        v[i][j] = false;
	        return false;
	    }
}
