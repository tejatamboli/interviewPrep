package Collection;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * iven a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 */
		

public class removeDuplicates {
	
	    public int removeDuplicates1(int[] nums) {
	        
	        int index = 1; //Very imp to start from 1
	        if (nums == null || nums.length == 1)
	            return nums.length;
	        for(int i = 1; i < nums.length; i++) {
	            if(nums[i] != nums[i-1]) {
	                nums[index] = nums[i];
	                index++;
	            }
	        }
	        return index;     
	    }
	

}
