package String;

public class smallestWindowWithAllString {
	public static void main(String[] args) {
		String str = "this is a test string";
		String pat = "tist";
		
		System.out.println("String is : " + findWindow(str, pat));
	}
	
	public static String findWindow(String str, String pat) {
		char[] strArr = str.toCharArray();
		char[] patArr = pat.toCharArray();
		int count = 0;
		
		int[] hash_str = new int[256];
		int[] hash_pat = new int[256];
		
		for(int i = 0; i < patArr.length; i++) 
			hash_pat[patArr[i]]++;
		
		int start = 0;
		int start_index = -1;
		int min_len = Integer.MAX_VALUE;
		for(int i = 0; i < strArr.length; i++) {
			hash_str[strArr[i]]++;
			
			if(hash_pat[strArr[i]] != 0 && hash_str[strArr[i]] <= hash_pat[strArr[i]]) 
				count++;
		
			if(count == patArr.length) {		
				while(hash_str[strArr[start]] > hash_pat[strArr[start]] || 
						hash_pat[strArr[start]] == 0) {
					if(hash_str[strArr[start]] > hash_pat[strArr[start]])
						hash_str[strArr[start]]--;
					start++;
				}
					
				int len = i - start + 1;
				if(len < min_len) {
					min_len = len;
					start_index = start;
				}
			}
		}
		
		if(start_index == -1) {
			System.out.println("No such key");
			return "";
		}
		
		int total_len = (start_index + min_len);
		System.out.println("index: " + start_index + " min_len: " + total_len);
		return str.substring(start_index, start_index + min_len);
	}

}
