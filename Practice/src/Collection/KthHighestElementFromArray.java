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

/* Working in Leetcode
 * class Solution {
    public int findKthLargest(int[] nums, int k) {     
        shuffle(nums); //quick sort is O(n^2) if array is sorted
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int l, int r) {
        int i = l;
        int pivot = nums[r];
        for(int j = l; j < r; j++) {
            if(nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}
*/
