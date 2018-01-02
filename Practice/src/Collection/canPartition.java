package Collection;

/* Leetcode: https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Given a non-empty array containing only positive integers, find if the array can be 
 * partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

Since the problem is a 0-1 backpack problem, we only have two choices which are take or not. 
Thus in this problem, by using the sum value as the index of DP array, we transfer the problem 
to “whether should we take the currently visited number into the sum or not”.
To construct the DP recurrence, when we are visiting nums[i] and to find partition of sum j: 
if we do not take the nums[i], then the current iteration does not make any difference on 
current DP value; if we take the nums[i], then we need to find whether the 
(new_sum = j - nums[i]) can be constructed. If any of this two construction can work, 
the partition of sum == j can be reached.
 */

public class canPartition {
	    public boolean canPartitionI(int[] nums) {
	        if(nums == null || nums.length == 0)
	            return true;
	        int sum = 0;
	        for(int n: nums)
	            sum += n;
	        if(sum % 2 != 0)
	            return false;
	        sum = sum / 2;
	        boolean[] dp = new boolean[sum+1];
	        dp[0] = true;
	        
	        for(int i = 0; i < nums.length; i++) {
	            for(int j = sum; j >= nums[i]; j--) {
	                dp[j] = dp[j] || dp[j-nums[i]];
	            }
	        }
	        return dp[sum];     
	    }
}
