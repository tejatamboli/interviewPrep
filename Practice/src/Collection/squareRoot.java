package Collection;

public class squareRoot {
	public static void main(String[] args) {
		System.out.println(findSquareRoot(10));
	}
	
	public static double findSquareRoot(int num) {
		double low = 0;
		double high = num;
		double mid = (low + high) / 2;
		while(Math.abs(num - (mid * mid)) > 0.00001) {
			if (mid * mid == num)
				return mid;
			else if (mid * mid > num)
				high = mid;
			else
				low = mid;
			mid = (low + high) / 2;
			
		}
		
		return mid;
	}
}

/* Leetcode: https://leetcode.com/problems/sqrtx/discuss/

class Solution {
public int mySqrt(int num) {
    double low = 0;
	double high = num;
	double mid = (low + high) / 2;
    if(num <= 1)
        return num;
	while(Math.abs(num - (mid * mid)) > 0.00001) {
		if (mid * mid == num) {
            return (int)mid;
        }
		else if (mid * mid > num)
			high = mid;
		else
			low = mid;
		mid = (low + high) / 2;
	}
	return (int)mid;
}
}
*/