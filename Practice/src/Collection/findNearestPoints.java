package Collection;

import java.util.*;

/*
 * Find m points from the input list which are close from the center.  
 * 
 * 
http://wxx5433.github.io/nearest-k-points.html
 **
 * Stores a given point in an internal data structure
 *
void addPoint(Point point);


 * For given 'center' point returns a subset of 'm' stored points that are
 * closer to the center than others.
 *
 * E.g. Stored: (0, 1) (0, 2) (0, 3) (0, 4) (0, 5)
 *
 * findNearest(new Point(0, 0), 3) -> (0, 1), (0, 2), (0, 3)
 *
Collection<Point> findNearest(Point center, int m);

 */

public class findNearestPoints {
	
	static Set<Point> m1 = new HashSet<>();
	
	public static void main (String[] args) {
		//findNearestPoints np = new findNearestPoints();
		m1.add(new Point(0,1));
		m1.add(new Point(0,2));
		m1.add(new Point(0,3));
		m1.add(new Point(0,4));
		m1.add(new Point(0,5));	
		Point p = new Point(0, 0);
		for(Point p1: findNearest(p, 3)) {
			System.out.println("[" + p1.x + " , " + p1.y + "]");
		}	
	}
	
	public static Collection<Point> findNearest(Point c, int m) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(m, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				System.out.println("p2: " + getDistance(p2, c));
				System.out.println("p1: " + getDistance(p1, c));
				return Double.compare(getDistance(p2, c) , getDistance(p1, c));
			}
		});
		
		for(Point p: m1) {
			if(p == c)
				continue;
			else if(maxHeap.size() < m) {
				maxHeap.add(p);
			} else if(getDistance(p, c) < getDistance(maxHeap.peek(), c)) {
				System.out.println("getDist: " + getDistance(p, c));
				System.out.println("getDist Heap: " + getDistance(maxHeap.peek(), c));
				System.out.println("Take out the old from the heap");
				maxHeap.remove();
				maxHeap.add(p);
			}
		}
		return maxHeap;
	}
	
	public static Double getDistance(Point p, Point c) {
		return Math.pow(p.x-c.x, 2) + Math.pow(p.y-c.y, 2);
	}
}

/*
 * Key Points:
 * 1. For maxHeap use compare function as p2, p1
 * 2. For minHeap use compare function as p1, p2
 */
