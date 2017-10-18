package String;

import java.util.*;

public class groupAnagramsTogether {
	public static void main(String[] args) {
		String[] input = {"cat", "tac","teaching","deal", "lead","test","cheating"};
		
		String[] res = groupTogether(input);
		for(String s : res)
			System.out.println(s);
	}
	
	public static String[] groupTogether(String[] input) {
		Map<String, List<String>>ans = new HashMap<String, List<String>>();
		for(String s: input) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if(ans.containsKey(key))
				ans.get(key).add(s);
			else {
				ans.put(key, new ArrayList<String>());
				ans.get(key).add(s);
			}
		}	
		
		List<String> res = new ArrayList<String>();
		for(List<String> l1 : ans.values()) {
			if(l1.size() == 1)
				continue;
			Collections.sort(l1);
			res.add(String.join(" ", l1));
		}
		Collections.sort(res);
		String[] arr = new String[res.size()];
		return res.toArray(arr);
	}
}
