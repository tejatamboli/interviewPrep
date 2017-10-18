package stack;

import java.util.*;

/*
Find if brackets are balanced properly in a given string.
*/
public class balanceBrackets {
	
	public static void main(String[] args) {
		String s = "(())";
		System.out.println(checkBalanceString(s));
	}
	
	public static boolean checkBalanceString(String str) {
		char[] strArr = str.toCharArray();
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(strArr[i] == '(' || strArr[i] == '{' || strArr[i] == '[') {
				s.push(strArr[i]);
			} else if(strArr[i] == ')' || strArr[i] == '}' || strArr[i] == ']') {
				if(!s.isEmpty())
					s.pop();
				else
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
