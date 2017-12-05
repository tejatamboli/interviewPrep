package matrix;

/* You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix = 
[
  [1,2,3],          [1,4,7]
  [4,5,6],     >    [2,5,8]
  [7,8,9]           [3,6,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/

public class rotateMatrix {
	 public void rotate(int[][] m) {
	        //transpose the matrix
	        for(int i = 0; i < m.length; i++) {
	            for(int j = i; j < m[0].length; j++) {
	                int temp = m[i][j];
	                m[i][j] = m[j][i];
	                m[j][i] = temp;
	            }
	        }
	        //clockwise swap columns
	        for(int i = 0; i < m.length; i++) {
	            for(int j = 0; j < (m[0].length)/2; j++) {
	                int temp = m[i][j];
	                m[i][j] = m[i][m[0].length-1-j];
	                m[i][m[0].length-1-j] = temp;
	            }
	        } 
	        //anticlockwise swap rows
	        for(int i = 0; i < m.length/2; i++) {
	            for(int j = 0; j < m[0].length; j++) {
	                int temp = m[i][j];
	                m[i][j] = m[m.length-1-i][j];
	                m[m.length-1-i][j] = temp;
	            }
	        }
	 }
}
