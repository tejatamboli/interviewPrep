package Collection;

import java.util.List;

//Intervals are in sorted order and insert newInterval in between

import java.util.*;

public class insertInterval {
	    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        
	        List<Interval> res = new LinkedList<>();
	        
	        int i = 0;
	        while(i < intervals.size() && intervals.get(i).end < newInterval.start)
	            res.add(intervals.get(i++)); 
	        
	        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	            int start = Math.min(intervals.get(i).start, newInterval.start);
	            int end = Math.max(intervals.get(i).end, newInterval.end);
	            newInterval = new Interval(start, end);
	            i++;
	        }
	        res.add(newInterval);
	        
	        while(i < intervals.size())
	            res.add(intervals.get(i++)); 
	        
	        return res;
	    }
	
	    public static void main(String[] args) {
	    		List<Interval> a = new LinkedList<>();
	    		a.add(new Interval(1,3));
	    		a.add(new Interval(6,9));
	    		
	    		Interval newInterval = new Interval(2,5);
	    		
	    		List<Interval> res = insert(a, newInterval);
	    		
	    		for(Interval i: res) {
	    			System.out.println("i: [" + i.start + "," + i.end + "]");
	    		}
	    }

}
