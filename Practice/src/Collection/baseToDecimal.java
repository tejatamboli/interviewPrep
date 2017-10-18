package Collection;

public class baseToDecimal {
	public static void main(String[] args) {
		String s = "11A";
		int base = 16;
		System.out.println(getNumber(s, base));
	}
	
	public static int getVal(char c) {
		if (c >= '0' && c <= '9')
			return (int)(c-'0');
		else
			return (int)(c-'A'+10);
	}
	
	public static int getNumber(String s, int b) {
		int power = 1;
		int num = 0;
		char[] arr = s.toCharArray(); 
		
		for(int i = s.length()-1; i >= 0; i--) {
			if (getVal(arr[i]) >= b) {
				return -1;
			}
			num = num + getVal(arr[i]) * power;
			power = b * power;
		}
		return num;
	}
}
//Decimal Equivalent is,
//1*str[len-1] + base*str[len-2] + (base)2*str[len-3] + ...