package Collection;

import java.util.*;

//Intersection of two sorted integer arrays

public class intersection {
	
	public static void main(String[] args) {
		
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
