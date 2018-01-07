package String;

import java.util.Arrays;

/*
 * Find and replace a sequence in a string
 */

public class findReplaceString {
	public static void main(String[] args) {
		String s = "abcdefghabcdefgh";
		String f = "de";
		String r = "xyz";
		String newStr = findReplace(s,f,r);
		System.out.println("NewStr: " + newStr);
		System.out.println("NewStr len: " + newStr.length());
	}
	
	public static int findStr(char[] sArr, char[] fArr) {
		int cnt = 0;
		for(int i = 0; i < sArr.length; i++) {
			int j = 0;
			for(j = 0; j < fArr.length; j++) {
				if(sArr[i+j] != fArr[j])
					break;
			}
			if(j == fArr.length) {
				cnt++; 
				i = i + fArr.length - 1;
			} 
		}
		return cnt;
	}
	
	public static String findReplace(String s, String f, String r) {
		char[] sArr = s.toCharArray();
		char[] fArr = f.toCharArray();
		char[] rArr = r.toCharArray();
		
		int cnt = findStr(sArr, fArr);
		System.out.println("cnt: " + cnt);
		char[] newArr = Arrays.copyOf(sArr, sArr.length+cnt*Math.abs(f.length()-r.length()));
		
		int j = newArr.length-1;
		for(int i = sArr.length-1; i >= 0; i--) {
			int k; int l = 0;
			for(k = fArr.length-1; k >= 0; k--) {
				if(sArr[i-l] != fArr[k])
					break;
				l++;
			}
			if(k == -1) {//reached till end
				for(int m = rArr.length-1; m >= 0; m--) 
					newArr[j--] = rArr[m];  
				i = i - fArr.length + 1;
			} else {
				newArr[j--] = sArr[i];
			}
		}
		return String.valueOf(newArr);
	}
}


/* In-place replace multiple occurrences of a pattern
3.2
Given a string and a pattern, replace multiple occurrences of a pattern by character ‘X’. The conversion should be in-place 
and solution should replace multiple consecutive (and non-overlapping) occurrences of a pattern by a single ‘X’.

// returns true if pattern is prefix of str
bool compare(char* str, char* pattern)
{
    for (int i = 0; pattern[i]; i++)
        if (str[i] != pattern[i])
            return false;
    return true;
}

void replacePattern(char *str, char* pattern)
{
    // If pattern is null or empty string,
    // nothing needs to be done
    if (pattern == NULL)
        return;
 
    int len = strlen(pattern);
    if (len == 0)
       return;
 
    int i = 0, j = 0;
    int count;
 
    // for each character
    while (str[j])
    {
        count = 0;
 
        // compare str[j..j+len] with pattern
        while (compare(str+j, pattern))
        {
            // increment j by length of pattern
            j = j + len;
            count++;
        }
 
        // If single or multiple occurrences of pattern
        // is found, replace it by character 'X'
        if (count > 0)
            str[i++] = 'X';
 
        // copy character at current position j
        // to position i and increment i and j
        if (str[j])
            str[i++] = str[j++];
    }
 
    // add a null character to terminate string
    str[i] = '\0';
}
*/
