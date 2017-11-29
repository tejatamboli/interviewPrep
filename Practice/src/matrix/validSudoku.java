package matrix;
import java.util.*;
/* Leetcode
 * https://leetcode.com/problems/valid-sudoku/discuss/
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(!seen.add(c + " in row " + i) ||
                       !seen.add(c + " in col " + j) ||
                       !seen.add(c + " in cube " + i/3 + "-" + j/3))
                            return false;
                }
            }
        }
        return true;
    }
}
