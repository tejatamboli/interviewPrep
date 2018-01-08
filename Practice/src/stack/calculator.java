package stack;

/*
 * Leetcode: https://leetcode.com/problems/basic-calculator-ii/description/
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
 */
import java.util.*;

public class calculator {
	
	    public int calculate(String s) {
	        s = s.trim();
	        if(s==null || (s.length())==0) 
	            return 0;
	        Stack<Integer>st = new Stack<>();
	        char sign = '+';
	        int i = 0;
	        int num = 0;
	        while(i < s.length()) {
	            while(i < s.length() && Character.isDigit(s.charAt(i))) {
	                num = num*10 + (s.charAt(i) - '0');
	                i++;
	            }
	            if(i < s.length() && s.charAt(i) == ' ')
	                i++;
	            else if( i == s.length()-1 || !Character.isDigit(s.charAt(i))) {
	                if(sign == '+') 
	                    st.push(num);
	                else if(sign == '-')
	                    st.push(-num);
	                else if(sign == '*')
	                    st.push(st.pop() * num);
	                else if(sign == '/')
	                    st.push(st.pop() / num);
	                if(i < s.length()) {
	                    sign = s.charAt(i);
	                    i++;  
	                    num = 0;
	                }
	            } 
	        }
	        int res = 0;
	        for(int v:st) {
	            System.out.println("v: " + v);
	            res += v;
	        }
	        return res;
	        
	    }
}
