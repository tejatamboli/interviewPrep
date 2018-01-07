package String;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420
 * 
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */

public class sortByFrequency {
	    public String frequencySort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) {
	            if (map.containsKey(c)) {
	                map.put(c, map.get(c) + 1);
	            } else {
	                map.put(c, 1);
	            }
	        }
	        PriorityQueue<Map.Entry<Character, Integer>> maxpq = new PriorityQueue<>(
	            new Comparator<Map.Entry<Character, Integer>>() {
	                @Override
	                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
	                    return b.getValue() - a.getValue();
	                }
	            }
	        );
	        maxpq.addAll(map.entrySet());
	        StringBuilder sb = new StringBuilder();
	        while (!maxpq.isEmpty()) {
	            Map.Entry<Character, Integer> e = maxpq.poll();
	            for (int i = 0; i < (int)e.getValue(); i++) {
	                sb.append(e.getKey());
	            }
	        }
	        return sb.toString();
	    }
	    
	    /* 
	     * public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}
	     */
}
