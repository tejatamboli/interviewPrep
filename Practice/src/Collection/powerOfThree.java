package Collection;

/* Leetcode: https://leetcode.com/problems/power-of-three/description/
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?


 */

public class powerOfThree {
	
	    public boolean isPowerOfThree(int n) {
	        if(n > 1) {
	            while(n%3 == 0) 
	                n = n / 3;
	        }
	        return n==1;       
	    }
}
