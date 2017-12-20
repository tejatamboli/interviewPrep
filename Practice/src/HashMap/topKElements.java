package HashMap;
import java.util.*;

/*
 * Leetcode: https://leetcode.com/problems/top-k-frequent-elements/description/
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */

public class topKElements {
	
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int n : nums) {
	            int val = 1;
	            if(map.containsKey(n)) {
	                val = map.get(n) + 1;
	            }
	            map.put(n, val);
	        }
	        PriorityQueue<Map.Entry<Integer, Integer>> minpq = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
	        Iterator it = map.entrySet().iterator();
	        while(it.hasNext()) {
	            Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
	            minpq.offer(entry);
	            if(minpq.size() > k)
	                minpq.poll();
	        }
	        List<Integer> res = new LinkedList<>();
	        while(!minpq.isEmpty()) {
	            res.add(0, minpq.poll().getKey());
	        }
	        return res;       
	    }
}
