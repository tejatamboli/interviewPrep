package HashMap;


/* Design data structure to implement T9 dictionary -> Trie */
/*It is based on phone the way you press numbers it should print all possible words*/

public class T9Dictionary {
	
	public static String[] hashtable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		int[] number = {2,4,3};
		int n = number.length;
		printWords(number, n);
	}
	
	public static void printWords(int number[], int n) {
		char[] result = new char[n];
		printWordsUtil(result, 0, number, n);
	}
	
	public static void printWordsUtil(char result[], int c_i, int number[], int n) {
		if(c_i == n) {
			System.out.println("Str: " + String.valueOf(result));
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
