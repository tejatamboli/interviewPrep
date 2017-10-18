package Collection;

/*
 * Some facts must be given about roman numerals:
-There are 7 symbols I V X L C D M.
-Each symbol has the following respective integer values 1 5 10 50 100 500 1000.
-The symbols in a roman string are summed in a special way such that the string matches the value known.

Using the information above we can work out a few examples that show us how the value of a roman string is calculated.
Ex 1. LXXXVI =86 this can be expanded into the sum 1 + 5 +10 +10 + 10 + 50.
Ex 2. MDCC =1700 =100 + 100 + 500 + 1000.
Ex 3. IV =4 = 5 + (-1).

Strategy:
Starting from the last symbol of the roman string we add to the total.
Then we go to the next symbol to the left. 
If the value of this symbol is smaller than the last symbol we looked at let us subtract it otherwise add it to the total.
Continue onto process symbols like this until we have processed the first symbol of the roman string.
 */
public class romanToInteger {
	
	public static void main(String[] args) {
		String roman = "LXXXVI";
		System.out.println("Value is : " + romtoint(roman));
	}
	
	public static int romtoint(String roman) {
		int currVal = 0, lastVal = 0, total = 0;
		
		for(int i = roman.length()-1; i >= 0; i--) {
			switch(roman.charAt(i)) {
				case 'I': currVal = 1;
						  break;
				case 'V': currVal = 5;
				  		  break;
				case 'X': currVal = 10;
				          break;
				case 'L': currVal = 50;
				          break;
				case 'C': currVal = 100;
				          break;
				case 'D': currVal = 500;
				  		  break;
				case 'M': currVal = 1000;
				  		  break;
			}		
			total += (currVal < lastVal) ? (-1 * currVal) : currVal;
			lastVal = currVal;
		}		
		return total;
	}
}
