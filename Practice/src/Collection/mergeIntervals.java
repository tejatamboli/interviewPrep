package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Airbnb
//Keep merging intervals if there is oerlap
public class mergeIntervals {
	
	public static void getIntervals(List<Interval> arr) {
		Collections.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start > o2.start)
					return 1;
				else if(o2.start > o1.start)
					return -1;
				else if(o1.end > o2.end)
					return 1;
				else if(o2.end > o1.end)
					return -1;
				else
					return 0;
			}
		});
		
		int index = 0;
		for(int i = 0; i < arr.size(); i++) {
			if(index != 0 && arr.get(index).start <= arr.get(index-1).end) {
				while(index != 0 && arr.get(index).start <= arr.get(index-1).end) {
					arr.get(index-1).start = Math.min(arr.get(index-1).start, arr.get(index).start);
					arr.get(index-1).end = Math.max(arr.get(index-1).end, arr.get(index).end);
					index--;
				}
			} else
				arr.set(index, arr.get(i));
			index++;
			
		}
		System.out.println("The Merged Intervals are: ");
		for (int i = 0; i < index; i++)
			System.out.println("[" + arr.get(i).start + ", " + arr.get(i).end + "] ");
	}
	
	public static void main(String[] args) {
		List<Interval> arr = new ArrayList<>();
		arr.add(new Interval(1,3));
		arr.add(new Interval(2,6));
		arr.add(new Interval(8,10));
		arr.add(new Interval(15,18));
		getIntervals(arr);
		
		
	}
	
/* Leetcode
 public List<Interval> merge(List<Interval> arr) {
        Collections.sort(arr, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               if(i1.start > i2.start)
                   return 1;
               else if(i1.start < i2.start)
                   return -1;
               else if(i1.end > i2.end)
                   return 1;
               else if(i1.end < i2.end)
                   return -1;
               else
                   return 0;
           } 
        });
        
        List<Interval> res = new LinkedList<>();
        
        if(arr == null || arr.size() == 0)
            return arr;
        
        int start = arr.get(0).start;
        int end = arr.get(0).end;
        
        for(Interval a: arr) {
            if(a.start <= end) { //overlap interval
                end = Math.max(end, a.end);
            } else {
                res.add(new Interval(start, end));
                start = a.start;
                end = a.end;
            }    
        }
        res.add(new Interval(start, end));
        return res;
    }
 */
}
