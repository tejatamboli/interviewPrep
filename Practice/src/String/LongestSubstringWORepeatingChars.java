package String;

/* 
 * Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

//Did not understand it much

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
