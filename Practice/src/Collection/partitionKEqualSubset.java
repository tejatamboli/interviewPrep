package Collection;

import java.util.*;

/*
 * Leetcode: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

 */

public class partitionKEqualSubset {
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			sum += nums[i];
		if(sum % k > 0)
			return false;
		sum = sum / k;
    
		Arrays.sort(nums);
    
		int row = nums.length - 1;
		if(nums[row] > sum)
			return false;
		while(nums[row] == sum) {
			row--;
			k--;
		}
		return partition(new int[k], sum, nums, row);
	}

	public static boolean partition(int[] groups, int sum, int[] nums, int index) {
		if(index < 0)
			return true;
		int n = nums[index--];
		for(int i = 0; i < groups.length; i++) {
			if(groups[i] + n <= sum) {
				groups[i] = groups[i] + n;
				if(partition(groups, sum, nums, index))
					return true;
				groups[i] = groups[i] - n; 
			}
			if(groups[i] == 0)
				break;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,2,3,5,2,1};
		int k = 4;
		System.out.println("Partition: " + canPartitionKSubsets(arr, k));
	}
}
