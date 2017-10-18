package dp;

public class booleanPara {
	
	public static void main(String[] args) {
		char[] symbol = {'T','T','F','T'};
		char[] oper = {'|', '&', '^'};
		int n = symbol.length;
		System.out.println("Number of ways: " + ways(symbol, oper, n));
	}
	
	public static int ways(char[] sym, char[] oper, int n) {
		int[][] T = new int[n][n];
		int[][] F = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			T[i][i] = (sym[i] == 'T')?1:0;
			F[i][i] = (sym[i] == 'F')?1:0;
		}
		for(int gap = 1; gap < n; gap++) {
			for(int i = 0, j = gap; j < n; j++, i++) {
				T[i][j] = F[i][j] = 0;
				for(int g = 0; g < gap; g++) {
					
					int k = i + g;
					
					int total_ik = T[i][k] + F[i][k];
					int total_k1j = T[k+1][j] + F[k+1][j];
					
					if(oper[k] == '&') {
						T[i][j] += T[i][k] * T[k+1][j];
						F[i][j] += (total_ik * total_k1j) - (T[i][k] * T[k+1][j]);
					}
					else if(oper[k] == '|') {
						T[i][j] += (total_ik * total_k1j) - (F[i][k] * F[k+1][j]);
						F[i][j] += F[i][k] * F[k+1][j];
					}
					else if(oper[k] == '^') {
						T[i][j] += T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j];
						F[i][j] += T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j];
					}
				}
			}
		}
		return T[0][n-1];
	}
}

/*Time Complexity: O(n3)
Auxiliary Space: O(n2)
http://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/
https://www.youtube.com/watch?v=oyj9tRZhmis

boolean expression:
TTFT
gap = 1 to n
i = 0 and j = gap to n
g = 0 to gap
T[0][1] = 0
F[0][1] = 0
k=i+g so runs in between i & j

T:
1 0 0 0 
0 1 0 0
0 0 0 0
0 0 0 1

F:
0 0 0 0 
0 0 0 0
0 0 1 0
0 0 0 0
*/