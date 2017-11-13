package Graph;

import java.util.Arrays;

public class dijakstra {
	
	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
           
           getDijakstra(graph, graph.length, 0);
		
	}
	
	public static void getDijakstra(int[][] g, int V, int src) {
		int[] dist = new int[V];
		boolean[] mstSet = new boolean[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		for(int i = 0; i < V-1; i++) {
			int u = minDist(dist, mstSet);
			mstSet[u] = true;
			
			for(int v = 0; v < V; v++) {
				if(!mstSet[v] && g[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + g[u][v] < dist[v]) {
					dist[v] = g[u][v] + dist[u];
					
				}
			}
		}
		printSol(dist);
	}
	
	public static int minDist(int[] dist, boolean[] mstSet) {
		int min_index = -1, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < dist.length; i++) {
			if(!mstSet[i] && dist[i] < min) {
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	public static void printSol(int[] dist) {
		for(int i = 0; i < dist.length; i++)
			System.out.println("i: " + i + " = " + dist[i]);
	}

}
