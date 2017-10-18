package Collection;

public class Point {
	int x;
	int y;
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	@Override
	public boolean equals(final Object o) {
		if(!(o instanceof Point))
			return false;
		if(((Point) o).x != x)
			return false;
		if(((Point) o).y != y)
			return false;
		return true;	
	}
	@Override
	public int hashCode() {
        return new Integer(x + "0" + y);
    }
	

}
