package Collection;

/*
 * https://leetcode.com/problems/move-zeroes/description/
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements. For example, given nums = [0, 1, 0, 3, 12], 
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 */

public class moveAllZeros {
	    public void moveZeroes(int[] nums) {
	        int index = 0;
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] == 0) {
	                continue;    
	            }
	            nums[index++] = nums[i];
	        }
	        
	        for(int i = index; i < nums.length; i++)
	            nums[i] = 0;
	    }
	

}
