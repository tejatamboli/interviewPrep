package dp;

/* Leetcode: https://leetcode.com/problems/climbing-stairs/description/
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

m = 2;
 */
public class countWaysClimbStair {
	public static void main(String[] args) {
		int m = 2;
		int n = 4;
		System.out.println("Ways: " + getWays(n+1, m));
	}
	
	public static int getWays(int n, int m) {
		int[] table = new int[n];
		table[0] = 1; //Not sure why this is 1.
		table[1] = 1;
		for(int i = 2; i < n; i++) {
			table[i] = 0;
			for(int j = 1; j <= m && j <=i; j++) {
				table[i] += table[i-j];
			}
		}
		return table[n-1];
		
	}
}
/*0
1
i = 2 j = 1, 2
1+1 = 1
*/