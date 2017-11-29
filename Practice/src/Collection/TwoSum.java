package Collection;

import java.util.*;

interface TwoSumInterface {
	public void store(int value);
	public boolean test(int value);
}
public class TwoSum implements TwoSumInterface {
	private Set<Integer> localStore = new HashSet<>();
	public Integer[] arr = new Integer[] {2, 5, 3, 6, 4};
	
	public void store(int val) {
		localStore.add(val);
		
	}	
/* 
 * In this test I am storing target-num into hashset
 * if we need to store the numbers into hashset then use following implementation 
 * Please clear it 
 */	
	public boolean test(int target) {
		for(int num: arr) {
			if (localStore.contains(target-num)) {
				System.out.println(num + " : " + (target-num));
				return true;				
			} else {
				store(num);
			}
		}
		return false;
	}
/* 
 * Assume numbers are in hashset 
 */
	public boolean test1(int target) {
		for(int num: localStore) {
			if (localStore.contains(target-num)) {
				System.out.println(num + " : " + (target-num));
				return true;				
			} 
		}
		return false;
	}
}

/* Leetcode
class Solution {
public int[] twoSum(int[] nums, int target) {
    int[] a = new int[2];
    Map<Integer, Integer> s = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
        if (s.containsKey(target-nums[i])) {
            a[0] = s.get(target-nums[i]);
            a[1] = i;
            return a;
        } else {
            s.put(nums[i], i);
        }
    }
    return a;     
}
}
*/

/* Leetcode 
 * 
 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

 https://leetcode.com/problems/two-sum-iii-data-structure-design/description/

class TwoSum {
Map<Integer, Integer> m;

// Initialize your data structure here. 
public TwoSum() {
    m = new HashMap<Integer, Integer>();    
}

// Add the number to an internal data structure.. 
public void add(int number) {
    if(m.containsKey(number))
        m.put(number, m.get(number)+1);
    else
        m.put(number, 1);
}

//Find if there exists any pair of numbers which sum is equal to the value. 
public boolean find(int value) {
    
    Iterator<Integer> it = m.keySet().iterator();
    while(it.hasNext()) {
        int num = it.next();
        int two = value-num;
        if(num != two && m.containsKey(two))
            return true;
        if(num == two && m.containsKey(two) && m.get(two) >= 2)
            return true;
    }
    return false;
    
}
}*/