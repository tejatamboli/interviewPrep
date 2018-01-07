package String;
import java.util.*;

/*Given string say ABCGRETCABCG and substring length let us take length as 3, find the count of possible substrings,
 *  for example in above string ABC => 2 and BCG => 2 , where CGR and other 3 word length substrings has a count of 1.
 */

public class subStringFreq {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String input="ABCGRETCABCG";
			int n = 3;
			
			Map<String,Integer> substrMap=new HashMap<String,Integer>();
			
			for(int i=0;i+n<=input.length();i++){
				
				String substr=input.substring(i, i+n);
				
				int frequency=1;
				
				if(substrMap.containsKey(substr)){
					
					frequency=substrMap.get(substr);
					frequency++;
				}
				
				substrMap.put(substr, frequency);
				
				
			}
			System.out.println(substrMap.toString());
		}

}
