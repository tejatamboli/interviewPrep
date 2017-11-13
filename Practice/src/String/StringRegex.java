package String;

public class StringRegex {
	
	public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int startIndex = -1;
        int iIndex = -1;
        
        while(i < s.length()) {
            if(j < p.length() && ((p.charAt(j) == '?') || (s.charAt(i) == p.charAt(j)))) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                startIndex = j;
                iIndex = i;
                j++;
            } else if(startIndex != -1) {
                j = startIndex + 1;
                i= iIndex + 1;
                iIndex++;
            } else
                return false;
        }
        while (j < p.length() && p.charAt(j) == '*') {
		    ++j;
	    }
 
	    return j == p.length();
    }
	
	public static void main(String[] args) {
		String s1 = "aa"; 
		String s2 = "*";
		System.out.println(s1 + " " + s2 + " are matching?: " + isMatch(s1, s2));
	}

}
