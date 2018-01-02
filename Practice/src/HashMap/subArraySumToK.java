package HashMap;
import java.util.*;
/*Leetcode: https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Given an array of integers and an integer k, you need to find the total number of 
 * continuous subarrays whose sum equals to k.
Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 */
public class subArraySumToK {
	    public int subarraySum(int[] nums, int k) {
	        Map<Integer, Integer> map = new HashMap<>();
	        int sum = 0;
	        int cnt = 0;
	        map.put(0, 1); //imp line
	        for(int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if(map.containsKey(sum-k)) {
	                cnt+= map.get(sum-k);
	            }
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        return cnt;
	    }
}

//50, 70, 52, 61, 44, 71, 