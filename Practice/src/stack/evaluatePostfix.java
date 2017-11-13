package stack;

import java.util.*;
public class evaluatePostfix {
	public static void main(String[] args) {
		System.out.println("ans of expr is : " + evaluate("926*+9-"));
		String[] token = new String[3];
		token[0] = "0";
		token[1] = "3";
		token[2] = "/";
		
		System.out.println("ans of expr is : " + evalRPN(token));
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
	
	/* Leetcode soluton */
	public static int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++) {
            System.out.println("token: " + tokens[i]);
            if(isOperator(tokens[i]) == true) {
                System.out.println("operator " + tokens[i]);
                if(st.size() >= 2) {
                    System.out.println("size > 2");
                    int op1 = st.pop();
                    int op2 = st.pop();
                    st.push(evaluate(op1, op2, tokens[i]));
                } else
                    return -1;
            } else {
                try {  
                    int d = Integer.parseInt(tokens[i]);  
                    st.push(d);
                } catch(NumberFormatException nfe)  {  
                    return -1;  
                }  
            }
        }
        if(st.size() != 1)
            return -1;
        
        return(st.pop());
    }
    public static boolean isOperator(String op) {
        if(op.compareTo("+") == 0 || op.compareTo("-") == 0 || op.compareTo("/") == 0 || op.compareTo("*") == 0)
            return true;
        return false;
    }
    public static int evaluate(int op1, int op2, String op) {
        System.out.println("op1:" + op1 + " op2: " + op2 + " op: " + op);
        int opt = 0;
        if(op.equals("+")) {
            opt = op1 + op2;
        } else if(op.equals("-")) {
            opt = op2 - op1;
        } else if(op.equals("*")) {
            opt = op1 * op2;
        } else if(op.equals("/")) {
            opt = op2 / op1;
        } else {
            opt = -1;
        }
         
        return opt;
    }
}
