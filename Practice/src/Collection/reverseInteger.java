package Collection;

/* 
 * Leetcode: https://leetcode.com/problems/reverse-integer/discuss/
 */

public class reverseInteger {
	
	
	    public int reverse(int x) {
	        boolean negative = false;
	        if(x < 0) {
	            negative = true;
	            x = x * -1;
	        }
	        int new_number = 0;
	        int prev_number = 0;
	        
	        while(x > 0) {
	            int y = x % 10;
	            System.out.println("y: " + y);
	            new_number =  new_number * 10 + y;
	            x = x / 10;
	            if( ((new_number - y) / 10) != prev_number)
	                return 0;
	            prev_number = new_number;
	        }
	        if(negative)
	            new_number = new_number * -1;
	        
	        return new_number;
	    }
	

}
