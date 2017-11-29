package Collection;

import java.util.*;

public class unionIntersection {
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer> (Arrays.asList(1, 4, 5, 7, 9, 12));
		List<Integer> l2 = new ArrayList<Integer> (Arrays.asList(2, 4, 6, 7, 10, 12));
		//List<int> l2 = new List<int>() { -1, 2, 6, 26, 40, 50, 75 };

		
		List<Integer> uList = union(l1, l2);
		List<Integer> iList = intersection(l1, l2);
		
		System.out.println("Union: ");
		for(Integer val: uList) {
			System.out.println(" " + val);
		}
		
		System.out.println("Intersection: ");
		for(Integer val: iList) {
			System.out.println(" " + val);
		}
	}
	
	public static List<Integer> union(List<Integer> list1, List<Integer> list2) {
		if (list1.size() == 0)
			return list2;
		if (list2.size() == 0)
			return list1;
		List<Integer> op = new ArrayList<Integer>();
		int s1 = 0, s2 = 0;
		int e1 = list1.size(), e2 = list2.size();
		while((s1 < e1) && (s2 < e2)) {
			if (list1.get(s1) < list2.get(s2)) { 
				op.add(list1.get(s1++));
			} else if(list1.get(s1) == list2.get(s2)) {
				op.add(list1.get(s1++));
				s2++;
			} else {
				op.add(list2.get(s2++));
			}
		}
		while(s1 < e1) {
			op.add(list1.get(s1++));
		}
		while(s2 < e2) {
			op.add(list2.get(s2++));
		}		
		return op;		
	}
	
	public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
		if (list1.size() == 0)
			return null;
		if (list2.size() == 0)
			return null;
		List<Integer> op = new ArrayList<Integer>();
		int s1 = 0, e1 = list1.size(); 
		int s2 = 0, e2 = list2.size();
		while(s1 < e1 && s2 < e2) {
			if(list1.get(s1) == list2.get(s2)) {
				op.add(list1.get(s1++));
				s2++;
			} else if(list1.get(s1) < list2.get(s2)) {
				s1++;
			} else {
				s2++;
			}
		}
		return op;
	}	
}
