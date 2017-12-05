package String;
/* Leetcode: https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */

public class firstUniqChar {
	  public int firstUniqCharacter(String s) {
	        int[] count = new int[26];
	        for(int i = 0; i < s.length(); i++) {
	            count[s.charAt(i)-'a']++;            
	        }
	        for(int i = 0; i < s.length(); i++) {
	            if(count[s.charAt(i)-'a'] == 1)
	                return i;
	        }
	        return -1;        
	    }

}
