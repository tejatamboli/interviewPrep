package matrix;

/* Leetcode: https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */

public class setMatrixZero {
	
	    public void setZeroes(int[][] m) { 
	        boolean row0 = false, col0 = false;
	        for(int i = 0; i < m.length; i++) {
	            for(int j = 0; j < m[0].length; j++) {
	                if(m[i][j] == 0) {
	                    if(i == 0) 
	                        row0 = true;
	                    if(j == 0)
	                        col0 = true;
	                    m[0][j] = 0;
	                    m[i][0] = 0;
	                    System.out.println("i: " + i + " j: " + j);
	                }
	            }
	        }
	        for(int i = 1; i < m.length; i++) {
	            for(int j = 1; j < m[0].length; j++) {
	                if(m[i][0] == 0 || m[0][j] == 0) {
	                    System.out.println("0 i: " + i + " j: " + j);
	                    m[i][j] = 0;
	                }
	            }
	        }
	        if(row0) {
	            for(int i= 0;i<m[0].length;i++)
	                m[0][i]=0;
	        }
	        if(col0) {
	            for(int i= 0;i<m.length;i++)
	                m[i][0]=0;
	        }
	    }
	

}
