package backtrack;

public class combination {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int r = 3;
		int n = a.length;
		
		getCombination(a,n,r);
	}
	
	public static void getCombination(int[] a, int n, int r) {
		int[] data = new int[r];
		printCombination(a,n,r,0,data,0);
	}
	
	public static void printCombination(int[]a, int n, int r, int index, int[] data, int i) {
		if(index == r) {
			for(int j = 0; j < r; j++)
				System.out.print(" " + data[j]);
			System.out.println();
			return;
		}
		if(i>=n)
			return;
		data[index] = a[i];
		printCombination(a, n, r, index+1, data, i+1);
		printCombination(a, n, r, index, data, i+1);
	}

}
