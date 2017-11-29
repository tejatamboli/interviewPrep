package Graph;

import java.util.Arrays;

public class primSpanningTree {
	
	public static void main(String[] args) {
		int V = 5;
		int g[][] = new int[][] {{0, 2, 0, 6, 0},
				   				 {2, 0, 3, 8, 5},
				   				 {0, 3, 0, 0, 7},
				   				 {6, 8, 0, 0, 9},
				   				 {0, 5, 7, 9, 0},
               	  				};
		prims(g,V);
	}
	
	public static int minKey(int key[], boolean mst[], int V) {
		int min = Integer.MAX_VALUE; 
		int min_index = -1;
		
		for(int v = 0; v < V; v++) {
			if(mst[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
		
	}
	
	public static void printMST(int parent[], int g[][], int V) {
		for(int i = 1; i < V; i++) {
			int v = parent[i];
			System.out.println(v + " - " + i + " " + g[i][v]);
		}
	}
	
	public static void prims(int[][] g, int V) {
		int parent[] = new int[V];
		int key[] = new int[V];
		boolean mst[] = new boolean[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0] = 0;
		parent[0] = -1;
		
		for(int i = 0; i < V-1; i++) {
			int u = minKey(key, mst, V);
			mst[u] = true;
			for(int v = 0; v < V; v++) {
				if(g[u][v] != 0 && mst[v] == false && g[u][v] < key[v]) {
					parent[v] = u;
					key[v] = g[u][v];
				}
			}
		}
		printMST(parent, g, V);
	}

}
