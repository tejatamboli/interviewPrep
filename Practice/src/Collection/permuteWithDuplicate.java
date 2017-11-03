package Collection;

import java.util.*;

public class permuteWithDuplicate {
	
	public static void main(String[] args) {
		int[] nums  = new int[3];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 1;
		 List<List<Integer>>l1 = permuteUnique(nums);
		 for(int i = 0; i < l1.size(); i++) {
			 System.out.println(l1.get(i));
		 }
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermulations(nums, 0, result);
        return result;
    }
    
    public static void getPermulations(int[] nums, int l, List<List<Integer>>result) {
        if(l == nums.length-1) {
            List<Integer>r1 = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) 
                r1.add(nums[i]);
            result.add(r1);
            return;
        } else {
            Set<Integer> appeared = new HashSet<>();
            for(int i = l; i < nums.length; i++) {
                if(appeared.add(nums[i])) {
                    swap(nums, l, i);
                    getPermulations(nums, l+1, result);
                    swap(nums, l, i);
                }
            }
        }
    }
    public static void swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}
