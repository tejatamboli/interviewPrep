package HashMap;

import java.util.Arrays;

/* Design data structure to implement T9 dictionary -> Trie */

public class T9Dictionary {
	
	public static String[] hashtable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		int[] number = {2,4,3};
		int n = number.length;
		printWords(number, n);
	}
	
	public static void printWords(int number[], int n) {
		char[] result = new char[n+1];
		result[n] = '\0';
		printWordsUtil(result, 0, number, n);
	}
	
	public static void printWordsUtil(char result[], int c_i, int number[], int n) {
		if(c_i == n) {
			System.out.println("Str: " + Arrays.toString(result));
			return;
		}
		
		/*for(int i = 0; i < hashtable[number[c_i]].length(); i++) {
			result[c_i] = hashtable[number[c_i]].charAt(i);
			printWordsUtil(result, c_i+1, number, n);
			if(number[c_i] == 0 || number[c_i] == 1)
				return;
		}*/
		for(int i = 0; i < hashtable[number[c_i]].length(); i++) {
			result[c_i] = hashtable[number[c_i]].charAt(i);
			printWordsUtil(result, c_i+1, number, n);
		}
		if(number[c_i] == 0 || number[c_i] == 1) {
			printWordsUtil(result, c_i+1, number, n);
		}	
	}
}
