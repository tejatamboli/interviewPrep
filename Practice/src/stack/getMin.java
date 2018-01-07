package stack;

import java.util.Stack;

public class getMin extends Stack<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //added to resolve warning
	Stack<Integer>min = new Stack<>();
	
	void push(int x) {
		if(isEmpty() == true) {
			super.push(x);
			min.push(x);
		} else {
			super.push(x);
			int y = min.peek();
			if(x < y)
				min.push(x);
		}
	}
	
	public Integer pop() {
		int x = super.pop();
		int y = min.peek();
		if(x==y)
			min.pop();
		return x;
	}
	
	int getMinimum() {
		int x = min.peek();
		System.out.println("Size: " + min.size());
		return x;
	}
	
	public static void main(String[] args) 
    {
        getMin s = new getMin();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMinimum());
        s.push(5);
        System.out.println(s.getMinimum());
    }
}
