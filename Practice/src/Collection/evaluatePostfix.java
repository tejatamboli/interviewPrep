package Collection;

import java.util.*;
public class evaluatePostfix {
	public static void main(String[] args) {
		System.out.println("ans of expr is : " + evaluate("926*+9-"));
	}
	
	public static int evaluate(String expr) {
		char[] token = expr.toCharArray();
		Stack<Integer> values = new Stack<>();
		
		for(int i = 0; i < token.length; i++) {
			if (token[i] == ' ')
				continue;
			if (token[i] >= '0' && token[i] <= '9') {
				values.push(Integer.parseInt("" + token[i]));
			}
			if (isOperator(token[i])) {
				if (values.size() >= 2) {
					int op1 = values.pop();
					int op2 = values.pop();
					int ans = calculate(op1, op2, token[i]);
					values.push(ans);
				}
			}
		}
		if(values.size() != 1) {
			System.out.println("Error in the system");
			return -1;
		} else
			return values.pop();
	}
	
	public static boolean isOperator(char op) {
		if ((op == '+') || (op == '-') || 
			(op == '*') || (op == '/')) {
			return true;
		}
		return false;
	}
	
	public static int calculate(int op1, int op2, char op) {
		int ans = 0;
		switch(op) {
			case '+': ans = op2 + op1;
					  break;
			case '-': ans = op2 - op1;
					  break;
			case '*': ans = op2 * op1;
					  break;
			case '/': if (op1 == 0)
                		  throw new UnsupportedOperationException("Cannot divide by zero"); 
					  ans = op2 / op1;
					  break;
		}
		return ans;
	}
}
