package Collection;

//maximum sum contagious array

public class largestSumSubarray {
	 public static void main (String[] args)
	    {
	        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	        System.out.println("Maximum contiguous sum is " +
	                                       maxSubArraySum(a));
	    }
	 
	    static int maxSubArraySum(int a[])
	    {
	        int size = a.length;
	        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
	 //max_ending_here stores current sum
	 //max_so_far is the max sum
	        for (int i = 0; i < size; i++)
	        {
	            max_ending_here = max_ending_here + a[i];
	            if (max_so_far < max_ending_here)
	                max_so_far = max_ending_here;
	            if (max_ending_here < 0)
	                max_ending_here = 0;
	        }
	        return max_so_far;
	    }
	    
	    /* Leetcode
	     
	     public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int max_so_far = nums[0];
        int max_ending_here = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(max_ending_here+nums[i], nums[i]);
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }*/
}
