package stack;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/longest-valid-parentheses/description/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
 * parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class longestValidParanthesis {
	    public int longestValidParentheses(String s) {
	        Stack<Integer>st = new Stack<>();
	        for(int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) == '(')
	                st.push(i);
	            else {
	                if(!st.isEmpty()) {
	                    if(s.charAt(st.peek()) == '(') //imp step
	                        st.pop();
	                    else
	                        st.push(i);
	                } else
	                    st.push(i);
	            }
	        }
	        if(st.isEmpty())
	            return s.length();
	        
	        int endIndex = s.length();
	        int longest = 0;
	        while(!st.isEmpty()) {
	            int startIndex = st.pop();
	            //System.out.println("start-end: " + startIndex + "-" + endIndex);
	            longest = Math.max(endIndex-startIndex-1, longest);
	            endIndex = startIndex;
	        }
	        longest = Math.max(longest, endIndex);
	        return longest;
	    }
}
