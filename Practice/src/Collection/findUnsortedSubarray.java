package Collection;

/* Leetcode: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 */

public class findUnsortedSubarray {
	
	    public int findUnsortedSubarray1(int[] nums) {
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        int i = -1, j = -1;
	        
	        for(int l = 0, r = nums.length-1; r >= 0; l++, r--) {
	            max = Math.max(max, nums[l]);
	            if(max != nums[l])
	                i = l;
	            min = Math.min(min, nums[r]);
	            if(min != nums[r])
	                j = r;
	        }
	        if(i == -1 && j == -1)
	            return 0;
	        return i-j+1;
	    }       
}
