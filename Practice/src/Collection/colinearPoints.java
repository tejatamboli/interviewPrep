package Collection;
import java.util.*;

public class colinearPoints {
	public static void main(String[] args) {
		List<Point> p = new ArrayList<>();
		p.add(new Point(-1,1));
		p.add(new Point(0,0));
		p.add(new Point(1,1));
		p.add(new Point(2,2));
		p.add(new Point(3,3));
		p.add(new Point(3,4));
		System.out.println("ans: " + maxPointsOnSameLine(p));
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
					int g = GCD(xDiff, yDiff);
					System.out.println("g: " + g + " [" +xDiff+","+yDiff+"]");
					
					yDiff = yDiff/g;
					xDiff = xDiff/g;
					System.out.println("[" + xDiff + "," + yDiff + "]");
					
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

}
