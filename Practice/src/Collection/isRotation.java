package Collection;

public class isRotation {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "bca";
		System.out.println("" + isRotation(s1, s2));
	}
	public static Boolean isRotation(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		String s = s1+s1;
		if(s.contains(s2))
			return true;
		return false;
	}
}
