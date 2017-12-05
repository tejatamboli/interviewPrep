package matrix;

public class MatrixSpiralPrint {
	
	public static void spiralPrint(int m, int n, int arr[][]) {
		int i, k = 0, l = 0;
		/*  k - starting row index
		        m - ending row index
		        l - starting column index
		        n - ending column index
		        i - iterator
		 */
		
		while(k < m && l < n) {
			for(i = l; i < n; i++)
				System.out.print(" " + arr[k][i]);
			k++;
			
			for(i = k; i < m; i++)
				System.out.print(" " + arr[i][n-1]);
			n--;
			
			if(k < m) {
				for(i = n-1; i >= l; i--)
					System.out.print(" " + arr[m-1][i]);
				m--;
			}
			
			if(l < n) {
				for(i = m-1; i >= k; i--)
					System.out.print(" " + arr[i][l]);
				l++;
			}
		}
	}
	
	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		
		spiralPrint(m, n, arr);
	}
}
