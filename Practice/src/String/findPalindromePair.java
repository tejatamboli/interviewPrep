package String;

//Airbnb
//Determine whether word is a palindrome and find palindrome pairs within a set of wordsbool isPalindrome(string str)
import java.util.*;

public class findPalindromePair {
	public static boolean isPalindrome(String str) {
		char[] strArr = str.toCharArray();
		int j = str.length()-1;
		int i = 0;
		while(i < j) {
			if(strArr[i] != strArr[j])
				return false;
			i++; j--;
		}
		return true;
	}
	public static boolean getPalindromPair(List<String> l1) {
		for(int i = 0; i < l1.size(); i++) {
			for(int j = i+1; j < l1.size(); j++) {
				String s = l1.get(i) + l1.get(j);
				if(isPalindrome(s))
					return true;
			}	
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<String>l1 = new ArrayList<>();
		l1.add("test");
		l1.add("notest");
		l1.add("ontest");
		l1.add("tset");
		
		System.out.println("Pair found: " + getPalindromPair(l1));
	}
}
