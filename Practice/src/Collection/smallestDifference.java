package Collection;
import java.util.*;

//find smallest distance between two arrays:

public class smallestDifference {
	static int findSmallestDifference(int A[], int B[], int m, int n)
    {
			// Sort both arrays using sort function
			Arrays.sort(A);
			Arrays.sort(B);

			int a = 0, b = 0;

			// Initialize result as max value
			int result = Integer.MAX_VALUE;

			// Scan Both Arrays upto sizeof of the 
			// Arrays
			while (a < m && b < n) {
				if (Math.abs(A[a] - B[b]) < result)
					result = Math.abs(A[a] - B[b]);

				// Move Smaller Value
				if (A[a] < B[b])
					a++;
				else
					b++;
			}
			// return  final small  result
			return result; 
    }
	
	/* 
	 * Difference between any two arrays
	public static int getDifference(int[] a, int[] b) {
			int i = 0;
			int j = 0;
			int result = Integer.MAX_VALUE;
			int a_min = minDifference(a);
			int b_min = minDifference(b);
			while (i < a.length && j < b.length) {
				if (a[i] <= b[j]) {
					result = Math.min(result, b[j]-a[i]);
					i++;
				}
				else {
					result = Math.min(result, a[i]-b[j]);
					j++;
				}
			}
			return compare(a_min, b_min, result);
		}	
	
		public static int compare(int a, int b, int c) {
			int e = Math.min(a, b);
			int f = Math.min(e, c);
			return f;				
		}
	
		public static int minDifference(int[] A) {
			Arrays.sort(A);
			if (A.length > 1) {
		        int d = Math.abs(A[0] - A[1]);
		        for (int i = 0; i <= A.length; i++) {
		            if (i + 1 < A.length) {
		                int t = Math.abs(A[i] - A[i + 1]);
		                if (t < d)
		                	d = t;
		            }
		        }
		        return d;
			}
			return -1;
		}
	 */

}
