package stack;

import java.util.Iterator;
import java.util.List;

public class NestedIteratorWOSpace implements Iterator<Integer> {
	
	int l_index = 0;
	int nested_index = 0;
	List<NestedInteger> l;
	
	public NestedIteratorWOSpace(List<NestedInteger> l1) {
		l = l1;
		l_index = 0;
		nested_index = 0;
	}

	@Override
	public boolean hasNext() {
		if(l_index < l.size())
			return true;
		NestedInteger num = l.get(l.size()-1);
		if(!num.isInteger() && nested_index < num.getList().size())
			return true;
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		NestedInteger num = l.get(l_index);
		if(num.isInteger()) {
			l_index++;
			return (num.getInteger());
		} else {
			List<NestedInteger> l1 = num.getList();
			int num1 = -1;
			if(nested_index < l1.size()) {
				num1 = l1.get(nested_index).getInteger();
				nested_index++;
				if(nested_index >= l1.size()) {
					nested_index = 0;
					l_index++;
				}
			}
			return num1;
		}
	}
}
