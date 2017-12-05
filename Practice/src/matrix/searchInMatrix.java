package matrix;

/* Leetcode: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */

public class searchInMatrix {
	
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
	            return false;
	        }
	        int i = 0;
	        int j = matrix[0].length-1;
	        while(i < matrix.length && j >= 0) {
	            if(matrix[i][j] == target)
	                return true;
	            else if(target > matrix[i][j])
	                i++;
	            else
	                j--;
	        }
	        return false;    
	    }
	

}
