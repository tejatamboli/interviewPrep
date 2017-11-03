package stack;

import java.util.*;

/*
Find if brackets are balanced properly in a given string.
*/
public class balanceBrackets {
	
	public static void main(String[] args) {
		String s = "]()[";
		System.out.println(checkBalanceString(s));
	}
	
	public static boolean match(char c1, char c2) {
		if(c1 == '(' && c2 == ')')
			return true;
		else if(c1 == '[' && c2 == ']')
			return true;
		else if(c1 == '{' && c2 == '}')
			return true;
		else
			return false;
	}
	
	public static boolean checkBalanceString(String str) {
		char[] strArr = str.toCharArray();
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(strArr[i] == '(' || strArr[i] == '{' || strArr[i] == '[') {
				s.push(strArr[i]);
			} else if(strArr[i] == ')' || strArr[i] == '}' || strArr[i] == ']') {
				if(!s.isEmpty()) {
					char ch = s.pop();
					if(!match(ch, strArr[i]))
						return false;
				} else
					return false;
			} else {
				return false;
			}
		}
		if(!s.isEmpty())
			return false;
		
		return true;
	}
}
