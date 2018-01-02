package Design;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

 */

public class randomizeSet {
	

	    /** Initialize your data structure here. */
	    List<Integer> nums;
	    Map<Integer, Integer>map;
	    Random rand;
	    public randomizeSet() {
	        nums = new ArrayList<Integer>();
	        map = new HashMap<Integer, Integer>();
	        rand = new Random();
	        
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val))
	            return false;
	        map.put(val, nums.size());
	        nums.add(val);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val))
	            return false;
	        int pos = map.get(val);
	        //swap pos and last element
	        if (pos < nums.size() - 1 ) {
	            int lastNum = nums.get(nums.size()-1);
	            nums.set(pos, lastNum);
	            map.put(lastNum, pos);
	        }
	        nums.remove(nums.size()-1);
	        map.remove(val);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return nums.get(rand.nextInt(nums.size()));     
	    }


}
