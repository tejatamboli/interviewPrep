package String;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/decode-string/description/
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
 k. For example, there won't be input like 3a or 2[4].
 
//"3[a2[c]]", return "accaccacc".
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

public class decodeString {
	    public String decodeStringI(String s) {
	        String res = "";
	        Stack<Integer>numSt = new Stack<Integer>();
	        Stack<String>repeatSt = new Stack<String>();
	        int i = 0;
	        while(i < s.length()) {
	            if(Character.isDigit(s.charAt(i))) {
	                int count = 0;
	                while (Character.isDigit(s.charAt(i))) {
	                    count = 10 * count + (s.charAt(i) - '0');
	                    i++;
	                }
	                numSt.push(count);
	            }
	            else if(s.charAt(i) == '[') {
	                repeatSt.push(res); //"",a
	                res = "";
	                i++;
	            }
	            else if(s.charAt(i) == ']') {
	                StringBuilder temp = new StringBuilder (repeatSt.pop());
	                int k = numSt.pop();//3,2
	                while(k > 0) {
	                    temp.append(res);
	                    k--;
	                }
	                res = temp.toString();
	                i++;
	            }
	            else 
	                res += s.charAt(i++);//c
	        }
	        return res;
	    }
}
