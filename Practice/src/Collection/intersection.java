package Collection;

import java.util.*;

public class intersection {
	
	public static void main(String[] args) {
		/*Set<Integer> a = new HashSet<>();
		a.add(1);a.add(1);a.add(5);a.add(6);a.add(7);a.add(8);a.add(9);
		Set<Integer> b = new HashSet<>();
		b.add(1);b.add(1);b.add(5);b.add(5);b.add(17);b.add(81);b.add(88);b.add(99);*/
		int[]a = {1,1,5,6,7,8,9};
		int[]b = {1,1,5,5,17,81,88,99};
		List<Integer> l1 = intersection(a, b);
		for(Integer c: l1) {
			System.out.print(" " + c);
		}
	}
	
	public static List<Integer> intersection(int[]c, int[]d) {
		List<Integer> intersection = new ArrayList<>();
		int i = 0; int j = 0;
		//Object[]c = a.toArray();
		//Object[]d = b.toArray();
		while(i < c.length && j < d.length) { 
			if(c[i] < d[j])
				i++;
			else if(c[i] > d[j])
				j++;
			else {
				intersection.add(c[i]);
				i++; j++;
			}
		}
		return intersection;
	}
}
