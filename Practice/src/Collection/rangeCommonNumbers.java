package Collection;

public class rangeCommonNumbers {
	public static void main(String[] args) {
		//int arr[] = {0, 2, 3, 3, 3, 10, 10};
		int arr[] = {5, 7, 7, 8, 8, 10};
		//int num = 3;
		int num = 8;
		int[] opt = new int[2];
		opt[0] = -1;
		opt[1] = -1;
		modifiedBinarySearch(arr, num, opt, 0, arr.length-1);
		System.out.println("num: " + num + " range is : " + opt[0] + "," + opt[1]);
	}
	
	public static void modifiedBinarySearch(int[] arr, int num, int[] opt, int l, int h) {
		if(l>h)
			return;
		int mid = (l + h)/2;
		if(arr[mid] < num) 
			modifiedBinarySearch(arr, num, opt, mid + 1, h);
		else if(arr[mid] > num)
			modifiedBinarySearch(arr, num, opt, l, mid-1);
		else {
			opt[0] = mid;
			opt[1] = mid;
			int t = mid;
			System.out.println("mid: " + mid);
			while((t < h) && (arr[t+1] == num)) {
				t++;
				opt[1] = t;
				
			}
			System.out.println("after: " + t);
			t = mid;
			while((t > l) && (arr[t-1] == num)) {
				t--;
				opt[0] = t;
				
			}
			System.out.println("before: " + t);
			return;
		}
	}
}
