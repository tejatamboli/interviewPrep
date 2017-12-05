package Collection;

/* Leetcode: https://leetcode.com/problems/rotate-array/discuss/
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */

public class rotateArray {
	    public void rotate(int[] nums, int k) {
	        k = k % nums.length;
	        reverse(nums, 0, nums.length-1);
	        reverse(nums, 0, k-1);
	        reverse(nums, k, nums.length-1);        
	    }
	    
	    public void reverse(int[] nums, int s, int e) {
	        while(s < e) {
	            int t = nums[s];
	            nums[s] = nums[e];
	            nums[e] = t;
	            s++; e--;
	        }
	    }
}
