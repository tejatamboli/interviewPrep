package Collection;

public class mergeSortedArrays {
	public static void main(String[] args) {
		String[] a = {"good", "person"};
		String[] b = {"he", "is"};
		String[] c = new String[a.length + b.length];
		merge(a,b,c);
		for(String s : c) {
			System.out.println(s);
		}
	}
	
	public static void merge(String[] a, String[] b, String[] c) {
		int i = 0; int j = 0; int k = 0;
		while(i < a.length && j < b.length) {
			if(a[i].compareTo(b[j]) < 0)
				c[k++] = a[i++];
			else if(a[i].compareTo(b[j]) > 0)
				c[k++] = b[j++];
			else if(a[i].equals(b[j])) {
				c[k++] = a[i++];
				j++;
			}
		}
		while(i < a.length) 
			c[k++] = a[i++];
		while(j < b.length) 
			c[k++] = b[j++];		
	}
}


/* Leetcode: https://leetcode.com/problems/merge-sorted-array/description/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 

 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else 
                nums1[k--] = nums2[j--];   
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        } 
    }
}
*/