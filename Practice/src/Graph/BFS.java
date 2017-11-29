package Graph;

import java.util.*;

public class BFS {
	
	private static int V;
	private static LinkedList<Integer> adj[];
	
	public BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList();
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public static void main(String[] args) {
		BFS g = new BFS(4);
		g.addEdge(0,1);
		g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        traverse_breadthwise(2);
	}
	
	public static void traverse_breadthwise(int src) {
		boolean visited[] = new boolean[V];
		
		List<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src] = true;
		while(!q.isEmpty()) {
			int s = q.remove(0);
			System.out.println(s + " ");
			
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext()) {
				int n = i.next();
				if(visited[n] == false) {
					visited[n] = true;
					q.add(n);
				}
			}
		}		
	}
}
