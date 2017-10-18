package Collection;

public class findMajorNumber {
	public static void main(String[] args) {
		int[] a = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int major_i = 0; 
		int count = 1;
		for(int i = 0; i < a.length; i++) {
			if(a[major_i] == a[i])
				count++;
			else
				count--;
			if(count == 0) {
				major_i = i;
				count = 1;
			}
		}
		count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[major_i] == a[i])
				count++;
		}
		if(count > a.length/2)
			System.out.println(a[major_i]);
		else
			System.out.println("No major element");
	}
}
