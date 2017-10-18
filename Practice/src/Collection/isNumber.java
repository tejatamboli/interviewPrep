package Collection;

public class isNumber {
	
	public static void main(String[] args) {
		String num = "-3.0123";
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
