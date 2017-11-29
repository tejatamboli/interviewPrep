package Collection;

/* Find the Kth hisghest element in a given array.  */

public class KthHighestElementFromArray {
	
	public static void main(String[] args) {
	    //3,5,7,12,19
		int[] arr = {12,3,5,7,19};
		int n = arr.length;
		//int k = 2; // for third smallest element
		int k = n - 2 + 1; //for third highest element
	
		System.out.println("third number: " + findNum(arr, 0, n-1, k));
	}
	
	public static int findNum(int[] arr, int low, int r, int k) {
		if (k >0 && k <= r - low + 1) {
			int pos = partition(arr, low, r);
			if(pos-low == k-1)
				return arr[pos];
			if(pos-low > k-1)
				return findNum(arr, low, pos-1, k);
			return findNum(arr, pos+1, r, k-pos+low-1);		
		}
		return Integer.MAX_VALUE;
	}
	
	public static int partition(int[] arr, int l, int r) {
		int pivot = arr[r];
		int i = l;
		for(int j = l; j < r; j++) {
			if(arr[j] <= pivot) {
				swap(arr, j, i);
				i++;
			}
		}
		swap(arr, r, i);
		return i;
	}
	
	public static void swap(int[] arr, int j, int i) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
