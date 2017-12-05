package String;
/* Leetcode: https://leetcode.com/problems/reverse-string/description/
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh"
 */

public class reverseStr {
	
	    public String reverseString(String s) {
	        char[] arr = s.toCharArray();
	        int st = 0; int e = s.length()-1;
	        while(st < e) {
	            char t = arr[st];
	            arr[st] = arr[e];
	            arr[e] = t;
	            st++; e--;
	        }
	        return new String(arr);     
	    }
	

}
