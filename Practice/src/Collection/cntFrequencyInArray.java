package Collection;

/*_21.Count the number of occurrences of an element in a sorted array
 */
public class cntFrequencyInArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 3, 3, 3};
		int x = 3;
		int n = arr.length;
		int cnt = count(arr, x, n);
		System.out.println("cnt: " + cnt);
	}
	
	public static int count(int[] arr, int x, int n) {
		int first = getFirst(arr, x, 0, n-1);
		int last = getLast(arr, x, n, 0, n-1);
		System.out.println("First: " + first + " last: " + last);
		return last-first+1;
	}
	
	public static int getFirst(int[] arr, int x, int l, int h) {
		if(l > h)
			return -1;
		int mid = (l + h)/2;
		if(mid == 0 || arr[mid] == x && arr[mid-1] < x)
			return mid;
		else if(x > arr[mid])
			return getFirst(arr, x, mid+1, h);
		else
			return getFirst(arr, x, l, mid-1);
	}
	
	public static int getLast(int[] arr, int x, int n, int l, int h) {
		if(l > h)
			return -1;
		int mid = (l + h)/2;
		if(mid == n-1 || arr[mid] == x && arr[mid+1] > x)
			return mid;
		else if(x < arr[mid])
			return getLast(arr, x, n, l, mid-1);
		else
			return getLast(arr, x, n, mid+1, h);	
	}
}
