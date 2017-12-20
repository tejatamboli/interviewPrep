package Graph;

import java.util.*;

public class alienDictionary {
	public static void printOrder(String[] words, int n, int alphabet) {
		G1 g = new G1(alphabet);
		for(int i = 0; i < n-1; i++) {
			String word1 = words[i]; 
			String word2 = words[i+1];
			for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if(word1.toCharArray()[j] != word2.toCharArray()[j]) {
					g.edge.get(word1.toCharArray()[j]-'a').add(word2.toCharArray()[j]-'a');
					break;
				}
			}
		}
		topologicalSort(g);
	}
	
	public static void topologicalSort(G1 g) {
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[g.V];
		
		for(int i = 0; i < g.V; i++) {
			if(visited[i] == false)
				topologicalSortUtil(i, visited, s, g);
		}
		
		while(!s.isEmpty()) {
			System.out.println(" " + (char)('a' + s.pop()));
		}	
	}
	
	public static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> s, G1 g) {
		visited[v] = true;
		
		for(int i = 0; i < g.edge.get(v).size(); i++) {
			if(!visited[g.edge.get(v).get(i)]) {
				topologicalSortUtil(g.edge.get(v).get(i), visited, s, g);
			}
		}
		s.push(v);	
	}
	
	public static void main(String[] args) {
		String[] words = {"caa", "aaa", "aab"};
		// n = size of the words array
		//alphabet = max size of each word in the array
		printOrder(words, 3, 3);
	}

}
