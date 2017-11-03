package Collection;

public class rotatedBinarySearch {
	
	public static void main(String[] args) {
		//int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//int key = 2;
		//int arr[] = {9,7,3,2};
		//int key = 3;
		int arr[] = {3,1};
		int key = 1;
		int index = -1;
		
		int pivot = findPivot(arr, 0, arr.length-1);
		if (pivot == -1)
			index = binarySearch(arr, 0, arr.length-1, key);
		else {
			if (arr[0] <= key)
				index = binarySearch(arr, 0, pivot-1, key);
			else
				index = binarySearch(arr, pivot+1, arr.length-1, key);
		}
		System.out.println("Key: " + key + " is at : " + index);
	}
	
	public static int findPivot(int arr[], int low, int high) {
		if (low>high)
			return -1;
		if (low == high)
			return low;
		int mid = (low + high)/2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (low < mid  && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid-1);
		return findPivot(arr, mid+1, high);
	}
	
	public static int binarySearch(int arr[], int low, int high, int key) {
		if (low > high)
			return -1;
		int mid = (low + high)/2;
		if (arr[mid] == key)
			return mid;
		else if (arr[mid] > key)
			return binarySearch(arr, low, mid-1, key);
		return binarySearch(arr, mid+1, high, key);
		
	}
}
//Leetcode
/*
 * class Solution {
    public int search(int[] nums, int target) {
        
        int pivotIndex = findPivot(nums, 0, nums.length-1);
        if(pivotIndex == -1)
            return binarySearch(nums, 0, nums.length-1, target);
        else if(target == nums[pivotIndex])
            return pivotIndex;
        else if (nums[0] <= target)
            return binarySearch(nums, 0, pivotIndex-1, target);
        return binarySearch(nums, pivotIndex+1, nums.length-1, target);
    }
    
    public int binarySearch(int[] nums, int low, int high, int target) {
        if(low > high)
            return -1;
        int mid = (low + high)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return binarySearch(nums, mid+1, high, target);
        return binarySearch(nums, low, mid-1, target);
    }
    
    public int findPivot(int[] nums, int low, int high) {
        if(low > high)
            return -1;
        if(low == high)
            return low;
        int mid = (low + high)/2;
        if(mid < high && nums[mid] > nums[mid+1])
            return mid;
        else if(mid > low && nums[mid-1] > nums[mid])
            return (mid-1);
        if(nums[low] >= nums[mid])
            return findPivot(nums, low, mid-1);
        return findPivot(nums, mid+1, high);      
    }
}
*/
