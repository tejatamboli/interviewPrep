package HashMap;

import java.util.*;

/*
 Asked in Pinterest
 
String[] counts = {
        "900,google.com",
        "60,mail.yahoo.com",
        "10,mobile.sports.yahoo.com",
        "40,sports.yahoo.com",
        "300,yahoo.com",
        "10,stackoverflow.com",
        "2,en.wikipedia.org",
        "1,es.wikipedia.org",
        "1,com" };
        
Expected output (in any order):
1320    com
 900    google.com
 410    yahoo.com
  60    mail.yahoo.com
  10    mobile.sports.yahoo.com
  50    sports.yahoo.com
  10    stackoverflow.com
   3    org
   3    wikipedia.org
   2    en.wikipedia.org
   1    es.wikipedia.org

Write a function that takes this input as a parameter and returns a data structure containing the number 
of hits that were recorded on each domain AND each domain under it. For example, an impression on 
"sports.yahoo.com" counts for "sports.yahoo.com", "yahoo.com", and "com". 
(Subdomains are added to the left of their parent domain. So "sports" and "sports.yahoo" are not valid 
domains.)
 */

public class getDomainClicks {
	
	public static void main(String[] args) {
	    String[] counts = {
	        "900,google.com",
	        "60,mail.yahoo.com",
	        "10,mobile.sports.yahoo.com",
	        "40,sports.yahoo.com",
	        "300,yahoo.com",
	        "10,stackoverflow.com",
	        "2,en.wikipedia.org",
	        "1,es.wikipedia.org",
	        "1,com" };
	    
	    Map<String, Integer> map = getDomainsClicks1(counts);
	    System.out.println(map.toString());
	}
	
	public static Map<String, Integer> getDomainsClicks1(String[] counts) {
	    
	    Map<String, Integer> map = new HashMap<>();
	    
	    for(String s: counts) {
	      String[] arr = s.split(",");
	      int val = 0;
	      if(map.containsKey(arr[1])) {
	        val = map.get(arr[1]);
	      }
	      map.put(arr[1], val + Integer.parseInt(arr[0]));
	      String[] domains = arr[1].split("\\.");
	      String prev = null;
	      for(int i = domains.length-1; i > 0; i--) {    
	        String subdomain = (prev!= null) ? domains[i] + "." + prev : domains[i];
	        val = 0;
	        if(map.containsKey(subdomain))
	          val = map.get(subdomain);
	        map.put(subdomain, val + Integer.parseInt(arr[0]));
	        prev = subdomain;
	      }
	    } //end of for loop
	    System.out.println(map);
	    return map;
	  }
}
