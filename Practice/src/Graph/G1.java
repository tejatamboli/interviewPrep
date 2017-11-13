package Graph;

import java.util.*;
public class G1 {
	int V;
	List<List<Integer>> edge;
	
	public G1(int V) {
		this.V = V;
		this.edge = new ArrayList<>();
		for(int i = 0; i < V; i++)
			this.edge.add(new LinkedList<Integer>());
	}

}
