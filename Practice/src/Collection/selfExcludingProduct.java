package Collection;

import java.util.*;

public class selfExcludingProduct {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		/*l1.add(3);
		l1.add(1);
		l1.add(4);
		l1.add(2);*/
		/*l1.add(3);
		l1.add(0);
		l1.add(4);
		l1.add(1);*/
		l1.add(1);
		l1.add(2);
		l1.add(0);
		l1.add(3);
		l1.add(0);
		makeProduct(l1);
	}

	public static void makeProduct(List<Integer> l1) {
	    int prod = 1;
	    int zeroes = 0;
	    int[] opt = new int[l1.size()];
	    
		for(int i = 0; i < l1.size(); i++) {
			if(l1.get(i) != 0)
				prod = prod * l1.get(i);
			else {
				zeroes++;
				if(zeroes >= 2) {
					prod = 0;
					break;
				}
			}	
		}
		for(int i = 0; i < l1.size(); i++) {
			if(l1.get(i) != 0) {
				if(zeroes == 0)
					opt[i] = prod / l1.get(i);
				else if(zeroes == 1)
					opt[i] = 0;
			} else
				opt[i] = prod;
		}
		System.out.println();
		for(int i = 0; i < opt.length; i++) {
			System.out.print(" " + opt[i]);
		}
	}
}

/* Leetcode

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] prod = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            prod[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            prod[i] = prod[i] * temp;
            temp = temp * nums[i];
        }
        return prod;
    }
}
*/
