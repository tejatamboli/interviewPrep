package Collection;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/flatten-2d-vector/description/
 * Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 * 
 */

public class flatten2dList implements Iterator<Integer> {
	
	    Queue<Iterator<Integer>> q;
	    Iterator<Integer> current = null;

	    public flatten2dList(List<List<Integer>> vec2d) {
	        q = new LinkedList<Iterator<Integer>>();
	        for(int i = 0; i < vec2d.size(); i++)
	            q.add(vec2d.get(i).iterator());
	        current = q.poll();
	    }

	    @Override
	    public Integer next() {
	        if(current.hasNext())
	            return current.next();
	        return -1;
	        
	    }

	    @Override
	    public boolean hasNext() {
	        if(current == null)
	            return false;
	        while(!current.hasNext()) {
	            if(!q.isEmpty())
	                current = q.poll();
	            else
	                return false;
	        }
	        return true;       
	    }
	}


/* 
 * Easy solution
 * 
 * public class Vector2D {
    int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    public int next() {
        return vec.get(indexList).get(indexEle++);
    }

    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
 */
