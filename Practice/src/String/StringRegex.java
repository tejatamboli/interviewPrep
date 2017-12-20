package String;

public class StringRegex {
	
	public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int startIndex = -1;
        int iIndex = -1;
        
        while(i < s.length()) {
            if(j < p.length() && ((p.charAt(j) == '?') || (s.charAt(i) == p.charAt(j)))) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                startIndex = j;
                iIndex = i;
                j++;
            } else if(startIndex != -1) {
                j = startIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else
                return false;
        }
        while (j < p.length() && p.charAt(j) == '*') {
		    ++j;
	    }
 
	    return j == p.length();
    }
	
	public static void main(String[] args) {
		String s1 = "aabcd"; 
		String s2 = "*b*d";
		System.out.println(s1 + " " + s2 + " are matching?: " + isMatch(s1, s2));
	}

}

/*
 * bool match(char *first, char * second)
{
    // If we reach at the end of both strings, we are done
    if (*first == '\0' && *second == '\0')
        return true;
 
    // Make sure that the characters after '*' are present
    // in second string. This function assumes that the first
    // string will not contain two consecutive '*'
    if (*first == '*' && *(first+1) != '\0' && *second == '\0')
        return false;
 
    // If the first string contains '?', or current characters
    // of both strings match
    if (*first == '?' || *first == *second)
        return match(first+1, second+1);
 
    // If there is *, then there are two possibilities
    // a) We consider current character of second string
    // b) We ignore current character of second string.
    if (*first == '*')
        return match(first+1, second) || match(first, second+1);
    return false;
}
 */


/* Leetcode
 * https://leetcode.com/problems/regular-expression-matching/description/
 * 
 * '.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

 * 
 * public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
*/