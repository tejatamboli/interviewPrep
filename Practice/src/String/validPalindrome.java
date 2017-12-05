package String;

/* Leetcode: https://leetcode.com/problems/valid-palindrome/discuss/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 */

public class validPalindrome {
	public boolean isPalindrome(String s) {
        int l = 0; 
        int h = s.length() - 1;
        s = s.toLowerCase();
        while(l <= h) {
            while(l < s.length() && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l)))
                l++;
            while(h >= 0 && !Character.isDigit(s.charAt(h)) && !Character.isLetter(s.charAt(h)))
                h--;
            if(l > h)
                return true;
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++; h--;
        }
        return true;
    }
}
