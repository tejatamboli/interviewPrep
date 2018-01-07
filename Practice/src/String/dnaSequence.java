package String;
import java.util.*;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class dnaSequence {
	    public List<String> findRepeatedDnaSequences(String s) {
	        Set<String>seenDNA = new HashSet<>();
	        Set<String>repeatedDNA = new HashSet<>();
	        
	        for(int i = 0; i + 9 < s.length(); i++) {
	            String ten = s.substring(i, i+10);
	            if(!seenDNA.add(ten)) {
	                repeatedDNA.add(ten);
	            }
	        }
	        return new ArrayList<String>(repeatedDNA);        
	    }
}
