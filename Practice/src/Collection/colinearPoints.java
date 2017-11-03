package Collection;
import java.util.*;

public class colinearPoints {
	public static void main(String[] args) {
		List<Point> p = new ArrayList<>();
		/*p.add(new Point(-1,1));
		p.add(new Point(0,0));
		p.add(new Point(1,1));
		p.add(new Point(2,2));
		p.add(new Point(3,3));
		p.add(new Point(3,4));*/
		
		p.add(new Point(0,0));
		p.add(new Point(-1,-1));
		p.add(new Point(2,2));
		System.out.println("ans: " + maxPointsOnSameLine(p)); 
		
		Point[] point = new Point[9];
		point[0] = new Point(84,250);
		point[1] = new Point(0,0);
		point[2] = new Point(1,0);
		point[3] = new Point(0, -70);
		point[4] = new Point(0,-70);
		point[5] = new Point(1,-1);
		point[6] = new Point(21,10);
		point[7] = new Point(42,90);
		point[8] = new Point(-42,-230);
		
		System.out.println("ans: " + maxPoints(point)); 
	}
	
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
	
	public static int maxPointsOnSameLine(List<Point> p) {
		
		Map <Point,Integer>m1 = new HashMap<>();
		
		int N = p.size();
		if(N < 2)
			return N;
		int maxPoint = 0; 
		int curMax = 0;
		int overlapPoints = 0, verticalPoints = 0;
		for(int i = 0; i < N; i++) {
			overlapPoints = verticalPoints = curMax = 0;
			for(int j = i+1; j < N; j++) {
				if(p.get(i).equals(p.get(j))) 
					overlapPoints++;
				else if(p.get(i).x == p.get(j).x)
					verticalPoints++;
				else {
					int yDiff = p.get(j).y-p.get(i).y;
					int xDiff = p.get(j).x-p.get(i).x;
					
					if(yDiff != 0) {
						int g = GCD(xDiff, yDiff);
						System.out.println("g: " + g + " [" +xDiff+","+yDiff+"]");
					
						yDiff = yDiff/g;
						xDiff = xDiff/g;
						System.out.println("[" + xDiff + "," + yDiff + "]");
					}
					
					Point a = new Point(xDiff,yDiff);
					if(m1.containsKey(a)) {
						int val = m1.get(a);
						m1.put(a, val+1);
					} else 
						m1.put(a, 1);
					System.out.println("Compairing i j: " + i +" "+j);
					System.out.println("[" + xDiff + "," + yDiff + "],val:" + m1.get(a));
					curMax = Math.max(curMax, m1.get(a));
				}
				curMax = Math.max(curMax, verticalPoints);
			}
			maxPoint = Math.max(maxPoint, curMax + 1 + overlapPoints);
			m1.clear();
		}
		return maxPoint;
	}

	/* Still failing on Leetcode */
	public static int maxPoints(Point[] points) {
        Map<Point, Integer>m1 = new HashMap<>();
        int maxPoint = 0;
        int curMax = 0, vertical = 0, overlap = 0;
        
        if(points.length < 2)
            return points.length;
        
        for(int i = 0; i < points.length; i++) {
            curMax = vertical = overlap = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                    overlap++;
                else if(points[i].x == points[j].x)
                    vertical++;
                else {
                    int yDiff = points[j].y - points[i].y;
                    int xDiff = points[j].x - points[i].x;
                
                    //if(yDiff != 0) {
                        int g = gcd(xDiff, yDiff);
                        yDiff = yDiff/g;
                        xDiff = xDiff/g;
                    //}
                
                    Point a = new Point(xDiff, yDiff);
                    System.out.println("a: " + a.x + " " + a.y + " " + i + " " + j);
                    if(m1.containsKey(a)) {
                        int cnt = m1.get(a);
                        m1.put(a, cnt+1);
                    } else
                        m1.put(a, 1);
                    curMax = Math.max(curMax, m1.get(a));
                    System.out.println("curMax: " + curMax);
                }
                    
                curMax = Math.max(curMax, vertical);
                
            }
            maxPoint = Math.max(curMax + overlap + 1, maxPoint);
            m1.clear();
        }
        return maxPoint;
    }
	
	public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}
