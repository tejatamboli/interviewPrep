package Collection;
import java.util.*;

public class missingRanges {
	    public List<String> findMissingRanges(int[] a, int lower, int upper) {
	        List<String> res = new ArrayList<String>();
	        int next = lower;
	  
	        for (int i = 0; i < a.length; i++) {
	            // not within the range yet
	            if (a[i] < next) 
	                continue;
	    
	            // continue to find the next one
	            if (a[i] == next) {
	                next++;    
	            } else {
	                // get the missing range string format
	                res.add(getRange(next, a[i] - 1));
	                 // now we need to find the next number
	                next = a[i] + 1;
	            }
	    }
	    if(next <= upper)
	        res.add(getRange(next, upper));
	    System.out.println("res: " + res + " next: " + next + " upper: " + upper);
	    return res;
	 }
	  
	  String getRange(int n1, int n2) {
	    return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	  }
}
