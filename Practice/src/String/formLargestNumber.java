package String;
import java.util.*;

/* Leetcpde: https://leetcode.com/problems/largest-number/discuss/53158/
 * Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 */

public class formLargestNumber {
	public String largestNumber(int[] nums) {
	        if(nums == null || nums.length == 0)
	            return "";
	        String[] arr = new String[nums.length];
	        for(int i = 0; i < nums.length; i++) 
	            arr[i] = "" + nums[i];
	        Arrays.sort(arr, new Comparator<String>() {
	            @Override
	            public int compare(String s1, String s2) {
	                String str1 = s1+s2;
	                String str2 = s2+s1;
	                return str2.compareTo(str1);    
	            }
	        });
	        
	        if(arr[0].charAt(0) == '0') { /*some crap condition */
	             return "0";
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < nums.length; i++) {
	            System.out.println("arr[%d]: " + i + " : " + arr[i]);
	            sb.append(arr[i]);
	        }
	        return sb.toString();        
	    }
}
