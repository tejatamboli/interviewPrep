package Collection;

/* Leetcode: https://leetcode.com/problems/sum-of-two-integers/description/
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
Example:
Given a = 1 and b = 2, return 3.
 */

public class getSumWOSign {	
	    public int getSum(int a, int b) {
	        int carry = 0;
	        while(b != 0) {
	            System.out.println("a: " + a + " b: " + b + " c: " + carry);
	            carry = a & b;
	            a = a ^ b;
	            b = carry << 1;
	            System.out.println("end a: " + a + " b: " + b + " c: " + carry);
	        }
	        return a;       
	    }
}
