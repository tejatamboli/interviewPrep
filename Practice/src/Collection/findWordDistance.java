package Collection;

public class findWordDistance {
	public static void main(String[] args) {
		//String s = "hello how are you";
		//String s = "hello how are hello you";
		//String s = "you are hello";
		String s = "hellow how are hello";
		String a = "hello";
		String b = "you";
		
		System.out.println("Dist: " + getDistance(s, a, b));
	}
	
	public static int getDistance(String s, String a, String b) {
		int aIndex = -1;
		int bIndex = -1;
		int min = Integer.MAX_VALUE;
		String[] tokens = s.split("[ \t]+");
		int i = 0;
		for(String t: tokens) {
			System.out.println("" + t + t.length());
			if(t.equals(a))
				aIndex = i;
			if(t.equals(b))
				bIndex = i;
			if(aIndex != -1 && bIndex != -1) {
				if(bIndex < aIndex)
					min = -1;
				else
					min = Math.min(min, bIndex - aIndex);
			}
			i++;
		}
		if(aIndex == -1 || bIndex == -1)
			return -1;
		else
			return min;
	}
}
