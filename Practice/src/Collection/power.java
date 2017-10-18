package Collection;

public class power {
	public static void main(String[] args) {
		System.out.println("opt: " + myPower(3, 3));
		System.out.println("opt: " + Math.pow(3, 3));
		
	}
	public static float myPower(float x, int y) {
		float temp;
		if(y == 0)
			return 1;
		temp = myPower(x, y/2);
		if(y%2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp)/x;
		}
	}
}
