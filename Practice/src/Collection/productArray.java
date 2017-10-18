package Collection;

/*
 * Given an array of numbers , replace each number with the product 
 * of all the numbers divided by the number at that index without
 * using the division operator 
 */

import java.util.Arrays;

public class productArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		makeArr(arr,n);
	}
	
	public static void makeArr(int[] arr, int n) {
		int[] prod = new int[n];
		Arrays.fill(prod, 1);
		int temp = 1;
		for(int i = 0; i < n; i++) {
			prod[i] = temp;
			temp = temp * arr[i];
		}
		temp = 1;
		for(int i = n-1; i >= 0; i--) {
			prod[i] = prod[i] * temp;
			temp = temp * arr[i];
		}
			
		for(int i = 0; i < n; i++) {
			System.out.println(" " + prod[i]);
		}
	}
}
