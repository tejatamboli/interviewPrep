package dp;
import java.util.*;
/* Leetcode: https://leetcode.com/problems/word-break/discuss/
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */

public class wordBreak {
	
	    public boolean wordBreak(String s, List<String> wordDict) {
	        boolean[] dp = new boolean[s.length()+1];
	        dp[0] = true;
	        for(int i = 1; i <= s.length(); i++) {
	            for(int j = i-1; j >= 0; j--) {
	                if(dp[j]) {
	                    String w = s.substring(j, i);
	                    if(wordDict.contains(w)) {
	                        dp[i] = true;
	                        break;
	                    }
	                }
	            }
	        }
	        return dp[s.length()];
	    }
}
