package String;

public class strrev {
	public static void main(String[] args) {
		String s = "This is a test";
		char[]t = s.toCharArray();
		reverse(t, 0, s.length()-1);
	}
	
	public static void reverse(char[] s, int l, int h) {
		if (l > h) {
			System.out.println(String.valueOf(s));
			return;
		}
		if(l == h)
			return;
		char t = s[l];
		s[l] = s[h];
		s[h] = t;
		reverse(s, l+1,h-1);
 	}
}
