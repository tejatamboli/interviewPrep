package matrix;

public class matrixMultiplication {
	public static void main(String[] args) {
		int[][] A = {{1,0,0},{-1,0,3}};
		int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
		int[][]C = multiply(A, B);
		for(int i = 0; i < C.length; i++) {
			System.out.println("");
			for(int j = 0; j < C[0].length; j++) {
				System.out.print(" " + C[i][j]);
			}
		}
	}
	
	public static int[][] multiply(int[][] A, int[][] B) {
        int m1 = A.length;
        int n1 = A[0].length;
        int m2 = B.length;
        int n2 = B[0].length;
        
        int[][]res = new int[m1][n2];
        
        if(n1 != m2)
            return res;
        
        for(int i = 0; i < m1; i++) {
        		for(int k = 0; k < n1; k++) {
        			if(A[i][k] != 0) {
        				for(int j = 0; j < n2; j++) {
                        if(B[k][j] != 0)
                            res[i][j]  += A[i][k] * B[k][j];
                    }
                }
        		}
        }
        return res;
    }
}

/* 
1 2 3     10 11 12      res[0][0] += 1*10 + 2*13 + 3*16
4 5 6     13 14 15      res[0][1] += 1*11 + 2*14 + 3*17
7 8 9     16 17 18      res[0][2] += 1*12 + 2*15 + 3*18
*/