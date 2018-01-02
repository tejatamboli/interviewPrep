package backtrack;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/palindrome-partitioning/discuss/
 * For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
 */

public class palindromePartiton {
	    public List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        List<String> cur = new ArrayList<String>();
	        partitionUtil(res, cur, 0, s.length(), s);
	        return res;
	    }
	    
	    public void partitionUtil(List<List<String>>res, List<String>cur, int l, int h, String s) {
	        if(l >= h) {
	            res.add(new ArrayList<>(cur)); 
	            return;
	        }
	        for(int i = l; i < h; i++) {
	            if(isPalindrome(s, l, i)) {
	                cur.add(s.substring(l, i+1));
	                partitionUtil(res, cur, i+1, h, s);
	                cur.remove(cur.size()-1);
	            }
	        }
	    }
	    
	    public boolean isPalindrome(String s, int l, int h) {
	        while(l < h) {
	            if(s.charAt(l) != s.charAt(h)) 
	                return false;
	            l++; h--;
	        }
	        return true;
	    }
}
