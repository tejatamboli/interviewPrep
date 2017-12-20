package Graph;

import java.util.*;

public class GraphNode {
	public String name;
	public ArrayList<GraphNode> neighbors;
	int label;
	public GraphNode(String name) {
		this.name = name;
		this.neighbors = new ArrayList<GraphNode>();
	}
	
	public GraphNode(int label) {
		this.label = label;
		this.neighbors = new ArrayList<GraphNode>();
	}

}
