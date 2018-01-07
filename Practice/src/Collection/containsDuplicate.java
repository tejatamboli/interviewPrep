package Collection;
import java.util.*;

/*Leetcode: https://leetcode.com/problems/contains-duplicate/discuss/
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, and it should 
 * return false if every element is distinct.
 */

public class containsDuplicate {
	//O(N) + O(N) time and space
	    public boolean containsDuplicateI(int[] nums) {
	        Set<Integer>s = new HashSet<>();
	        for(int i = 0; i < nums.length; i++) {
	            if(!s.add(nums[i]))
	                return true;
	        }
	        return false;
	    }
	    
	//Time O(NlogN) space 1;
	    public boolean containsDuplicateII(int[] nums) {
	        Arrays.sort(nums);
	        for(int i = 0; i < nums.length-1; i++) {
	            if(nums[i] == nums[i+1])
	                return true;
	        }
	        return false;
	    }
}
