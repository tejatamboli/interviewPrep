package Collection;

import java.util.*;

//from all the input strings find common characters

public class findCommonChars {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		
		l1.add("aghkafgklt");
		l1.add("dfghakoa");
		l1.add("qwemnaarkf");
		
		printCommonChars(l1);
		printComChars(l1);
	}
	
	//To print repeated factor 
	public static void printCommonChars(List<String> l1) {
		Map<Character, Map<Integer, Integer>> m1 = new HashMap<>();
		
		for(int j = 0; j <l1.size(); j++) {
			for(int i = 0; i < l1.get(j).length(); i++) {
				char c = l1.get(j).charAt(i);
				if (m1.containsKey(c)) {
					if (m1.get(c).containsKey(j)) {	
						int val = m1.get(c).get(j);
						m1.get(c).put(j, val+1);
					} else {
						m1.get(c).put(j, 1);
					}
				} else {
					HashMap<Integer, Integer> a1 = new HashMap<Integer, Integer>();
					a1.put(j, 1);
					m1.put(c, a1);
				}
			}	
		}
		Iterator it = m1.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, Map<Integer, Integer>>pair = (Map.Entry)it.next();
			if (pair.getValue().size() == l1.size()) {
				System.out.print(pair.getKey());
				int cnt = Integer.MAX_VALUE;
				for(int i = 0; i < pair.getValue().size() - 1; i++) {
					int min = Math.min(pair.getValue().get(i), pair.getValue().get(i+1));
					if (min < cnt)
						cnt = min;
				}
				System.out.println(" Repeated : " + cnt);
				
			}			
		}
	}
	
	//To print just common characters
	public static void printComChars(List<String> l1) {
		int[] chars = new int[26];
		for(int i = 0; i < l1.size(); i++) {
			Set<Character> cMap = new HashSet<>();
			for(int j = 0; j < l1.get(i).length(); j++) {
				if(!cMap.contains(l1.get(i).charAt(j))) {
					System.out.println("adding to set: " + l1.get(i).charAt(j));
					cMap.add(l1.get(i).charAt(j));
					chars[l1.get(i).charAt(j) - 'a']++;
				}
			}
		}
		for(int j = 0; j < 26; j++) {
			if (chars[j] == l1.size())
				System.out.println((char)(j+'a'));
		}
	}
}
