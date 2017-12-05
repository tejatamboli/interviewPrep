package Collection;
/* Leetcode: https://leetcode.com/problems/excel-sheet-column-title/description/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 * 
 * convertToTitle
 */

public class excelSheetColumn {
	public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}

/* Leetcode: https://leetcode.com/problems/excel-sheet-column-number/description/
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    
public int titleToNumber(String s) {
    int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
  }
  
*/
