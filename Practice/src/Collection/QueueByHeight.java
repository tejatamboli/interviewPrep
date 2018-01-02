package Collection;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/queue-reconstruction-by-height/description/
 * 
 * Suppose you have a random list of people standing in a queue. Each person is described 
 * by a pair of integers (h, k), where h is the height of the person and k is the number of 
 * people in front of this person who have a height greater than or equal to h. Write an 
 * algorithm to reconstruct the queue.
Note:
The number of people is less than 1,100.
 */

public class QueueByHeight {
	    public int[][] reconstructQueue(int[][] people) {
	        //pick up the tallest guy first
	        //when insert the next tall guy, just need to insert him into kth position
	        //repeat until all people are inserted into list
	        Arrays.sort(people,new Comparator<int[]>(){
	           @Override
	           public int compare(int[] o1, int[] o2){
	               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
	           }
	        });
	        List<int[]> res = new LinkedList<>();
	        for(int[] cur : people){
	            System.out.println("0: " + cur[1] + " cur: " + cur[0] + "-" + cur[1]);
	            res.add(cur[1],cur);      
	            //cur[1] is the index at which store the cur array 
	        }
	        return res.toArray(new int[people.length][]);
	    }
}
