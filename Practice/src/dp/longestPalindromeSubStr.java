package dp;

/*
 * For a given array find the maximum size palindrome subset. The subset may be not continues.
 * For input 1, 2, 4, 5, 1 the answer is 3, the subset is 1,2,1
 */
public class longestPalindromeSubStr {
	
	public static void main(String[] args) {
		String str = "forgeeksskeegfor"; 
		getPalSubstr(str);
	}
	
	public static void getPalSubstr(String str) {
		int n = str.length();
		boolean[][] table = new boolean[n][n];
		
		int start = 0; 
		int maxLength = 0;
		
		for(int i = 0; i < n; i++)
			table[i][i] = true;
		
		for(int i = 0; i < n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				maxLength = 2;
				start = i;
				table[i][i+1] = true;
			}
		}
		
		for(int k = 3; k <= n; k++) {
			for(int i = 0; i < n-k+1; i++) {
				int j = i + k - 1;
				if((table[i+1][j-1] == true) && (str.charAt(i) == str.charAt(j))) {
					table[i][j] = true;
					if(k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.println("Longest length is : " + maxLength);
		System.out.println("Longest string is : " + str.substring(start, start+maxLength));
	}
}
