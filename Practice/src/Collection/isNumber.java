package Collection;

//check if the string is a valid number

public class isNumber {
	
	public static void main(String[] args) {
		//String num = "-3.0123";
		String num = ".";
		System.out.println("num: " + num + " is number: " + isNumber(num));
	}
	
	public static boolean isNumber(String num) {
		num = num.trim();
		boolean signed = false;
		boolean started = false;
		boolean dotted = false;
		
		for(char c: num.toCharArray()) {
			if ((c == '+') || (c == '-')) {
				if (signed || started || dotted)
					return false;
				else
					signed = true;
			} else if ((c >= '0') && (c <= '9')) {
				started = true;
			} else if (c == '.') {
				if(dotted)
					return false;
				else
					dotted = true;
			} else
				return false;
		}
		return true;
	}	
}


/* Leetcode solution */
/*
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s == null || s.length() == 0)
            return false;
        
        if(s.equals("."))
            return false;
        
        boolean sign = false;
        boolean decimal = false;
        boolean number = false;
        boolean eseen = false;
        boolean numberAfterE = false;
        boolean signPositive = false;
        
        for(int i = 0; i < s.length(); i++) {
        //sign can come at the start or immediately after e
            if((s.charAt(i) == '-') || (s.charAt(i) == '+')) {
                if(eseen && ((number && !numberAfterE) || decimal)) {
                        sign = true;
                }
                else if(number || eseen || numberAfterE || decimal) {
                    return false;
                } 
                sign = true;
            }
            else if(s.charAt(i) == '.') {
                if(decimal || eseen)
                    return false;
                decimal = true;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                number = true;
                numberAfterE = true;
            } else if(s.charAt(i) == 'e') {    //there should be some number after e and before e
                if(eseen || !number || i == s.length()-1)
                    return false;
                eseen = true;
                numberAfterE = false;
            } else
                return false;
        }
        return number && numberAfterE;       
    }
}
*/