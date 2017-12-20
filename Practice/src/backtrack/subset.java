

package backtrack;

import java.util.*;

/* Leetcode: Subsets : https://leetcode.com/problems/subsets/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] 
 */

public class subset {
	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(res, temp, nums, 0);
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
		res.add(new ArrayList<>(temp));
		for(int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			backtrack(res,temp,nums,i+1);
			temp.remove(temp.size()-1);
		}
	}
}

/* 
 * Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/
 
 public List<List<Integer>> subsets(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(res, temp, nums, 0);
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
		res.add(new ArrayList<>(temp));
		for(int i = start; i < nums.length; i++) {
			if(i > start && nums[i] == nums[i-1])
				continue;
			temp.add(nums[i]);
			backtrack(res,temp,nums,i+1);
			temp.remove(temp.size()-1);
		}
	}
*/
