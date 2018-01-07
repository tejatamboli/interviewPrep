package Collection;



/*
 * find triplet with following condition
 * (a+b > c) && (b+c > a) && (c+a > b)
 */

public class findTriplet {
	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 4, 7, 1};
		for(int i = 0; i < arr.length-2; i++) {
			for(int j = i+1; j < arr.length-1; j++) {
				for(int k = j+1; k < arr.length; k++) {
					int a = arr[i];
					int b = arr[j];
					int c = arr[k];	
					if (a + b <= c) continue;
					else if (b + c <= a) continue;
					else if (c + a <= b) continue;
					else System.out.println("Triplet : ["+a+","+b+","+c+"]");
				}
			}
		}
	}
}
		
		/* at the most one this will work. For all use brute force
		Arrays.sort(arr);
		int i = 0;
		int j = 1;
		int k = 2;
		for(k = 2; k <arr.length; k++) {
			if (isTriplet(arr[i++], arr[j++], arr[k]))
				continue;
		}
	}
		
		public static boolean isTriplet(int a, int b, int c) {
			if ((a+b > c) && (b+c > a) && (c+a > b)) { 
				System.out.println("Triplet : ["+a+","+b+","+c+"]");
				return true;
			}
			return false;
		}
}*/
/*
 * 10 5 3
 * 10 3 4
 * 10 4 7
 * 10 7 1
 * 1 3 4 5 7 10
 * 1 3 4
 * 1 4 5
 * 1 5 7
 * 1 7 10
 * a+b > c && b+c > a && c+a >b
 * 8>7 10>5 12>3
 * 
 * 4 7 10
 * 11>10 17>4 14>7
 * 
 * 1 3 4
 * 3 4 5
 * 4 5 7
 * 5 7 10
 */
