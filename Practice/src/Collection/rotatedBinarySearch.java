package Collection;

public class rotatedBinarySearch {
	
	public static void main(String[] args) {
		//int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		//int key = 2;
		int arr[] = {9,7,3,2};
		int key = 3;
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
