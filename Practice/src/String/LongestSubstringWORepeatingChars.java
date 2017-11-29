package String;

/* 
 * Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

public class LongestSubstringWORepeatingChars {
	public int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return ans;
    }

}
