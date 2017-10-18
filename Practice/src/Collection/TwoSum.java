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
			if (localStore.contains(num)) {
				System.out.println(num + " : " + (target-num));
				//return true;				
			} else {
				store(target-num);
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