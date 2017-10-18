package Collection;

import java.util.Arrays;
import java.util.Random;

/* randomize an array */
public class randomizeArray {
	
	private int[] nums;
	private Random random;
	
	public randomizeArray (int[] nums) {
		this.nums = nums;
		random = new Random();
	}
	
	public int[] reset() {
		return this.nums;
	}
	
	public int[] shuffle() {
		int[] arr = Arrays.copyOf(nums, nums.length);
		for(int i = 1; i < arr.length; i++)
			swap(arr, i, random.nextInt(i+1));
		return arr;
	}
	
	public void print() {
		System.out.println("");
		for(int i = 0; i < nums.length; i++)
			System.out.print(" " + nums[i]);
	}
	public void swap(int[] arr, int i, int j) {
		if(nums[i] == nums[j])
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
		
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		randomizeArray r = new randomizeArray(arr);
		r.print();
		r.shuffle();
		r.print();		
	}
}
