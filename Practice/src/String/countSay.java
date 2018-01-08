package String;

/* Leetcode 
 * https://leetcode.com/problems/count-and-say/discuss/
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
6.     312211
7.     13112221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.
 */

public class countSay {
	  public String countAndSay(int n) {
	        StringBuilder curr = new StringBuilder("1");
	        StringBuilder prev = null;
	        for(int i = 1; i < n; i++) {
	            prev = curr;
	            curr = new StringBuilder();
	            char s = prev.charAt(0);
	            int count = 1;
	            for(int j = 1; j < prev.length(); j++) {
	                if(prev.charAt(j) != s) {
	                    curr.append(count).append(s);
	                    count = 1;
	                    s = prev.charAt(j);
	                } else 
	                    count++;
	            }
	            curr.append(count).append(s);
	        }
	        return curr.toString();
	    }
}
