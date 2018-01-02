package queue;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/course-schedule/discuss/58516
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and
 to take course 0 you should also have finished course 1. So it is impossible.
 */

public class courseSchedule {
	public boolean canFinish(int numCourses, int[][] courses) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < courses.length; i++) {       //courst at 0 is ready course and at 1 is prerequisite so use 1
            indegree[courses[i][1]]++;
            System.out.println("courses at: " + i + ", 1 : " +  courses[i][1] + " indegeee: " + indegree[courses[i][1]]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                System.out.println("add: " + i);
                q.offer(i);
            }
        }
        
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int x = q.poll();
            System.out.println("Looking for: " + x);
            for(int i = 0; i < courses.length; i++) {
                if(courses[i][0] == x) {
                    indegree[courses[i][1]]--;
                    if(indegree[courses[i][1]] == 0)
                        q.offer(courses[i][1]);
                }
            }
        }
        System.out.println("cnt: " + cnt);
        return cnt == numCourses;       
    }
}

/* Leetcode: https://leetcode.com/problems/course-schedule-ii/discuss/
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is 
expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to 
finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, 
return an empty array.
For example: 2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 
 * class Solution {
    public int[] findOrder(int numCourses, int[][] courses) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        
        for(int i = 0; i < courses.length; i++) {       //courst at 0 is ready course and at 1 is prerequisite so use 1
            indegree[courses[i][1]]++;
            System.out.println("courses at: " + i + ", 1 : " +  courses[i][1] + " indegeee: " + indegree[courses[i][1]]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                System.out.println("add: " + i);
                q.offer(i);
            }
        }
        
        int cnt = numCourses;
        while(!q.isEmpty()) {
            
            int x = q.poll();
            order[--cnt] = x;
            System.out.println("Looking for: " + x);
            for(int i = 0; i < courses.length; i++) {
                if(courses[i][0] == x) {
                    indegree[courses[i][1]]--;
                    if(indegree[courses[i][1]] == 0)
                        q.offer(courses[i][1]);
                }
            }
        }
        System.out.println("cnt: " + cnt);
        return (cnt == 0) ? order : new int[0];
    }
}
*/
