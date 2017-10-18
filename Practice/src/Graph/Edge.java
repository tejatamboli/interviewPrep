package Graph;

public class Edge implements Comparable<Edge>{
	int src, dest, weight; 
	public int compareTo(Edge cEdge) {
		return this.weight-cEdge.weight;
	}
};
