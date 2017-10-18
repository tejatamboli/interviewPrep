package Graph;

import java.util.Arrays;

public class KruskalSpanningTree {
	
	public static void main(String[] args) {
		int V = 9;
		int E = 14;
		G g = new G(V, E);
		
		g.edge[0].src = 7;
		g.edge[0].dest = 6;
		g.edge[0].weight = 1;

		// add edge 0-2
		g.edge[1].src = 8;
		g.edge[1].dest = 2;
		g.edge[1].weight = 2;

		// add edge 0-3
		g.edge[2].src = 6;
		g.edge[2].dest = 5;
		g.edge[2].weight = 2;

		// add edge 1-3
		g.edge[3].src = 0;
		g.edge[3].dest = 1;
		g.edge[3].weight = 4;

		// add edge 2-3
		g.edge[4].src = 2;
		g.edge[4].dest = 5;
		g.edge[4].weight = 4;

		g.edge[5].src = 8;
		g.edge[5].dest = 6;
		g.edge[5].weight = 6;
	   
	    g.edge[6].src = 2;
		g.edge[6].dest = 3;
		g.edge[6].weight = 7;
	    
	    g.edge[7].src = 7;
		g.edge[7].dest = 8;
		g.edge[7].weight = 7;
	    
	    g.edge[8].src = 0;
		g.edge[8].dest = 7;
		g.edge[8].weight = 8;
    
        g.edge[9].src = 1;
		g.edge[9].dest = 2;
		g.edge[9].weight = 8;
        
        g.edge[10].src = 3;
		g.edge[10].dest = 4;
		g.edge[10].weight = 9;
        
        g.edge[11].src = 5;
		g.edge[11].dest = 4;
		g.edge[11].weight = 10; 
        
        g.edge[12].src = 1;
		g.edge[12].dest = 7;
		g.edge[12].weight = 11;
    
        g.edge[13].src = 3;
		g.edge[13].dest = 5;
		g.edge[13].weight = 14;
		
		minSpanTree(g, V, E);
	}
	
	public static int find(Subset subset[], int i) {
		if(subset[i].parent != i) 
			return find(subset, subset[i].parent);
		return subset[i].parent;
	}
	
	public static void union(Subset subset[], int x, int y) {
		int xroot = find(subset,x);
		int yroot = find(subset,y);
		
		if(subset[xroot].rank < subset[yroot].rank) 
			subset[xroot].parent = yroot;
		else if(subset[yroot].rank < subset[xroot].rank)
			subset[yroot].parent = xroot;
		else {
			subset[xroot].parent = yroot;
			subset[yroot].rank++;
		}
		
	}

	public static void minSpanTree(G g, int V, int E) {
		
		Edge result[] = new Edge[V];
		Subset subset[] = new Subset[V];
		for(int i = 0; i < V; i++) {
			result[i] = new Edge();
			subset[i] = new Subset();
		}
		
		Arrays.sort(g.edge);
		for(int i = 0; i < V; i++) {
			subset[i].parent = i;
			subset[i].rank = 0;
		}
		
		int e = 0;
		int index = 0;
		while(index < V-1) {
			Edge next = new Edge();
			next = g.edge[e++];
			
			int x = find(subset, next.src);
			int y = find(subset, next.dest);
			
			if(x != y) {
				result[index++] = next;
				union(subset, x, y);
			}
		}		
		System.out.println("result is:");
		for(int i = 0; i < index; i++) {
			System.out.println(result[i].src + " " + result[i].dest + " " + result[i].weight);
		}
	}
}
