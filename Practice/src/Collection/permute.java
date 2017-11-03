package Collection;

import java.util.*;

public class permute {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<int[]> result = new ArrayList<>();
		l1.add(1); l1.add(2); l1.add(3);
		generate(l1, 0, l1.size()-1, result);
		for(int i = 0; i < result.size(); i++) {
			System.out.print("\n" + i + ":");
			for(int j = 0; j < result.get(i).length; j++) {
				System.out.print(" " + result.get(i)[j]);
			}
		}
	}	
	public static void generate(List<Integer> l1, int l, int r, List<int[]> result) {
		if(l == r) {
			int[] m1 = new int[r+1];
			for(int k = 0; k <=r; k++)
				m1[k] = l1.get(k);
			result.add(m1);
		} else {
			for(int i = l; i <= r; i++) {
				l1 = swap(l1, l, i);
				generate(l1, l+1, r, result);
				l1 = swap(l1, l, i); 
			}
		}
	}
	public static List<Integer> swap(List<Integer>l1, int i, int j) {
		int temp = l1.get(i);
		l1.set(i, l1.get(j));
		l1.set(j, temp);
		return l1;
	}
}


/* Leetcode 
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    getPermulations(nums, 0, nums.length-1, result);
    return result;
}
public void getPermulations(int[] nums, int l, int r, List<List<Integer>>result) {
    if(l == r) {
        List<Integer> r1 = new ArrayList<>();
        for(int i = 0; i <= r; i++)
            r1.add(nums[i]);
        result.add(r1);
    } else {
        for(int i = l; i <= r; i++) {
            swap(nums, l, i);
            getPermulations(nums, l+1, r, result);
            swap(nums, l, i);
        }
    }
}

public void swap(int[] nums, int l, int i) {
    int temp = nums[l];
    nums[l] = nums[i];
    nums[i] = temp;
}*/