package String;

public class smallUpperComb {	
		/* Write code to generate all possible case combinations of a given lower-cased string. (e.g.
			"0ab" -> ["0ab", "0aB", "0Ab", "0AB"])

		
		private void printAllCombinations(String A,String B){
			if(B.length()==0){
				System.out.println(A);
				return;
			}
			int i =0;
			char c = B.charAt(i++);
			while(!Character.isLetter(c)){
				A+=c;
				c = B.charAt(i++);
			}
			printAllCombinations(A + Character.toLowerCase(c), B.substring(i+1));
			printAllCombinations(A + Character.toUpperCase(c), B.substring(i+1));
		}
	*/


}
