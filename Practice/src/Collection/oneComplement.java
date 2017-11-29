package Collection;

//one compolement is just make 0 to 1 and 1 to 0
//two compolement is one complement + 1

public class oneComplement {
	public static void main(String[] args) {
		String num = "1100";
		printOneTwoComplement(num);
	}	
	public static void printOneTwoComplement(String num) {
		int i;
		char[] numArr = num.toCharArray();
		char[] ones = new char[numArr.length];
		for(i = 0; i < numArr.length; i++) {
			if(numArr[i] == '1')
				ones[i] = '0';
			else if(numArr[i] == '0')
				ones[i] = '1';
		}
		char[] twos = new char[numArr.length+1];
		for(i = ones.length-1; i >= 0; i--) 
			twos[i] = ones[i];
		
		for(i = ones.length-1; i >= 0; i--) {
			if(ones[i] == '1')
				twos[i] = '0';
			else {
				twos[i] = '1';
				break;
		    }
		}
		if(i == -1)
			twos[0] = '1';
		else
			twos[0] = '0';
		
		System.out.println("One Complement: " + String.valueOf(ones));
		System.out.println("Two Complement: " + String.valueOf(twos));
	}
}
