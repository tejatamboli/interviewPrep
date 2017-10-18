package Collection;

public class mergeSortedArrays {
	public static void main(String[] args) {
		String[] a = {"good", "person"};
		String[] b = {"he", "is"};
		String[] c = new String[a.length + b.length];
		merge(a,b,c);
		for(String s : c) {
			System.out.println(s);
		}
	}
	
	public static void merge(String[] a, String[] b, String[] c) {
		int i = 0; int j = 0; int k = 0;
		while(i < a.length && j < b.length) {
			if(a[i].compareTo(b[j]) < 0)
				c[k++] = a[i++];
			else if(a[i].compareTo(b[j]) > 0)
				c[k++] = b[j++];
			else if(a[i].equals(b[j])) {
				c[k++] = a[i++];
				j++;
			}
		}
		while(i < a.length) 
			c[k++] = a[i++];
		while(j < b.length) 
			c[k++] = b[j++];		
	}
}
