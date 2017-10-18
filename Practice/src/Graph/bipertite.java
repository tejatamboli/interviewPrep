package Graph;

import java.util.*;

public class bipertite {
	public static void main(String[] args) {
		int[][] a = {{0,1,0,1},{1,0,1,0},{0,1,0,1},{1,0,1,0}};
		System.out.println(isBipertite(a, 1, 4));
	}
	
	public static boolean isBipertite(int[][]a, int src, int V) {
		int[] colorArr = new int[V];
		Queue<Integer>q = new LinkedList<Integer>();
		colorArr[src] = 1;
		q.add(src); 
		while(!q.isEmpty()) {
			int u = q.remove();
			if(a[u][u] == 1)
				return false;
			for(int v = 0; v < V; v++) {
				if((a[u][v] == 1) && (colorArr[v] == -1)) {
					colorArr[v] = 1 - colorArr[u];
					q.add(v);
				} else if((a[u][v] == 1) && (colorArr[u] == colorArr[v]))
					return false;
			}
		}
		for(int v = 0; v < V; v++) {
			System.out.println("v: " + colorArr[v]);
		}
		return true;
	}
}
