package Collection;

import java.util.*;

/* 
 * Merge the intervals and print unique intervals in each interval
 * This can be find out by end - start
 */
public class cntMergedInterval {
	
	public static void main(String[] args) {
		List<Interval> l1 = new ArrayList<>();
		/*l1.add(new Interval(1,3));
		l1.add(new Interval(2,5));
		l1.add(new Interval(8,9));*/
		l1.add(new Interval(1,3));
		l1.add(new Interval(2,5));
		l1.add(new Interval(8,10));
		l1.add(new Interval(4,9));
		
		
		int cnt = findRange(l1);
		System.out.println("Cnt : " + cnt);
	}
	
	public static int findRange(List<Interval> l1) {
		Collections.sort(l1, new Comparator<Interval>() {
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
		
		int s = 0;
		int i = 0;
		int range = 0;
		while(i < l1.size()) {
			int j = i+1;
			int e = l1.get(i).end;
			while((j < l1.size()) && (l1.get(j).start) <= e) {
				e = Math.max(e, l1.get(j).end);
				j++;
			}
			range += e - l1.get(s).start;
			System.out.println("e: " + e + " start: " + l1.get(s).start);
			i = s = j;
		}
		return range;
	}
}
