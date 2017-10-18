package stack;

import java.util.*;

/*
 * See if you can find the solution without extra space
 */

public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> s1 = new Stack<>();
	
	public NestedIterator(List<NestedInteger> l1) {
		for(int i = l1.size()-1; i>= 0; i--) 
			s1.push(l1.get(i));
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while(!s1.isEmpty()) {
			NestedInteger curr = s1.peek();
			if(curr.isInteger())
				return true;
			s1.pop();
			for(int i = curr.getList().size()-1; i >= 0; i--)
				s1.push(curr.getList().get(i));
		}
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return s1.pop().getInteger();
	}

}
