package HashMap;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/task-scheduler/description/
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 *  represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each 
 *  interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that 
CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */

public class classScheduler {
	
	    public int leastInterval(char[] tasks, int n) {
	        Map<Character, Integer>map = new HashMap<>();
	        for(int i = 0; i < tasks.length; i++) {
	            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
	        }
	        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); //maxq
	        q.addAll(map.entrySet());
	        
	        int count = 0;
	        while(!q.isEmpty()) {
	            int k = n + 1;
	            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
	            while(k > 0 && !q.isEmpty()) {
	                Map.Entry<Character, Integer> top = q.poll();
	                top.setValue(top.getValue()-1);
	                tempList.add(top);
	                k--;
	                count++;
	            }
	            for (Map.Entry<Character, Integer> e : tempList) {
	                //System.out.println("remaining key-val" + e.getKey() + "-" + e.getValue());
	                 if(e.getValue() > 0)
	                     q.add(e);
	            }
	            if(q.isEmpty())
	                break;
	            //System.out.println("count before: " + count);
	            count += k;
	            //System.out.println("count after: " + count);
	        }
	        return count;
	    }
}
