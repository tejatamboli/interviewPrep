package dp;

public class strategicGame {
	public static void main(String[] args) {
		int[] a1 = {8,15,3,7};
		int n = a1.length;
		int[] a2 = {5,3,7,10};
		System.out.println("Max ans: " + getVal(a1,n));
	}
	
	public static int getVal(int[] arr, int n) {
		int[][] table = new int[n][n];
		for(int gap = 0; gap < n; gap++) {
			for(int i = 0, j = gap; j < n; i++, j++) {
				int x = ((i+2) <= (j-1)) ? table[i+2][j] : 0;
				int y = ((i+1) <= (j-1)) ? table[i+1][j-1] : 0;
				int z = (i <= (j-2)) ? table[i][j-2] : 0;
				
				table[i][j] = Math.max(arr[i] + Math.min(x,y), arr[j] + Math.min(y,z));
			}
		}
		return table[0][n-1];
	}
}

/* 
 * Problem: Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
Note: The opponent is as clever as the user.
There are two choices:
1. The user chooses the ith coin with value Vi: The opponent either chooses (i+1)th coin or jth coin. The opponent intends to choose the coin which leaves the user with minimum value.
i.e. The user can collect the value Vi + min(F(i+2, j), F(i+1, j-1) )
The user chooses the jth coin with value Vj: The opponent either chooses ith coin or (j-1)th coin. The opponent intends to choose the coin which leaves the user with minimum value.
i.e. The user can collect the value Vj + min(F(i+1, j-1), F(i, j-2) )
F(i, j)  represents the maximum value the user can collect from 
         i'th coin to j'th coin.

    F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), 
                   Vj + min(F(i+1, j-1), F(i, j-2) )) 
Base Cases
    F(i, j)  = Vi           If j == i
    F(i, j)  = max(Vi, Vj)  If j == i+1
*/
