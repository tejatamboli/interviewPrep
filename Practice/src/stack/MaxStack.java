package stack;

import java.util.*;

/* Leetcode Try for running it on leetcode platform */

public class MaxStack {

	    private Stack<Integer> stk;
	    private Stack<Integer> minStk;
	    
	    /** initialize your data structure here. */
	    public MaxStack() {
	        stk = new Stack<Integer>();
	        minStk = new Stack<Integer>();     
	    }
	    
	    public void push(int x) {
	        if(minStk.isEmpty() || x>=minStk.peek())
	                minStk.push(x);
	        stk.push(x);        
	    }
	    
	    public int pop() {
	    		if(stk.isEmpty() || minStk.isEmpty())
	    			return 0;
	        int opt = stk.pop();
	        if(opt == minStk.peek())
	            minStk.pop();
	        return opt;    
	    }
	    
	    public int top() {
	    		if(stk.isEmpty())
	    			return 0;
	        return stk.peek();
	    }
	    
	    public int peekMax() {
	    		if(minStk.isEmpty())
	    			return 0;
	        return minStk.peek();
	        
	    }
	    
	    public int popMax() {
	    		if(minStk.isEmpty())
	    			return 0;
	        int opt = minStk.pop();
	        Stack<Integer>tmp = new Stack<>();
	        while(!stk.isEmpty()) {
	            int x = stk.pop();
	            if(x != opt) {
	                tmp.push(x);
	            } else if(x == opt)
	                break;
	        }
	        while(!tmp.isEmpty()) {
	            stk.push(tmp.pop());
	        }
	        return opt;
	    }
	    
	    public static void main(String[] args) {
	    		MaxStack m = new MaxStack();
	    		m.push(74);
	    		System.out.println("popMax: " + m.popMax());
	    		m.push(89);
	    		m.push(67);
	    		System.out.println("popMax: " + m.popMax());
	    		System.out.println("pop: " + m.pop());
	    		m.push(61);
	    		m.push(-77);
	    		System.out.println("peekMax: " + m.peekMax());
	    		System.out.println("popMax: " + m.popMax());
	    		m.push(81);
	    		System.out.println("pop: " + m.pop());
	    		m.push(-71);
	    		m.push(32);
	    }
	}


