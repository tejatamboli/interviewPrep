package String;

/* Leetcode :
 * https://leetcode.com/problems/implement-strstr/description/
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */

public class strStr {
	public int getstrStr(String str, String pat) {
        int i = 0, j = 0;
        if (str.length() < pat.length()) {
            return -1;
        } else if (pat.length() == 0) {
            return 0;
        }
        for(i = 0; i < str.length(); i++) {     
            for(j = 0; j < pat.length(); j++) {
                if(i+j == str.length()) {
                    return -1;
                }
                if(str.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == pat.length())
                return i;
        }
        return -1;
    }

}
