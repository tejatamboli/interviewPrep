package Collection;

import java.util.Arrays;

//two strings are isomorphic if there is exact one to one mapping in the character. Using which you can convert one 
//string into the another

public class isomorphic {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("aab", "xxy"));
	}

	public static boolean isIsomorphic(String a, String b) {
		boolean[] marked = new boolean[256];
		int[] map = new int[256];
		Arrays.fill(map, -1);
		if (a.length() != b.length())
			return false;
		
		for(int i = 0; i < a.length(); i++) {
			if(map[(int)a.charAt(i)] == -1) { //mapping does not exist
				if(marked[(int)b.charAt(i)] == true) //if other character is already mapped marking should be done
					return false;					//for characters from other string and map stores for current string
				marked[(int)b.charAt(i)] = true;
				map[(int)a.charAt(i)] = b.charAt(i); 
			} else if(map[(int)a.charAt(i)] != b.charAt(i))
				return false;
		}
		for(int i = 0; i < 256; i++) {
			if(map[i] != -1)
				System.out.println((char)i + " : " + (char)map[i]);
		}
		return true;
	}
}
