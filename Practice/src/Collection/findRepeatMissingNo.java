package Collection;

//from sequence find the number which is repeated and number which is missing from the sequence

public class findRepeatMissingNo {
	public static void main(String[] args) {
		int[] a = {7,3,4,5,5,6,2};
		int n = a.length;
		printNumbers(a, n);
	}
	
	public static void printNumbers(int[]a, int n) {
		System.out.print("Repeated Num is: ");
		for(int i = 0; i < n; i++) {
			if((a[Math.abs(a[i])-1]) > 0)
				a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
			else
				System.out.println(Math.abs(a[i]));
		}
		
		System.out.print("Missing num is: ");
		for(int i = 0; i < n; i++)
			if(a[i]>0)
				System.out.println(i+1);
	}
}

/*
 * Leetcode: https://leetcode.com/problems/find-the-duplicate-number/discuss/
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
/*
class Solution {
public int findDuplicate(int[] nums) {
    int low = 1;
    int high = nums.length - 1;
    while(low < high) {
        int mid = (low + high) / 2;
        int cnt = 0;
        for(int n: nums) {
            if(n <= mid)
                cnt++;
        }
        if(cnt > mid)
            high = mid;
        else
            low = mid + 1;
    }
    return low;        
}
}
*/
//a b aba a