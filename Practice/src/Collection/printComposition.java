package Collection;

//Display 5 in multipe ways i.e sum of digits e.g 11111, 12111

public class printComposition {
	public static void main(String[] args) {
		int n = 5;
		int[] arr = new int[100];
		printComposition(arr, n, 0, n);
	}	
	public static void printComposition(int[] arr, int n, int i, int max) {	
		if(n == 0)
			printArray(arr, i);
		else if (n > 0) {
			for(int k = 1; k <= max; k++) {
				arr[i] = k;
				printComposition(arr, n-k, i+1, max);
			}
		}
	}
	public static void printArray(int[] arr, int i) {
		for(int j = 0; j < i; j++) 
			System.out.print(arr[j]);
		System.out.println("");
	}
}
