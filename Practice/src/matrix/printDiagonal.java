package matrix;

//LinkedIn careercup
/* Print an NxM matrix with nw-se diagonals starting at bottom left corner. Ex:
 * AntiDiagonal
 */
public class printDiagonal {
	
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},{17, 18, 19, 20}};
		
		int m = arr.length;
		int n = arr[0].length;
		
		printDiagonalI(arr, m, n);
		printAntiDiagonal(arr, m, n);
		
	}
	
	public static void printDiagonalI(int[][] arr, int m, int n) {
		for(int i = 0; i < m; i++) {
			System.out.println();
			for(int j = i, k = 0; j >= 0 && k <= i && k < n; j--, k++) {
				System.out.print(" " + arr[j][k]);
			}
		}
		for(int i = 1; i < m; i++) {
			System.out.println();
			for(int j = m-1, k = i; j > i && k < n; j--, k++)
				System.out.print(" " + arr[j][k]);
		}
	}
	
	public static void printAntiDiagonal(int[][] arr, int m, int n) {
		for(int i = 0; i < m; i++) {
			System.out.println();
			for(int j = m-1-i, k = 0; j < m && k <= i && k < n; j++, k++) {
				System.out.print(" " + arr[j][k]);
			}
		}
		
		for(int i = 1; i < m; i++) {
			System.out.println();
			for(int j = 0, k = i; k < n; j++, k++)
				System.out.print(" " + arr[j][k]);
		}
	}
}


/* Diagonal
00
10 01
20 11 02
30 21 12 03
40 31 22 13 == divison afterwards
41 32 23
42 33
43

	1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20

*/


/* AntiDiagonal
 * {1, 2, 3, 4}, 
 * {5, 6, 7, 8}, 
 * {9, 10, 11, 12}, 
 * {13, 14, 15, 16},
 * {17, 18, 19, 20}
 * 
 * 40
 * 30 41
 * 20 31 42
 * 10 21 32 43
 * 00 11 22 33 ->
 * 01 12 23
 * 02 13
 * 03
 */



