package String;

/* Leetcode: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every 
 * character in T appears no less than k times.
Example 1:
Input:
s = "aaabb", k = 3 Output: 3
The longest substring is "aaa", as 'a' is repeated 3 times.
 */

public class longestSubString1 {
	    public int longestSubstring(String s, int k) {
	        int d = 0;
	        for(int i = 1; i <= 26; i++) {
	            d = Math.max(d, getLongest(s, k, i));
	        }
	        return d;
	    }
	    
	    public int getLongest(String s, int k, int targetUnique) {
	        int end = 0;
	        int begin = 0;
	        int d = 0;
	        int[] map = new int[128];
	        int numUniq = 0; 
	        int repeatedKtimes = 0;
	        
	        while(end < s.length()) {
	            if(map[s.charAt(end)]++ == 0) // increment map[c] after this statement
	                numUniq++;
	            if(map[s.charAt(end)] == k) // inc end after this statement
	                repeatedKtimes++;
	            end++;
	            
	            while(numUniq > targetUnique) {
	                if(map[s.charAt(begin)]-- == k) // decrement map[c] after this statement
	                    repeatedKtimes--;
	                if(map[s.charAt(begin)] == 0) // inc begin after this statement
	                    numUniq--;
	                begin++;
	            }
	            // if we found a string where the number of unique chars equals our target
	           // and all those chars are repeated at least K times then update max
	            if(numUniq == targetUnique && repeatedKtimes == numUniq)
	                d = Math.max(end-begin, d);
	        }
	        return d;
	    }
}
