package HashMap;
import java.util.*;


public class mapdemo {
	   public static void main(String[] args) {
	      Map m1 = new HashMap(); 
	      m1.put("Zara", "8");
	      m1.put("Mahnaz", "31");
	      m1.put(24.45, "12");
	      m1.put("Daisy", "14");

	      System.out.println();
	      System.out.println(" Map Elements : " + m1.size());
	      if (!m1.isEmpty())
	    	  	System.out.println("\t" + m1);
	      
	      System.out.println("containsKey : " + m1.containsKey("Zara"));
	      System.out.println("containsVal : " + m1.containsValue("14"));
	      
	      System.out.println("Printing Keys");
	      Iterator it = m1.keySet().iterator();
	      while(it.hasNext()) {
	    	  	System.out.println("Key : " + it.next());	
	      }
	      
	      System.out.println("Printing Key-Values");
	      Iterator it1 = m1.entrySet().iterator();
	      while (it1.hasNext()) {
	          Map.Entry pair = (Map.Entry)it1.next();
	          System.out.println(pair.getKey() + " = " + pair.getValue());
	      }
	      
	      System.out.println("Printing Values");
	      for (Object value : m1.values()) {
	    	    System.out.println("Value = " + value);
	    	}
	   }
}
