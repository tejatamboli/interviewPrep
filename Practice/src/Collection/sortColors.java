package Collection;

/* Leetcode: https://leetcode.com/problems/sort-colors/discuss/
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 */
public class sortColors {
	public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length-1;
        int i = 0;
        while(i <= p2) {
            if(nums[i] == 0) {
                nums[i] = nums[p1];
                nums[p1] = 0;
                p1++;
            } 
            if(nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2] = 2;
                p2--; i--;
            }
            i++;
        }
    }
	
/*	public void sortColors(int[] nums) {
	    // 2-pass
	    int count0 = 0, count1 = 0, count2 = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == 0) {count0++;}
	        if (nums[i] == 1) {count1++;}
	        if (nums[i] == 2) {count2++;}
	    }
	    for(int i = 0; i < nums.length; i++) {
	        if (i < count0) {nums[i] = 0;}
	        else if (i < count0 + count1) {nums[i] = 1;}
	        else {nums[i] = 2;}
	    }
	}
	*/

}
