package stack;

import java.util.*;

public class depthTree {
	public static void main(String[] args) {
		String s = "((00))";
		System.out.println(getLength3(s));
	}
	//Time: O(n * depth)
	//Space: O(n)
	public static int getLength(String str) {
	    int depth = -1;
	    while (!str.equals("0")) {
	        String newStr = str.replace("(00)", "0");
	        System.out.println("newStr: " + newStr);
	        if (newStr.equals(str)) {
	            return -1;
	        }
	        str = newStr;
	        ++depth;
	    }
	    return depth;
	}
	
	public static int getLength2(String str) {
		int depth = -1;
		
	    char[] pattern = {'(', '0', '0', ')'};
	    char[] strArr = str.toCharArray();
	    boolean setErr = false;
	    int j = 0;
	    int len = strArr.length;
	while(len != 1) {
		if(len < 4)
			return -1;
		int i = 0;
		int s = 0;
	    char[] newStr = new char[len];
	    int n_i = 0;
	    
	    while(i < len) {
	    		s = i; j = 0;
	    		System.out.println(i + " " + j + " " + s + String.valueOf(strArr) + String.valueOf(newStr) + setErr);
	    		while(j < 4) {
	    			if(strArr[s] == pattern[j]) {
	    				s++; j++;
	    			} else {
	    				break;
	    			}
	    		}
	    		System.out.println(":" + i + " " + j + " " + s + String.valueOf(strArr) + String.valueOf(newStr) + setErr);
	    		if (j == 4) {
	    			newStr[n_i++] = '0';
	    			i = i + 4;
	    		} else {
	    			while(i < s) {
	    				if(strArr[i] != '(' && strArr[i] != ')' && strArr[i] != '0') {
	    					System.out.println(i + j + s + String.valueOf(strArr) + String.valueOf(newStr) + setErr);
	    					setErr = true;
	    					return -1;
	    				}
	    				newStr[n_i++] = strArr[i++];
	    			}
	    		}
	    		if(i+4 > len) {
	    			while(i < len) {
	    				if(strArr[i] != '(' && strArr[i] != ')' && strArr[i] != '0') {
	    					setErr = true;
	    					return -1;
	    				}
	    				
	    				newStr[n_i++] = strArr[i++];
	    			}
	    		}
	    }
	    strArr = newStr.clone();
	    len = n_i;
	    if(setErr)
	    		return -1;
	    
	    System.out.println("opt1: " + String.valueOf(strArr));
	    depth++;
	}
	return (depth);
	}

	public static int getLength3(String str) {
		if (str == null)
			return -1;
		if(str.length() < 4)
			return -1;
		if((str.charAt(0) != '(') || (str.charAt(str.length()-1) != ')'))
			return -1;
		int depth = -1;
		int zeroCnt = 0;
		Stack<Character>s1 = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				s1.push(c);
				if(s1.size() > depth)
					depth = s1.size();
				zeroCnt = 0;
			}
			else if(c == ')') {
				zeroCnt = 0;
				s1.pop();
			} else {
				if(c != '0')
					return -1;
				else {
					zeroCnt++;
					if(zeroCnt > 2)
						return -1;
				}
			}
		}
		if(s1.size() != 0)
			return -1;
		
		return depth;
	}
	
}
 