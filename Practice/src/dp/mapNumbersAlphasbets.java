package dp;

import java.util.*;

//With the given mapping in hashmap, find the number of ways to decode the number num

public class mapNumbersAlphasbets {
	
	public static void main(String[] args) {
		Map<Integer, Character>m1 = new HashMap<>();
		m1.put(21, 'a');
		m1.put(2, 'b');
		m1.put(54, 'c');
		m1.put(5, 'd');
		m1.put(4, 'e');
		m1.put(1, 'f');
		String num = "2154";
		System.out.println("2154 ways: " + getWays(m1, num));
	}
	
	public static int getWays(Map<Integer, Character>m1, String num) {
		int[] table = new int[num.length()+1];
		char[] numArr = num.toCharArray();
		int n = num.length();
		table[0] = 1;
		table[1] = 1;
		for(int i = 2; i <= n; i++) {
			table[i] = 0;
			System.out.println("Considering: " + numArr[i-2] + numArr[i-1]);
			int s = Integer.valueOf(num.substring(i-1, i));
			if(m1.get(s) != null)
				table[i] = table[i-1];
			s = Integer.valueOf(num.substring(i-2, i));
			if (m1.get(s) != null)
				table[i] += table[i-2];
			System.out.println("i: " + i + " table: " + table[i]);
			
		}
		return table[n];
		
	}

}
/*
bfde
bfc
ade
ac*/

