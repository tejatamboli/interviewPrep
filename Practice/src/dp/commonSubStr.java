package dp;

import java.util.*;

//Find the Longest common substring between two list of arrays
//pinterest

public class commonSubStr {
	
	public static void main(String[] args) {
		List<String> user0 = Arrays.asList(
			       "/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html" );
		List<String> user1 = Arrays.asList(
			        "/one.html", "/two.html", "/three.html", "/four.html", "/six.html");
		List<String> user2 = Arrays.asList(
			        "/nine.html", "/two.html", "/three.html", "/four.html", "/six.html",
			       "/seven.html");
		List<String> user3 = Arrays.asList("/three.html", "/eight.html");
		
		List<String> l1 = getCommonSubStr(user1, user3);
	    System.out.println(l1);
	    List<String> l2 = getCommonSubStr(user0, user2);
	    System.out.println(l2);
	    
	}
	
	public static List<String> getCommonSubStr(List<String>u1, List<String>u2) {
	    int cnt = 0;
	    int max = Integer.MIN_VALUE;
	    int start_index = 0;
	    List<String> res = new ArrayList<String>();
	    
	    int[][] dp = new int[u1.size()+1][u2.size()+1];
	    
	    for(int i = 0; i <= u1.size(); i++) {
	      for(int j = 0; j <= u2.size(); j++) {
	        if(i == 0 || j == 0)
	          dp[i][j] = 0;
	        else if(u1.get(i-1).compareTo(u2.get(j-1)) == 0) {
	          System.out.println("u1: " + u1.get(i-1) + " u2: " + u2.get(j-1));
	          dp[i][j] = dp[i - 1][j - 1] + 1;
	          if(dp[i][j] > max) {
	            max = dp[i][j];
	            System.out.println("dp " + i + " " + j + " " + dp[i][j] + " " + max);
	            start_index = i; 
	          }
	        } else {
	          dp[i][j] = 0;
	        }     
	      }
	    }
	    System.out.println("max: " + max + " start: " + start_index) ;
	    cnt = 0;
	    for(int k = start_index-1; k >= 0 && cnt < max; k--) {
	      System.out.println("" + u1.get(k));
	      res.add(0, u1.get(k));
	      cnt++;    
	    }  
	    return res; 
	  }
}


/* basic LCS
static int LCSubStr(char X[], char Y[], int m, int n) 
{
    // Create a table to store lengths of longest common suffixes of
    // substrings. Note that LCSuff[i][j] contains length of longest
    // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
    // first column entries have no logical meaning, they are used only
    // for simplicity of program
    int LCStuff[][] = new int[m + 1][n + 1];
    int result = 0;  // To store length of the longest common substring
     
    // Following steps build LCSuff[m+1][n+1] in bottom up fashion
    for (int i = 0; i <= m; i++) 
    {
        for (int j = 0; j <= n; j++) 
        {
            if (i == 0 || j == 0)
                LCStuff[i][j] = 0;
            else if (X[i - 1] == Y[j - 1])
            {
                LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                result = Integer.max(result, LCStuff[i][j]);
            } 
            else
                LCStuff[i][j] = 0;
        }
    }
    return result;
}

*/