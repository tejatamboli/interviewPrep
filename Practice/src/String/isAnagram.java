package String;

/* Leetcode: https://leetcode.com/problems/valid-anagram/description/
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 * */

public class isAnagram {
	
	    public boolean isAnagramI(String s, String t) {
	        int[] map = new int[26];
	        if(s.length() != t.length())
	            return false;
	        for(int i = 0; i < s.length(); i++) {
	            map[s.charAt(i)-'a']++;
	            map[t.charAt(i)-'a']--;
	        }
	        for(int i = 0; i < 26; i++){
	            if(map[i] != 0)
	                return false;
	        }
	        return true;      
	    }
	}
