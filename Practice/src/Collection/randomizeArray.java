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

/* Leetcode: https://leetcode.com/problems/shuffle-an-array/description/
 * Shuffle a set of numbers without duplicates.
 * 
 * class Solution {
    private int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
        
    }
    
    // Resets the array to its original configuration and return it. 
    public int[] reset() {
        return this.nums;
        
    }
    
    // Returns a random shuffling of the array. 
    public int[] shuffle() {
        int[] a = nums.clone();
        for(int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i+1);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        return a;
    }
}

def fisher_yates_shuffle(items):
    for i in range(len(items)):
        randomIndex = random.randint(i, len(items)-1)
        temp = items[randomIndex]
        items[randomIndex] = items[i]
        items[i] = temp
    return items

*/
