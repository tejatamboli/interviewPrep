package HashMap;

import java.util.*;

public class wordLadder {
	public static void main(String[] args) {
		Set<String> D = new HashSet<>();
		D.add("poon");
	    D.add("plee");
	    D.add("same");
	    D.add("poie");
	    D.add("plie");
	    D.add("poin");
	    D.add("plea");
	    String start = "poon";
	    String target = "plea";
	    System.out.println("Len is: " + shortestLen(start, target, D));
	}
	
	public static int shortestLen(String start, String end, Set<String>D) {
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();	
		int len = 1;
		HashSet<String> visited = new HashSet<>();
		beginSet.add(start);
		endSet.add(end);
		
		while(!beginSet.isEmpty() && !endSet.isEmpty()) {
			if(beginSet.size() > endSet.size()) {
				Set<String>set = beginSet;
			    beginSet = endSet;
			    endSet = set;
			    System.out.println("Swapped");
			}
			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && D.contains(target)) {
								temp.add(target);
								System.out.println("\ntarget: " + target);
								visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
			System.out.println("len is set");
			
		}
		return 0;
	}
}
