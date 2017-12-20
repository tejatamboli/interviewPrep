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

/* Leetcode: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
 */
/*
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            int val = 0;
            if(map.containsKey(nums1[i]))
                val = map.get(nums1[i]);
            map.put(nums1[i], val+1);
        }
        List<Integer> res = new LinkedList<>();
        for(int j = 0; j < nums2.length; j++) {
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                res.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j])-1);
            }
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            r[i] = res.get(i);
        return r;
    }
}
*/