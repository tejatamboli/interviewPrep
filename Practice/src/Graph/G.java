package Graph;

public class G {
	int V;
	int E;
	Edge edge[];
	
	
	G(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
		
	}

}
