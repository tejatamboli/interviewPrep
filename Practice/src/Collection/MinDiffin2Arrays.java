package Collection;
import java.util.*;

public class MinDiffin2Arrays {
	public static int findSmallestDifference(int A[], int B[], int m, int n) {
		// Sort both arrays using sort function
		Arrays.sort(A);
		Arrays.sort(B);

		int a = 0, b = 0;

		// Initialize result as max value
		int result = Integer.MAX_VALUE;

		// Scan Both Arrays upto sizeof of the Arrays
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
}
