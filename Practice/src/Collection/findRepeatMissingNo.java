package Collection;

//from sequence find the number which is repeated and number which is missing from the sequence

public class findRepeatMissingNo {
	public static void main(String[] args) {
		int[] a = {7,3,4,5,5,6,2};
		int n = a.length;
		printNumbers(a, n);
	}
	
	public static void printNumbers(int[]a, int n) {
		System.out.print("Repeated Num is: ");
		for(int i = 0; i < n; i++) {
			if((a[Math.abs(a[i])-1]) > 0)
				a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
			else
				System.out.println(Math.abs(a[i]));
		}
		
		System.out.print("Missing num is: ");
		for(int i = 0; i < n; i++)
			if(a[i]>0)
				System.out.println(i+1);
	}
}
