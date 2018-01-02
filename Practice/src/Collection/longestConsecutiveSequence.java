package Collection;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/longest-consecutive-sequence/discuss/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
 */

public class longestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) 
            return 0;
        
        Set<Integer> s = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int n: nums)
            s.add(n);
        
        for(int n: nums) {
            if(s.remove(n)) {
                int sum = 1;
                int val = n;
                while(s.remove(val - 1))
                    val--;
                sum += n - val;
                
                val = n;
                while(s.remove(val + 1))
                    val++;
                sum += val - n;
                
                max = Math.max(max, sum);             
            }
        }
        return max;
    }

}
