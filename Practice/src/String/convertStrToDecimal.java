package String;

/* LinkedIn careercup
 * Convert a character string into a value based on the radix or base. 
Input parameters: 
1. char *str such as "3523" (in decimal), 
"11001" (in binary), 
"a1f38c" (in hex) 
2. radix or base(such as decimal:10, binary:2, hex:16, octal:8) 

Return: integer value (not unsigned) that is calculated based on the input string and radix or base. 

for example: string is "343432" (base 10): return value 343432 
string is "10010" (base 2): return value is 18 
string is "a1b" (base 16): return value is 187. 
Tell the algo and write a program?


 */

public class convertStrToDecimal {
	public static int convert(String str, int base){ 
		int value = 0; 
		int basePower = 1; 
		// assuming value supplied in str belongs to base 
		int length = str.length(); 
		for(int i = length-1; i >= 0; i++){ 
			if(i == 0 && str.charAt(i) == '-'){ 
				value *= -1; 
				continue; 
			} 
			value += (str.charAt(i) - '0')*basePower; // this would have worked if digits were // followed by alphabets in ASCII table 
			basePower *= base; 
		} 
		return value; 
		}
}
