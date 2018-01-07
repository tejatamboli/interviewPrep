package Collection;
import java.util.*;

public class uniqueNumbersFromArray {
	public static void main(String args[]) {
		int arr[] = {3, 5, 6, 6, 7, 7};
		Map<Integer, Integer>m1 = new HashMap<>();
		for (Integer i : arr) {
			if (m1.containsKey(i)) {
				m1.put(i, (m1.get(i) + 1));
			} else {
				m1.put(i, 1);
			}
		}
		
		Iterator<Map.Entry<Integer, Integer>> it = m1.entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry<Integer, Integer>pair = it.next();
	          if (pair.getValue() == 1)
	        	  		System.out.println(pair.getKey());
	      }
		
	
	      int count = 0;
	      for(int i = 0; i < arr.length; i++) {
	    	  	if (i == arr.length - 1) {
	    	  		if (count == 0)
	    	  			System.out.println(arr[i]);
	    	  		break;
	    	  	}
	    	  	if (arr[i] != arr[i + 1]) {
	    	  		if (count == 0) 
	    	  			System.out.println(arr[i]);
	    	  		count = 0;
	    	  	} else
	    	  		count++;   	  		
	      }
	}
}
