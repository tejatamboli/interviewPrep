package Collection;

public class test {
	
	public static boolean checkForDescending(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++)
			if(arr[i] < arr[i+1])
				return false;
		return true;
	}
	
	public static int search(int[] arr, int target) { 
        int left = 0;
        int right = arr.length-1;
        
        if(checkForDescending(arr))
        		return binarySearch(arr,target, left, right);
        
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(arr[mid] == target) 
                return mid;
            if(arr[left] <= arr[mid]) {
                if(arr[left] <= target && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
	
	public static int binarySearch(int[] arr, int target, int left, int right) {
        while(left <= right) {
            int m = (left + right) / 2;
            if(arr[m] == target)
                return m;
            else if(arr[m] < target)
                right = m - 1;
            else
                left = m + 1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] A = {9,7,3,2};
		System.out.println(search(A, 3));
	}

}
