package Collection;

/* LEetcode: https://leetcode.com/problems/majority-element/discuss/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

/* 
 * major number is present if num is present > a.length/2
 */
public class findMajorNumber {
	public static void main(String[] args) {
		int[] a = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int major_i = 0; 
		int count = 1;
		for(int i = 0; i < a.length; i++) {
			if(a[major_i] == a[i])
				count++;
			else
				count--;
			if(count == 0) {
				major_i = i;
				count = 1;
			}
		}
		count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[major_i] == a[i])
				count++;
		}
		if(count > a.length/2)
			System.out.println(a[major_i]);
		else
			System.out.println("No major element");
	}
}

/*
public class Solution {
public int majorityElement(int[] num) {

    int major=num[0], count = 1;
    for(int i=1; i<num.length;i++){
        if(count==0){
            count++;
            major=num[i];
        }else if(major==num[i]){
            count++;
        }else count--;
        
    }
    return major;
}
}
*/