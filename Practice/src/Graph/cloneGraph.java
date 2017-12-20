package Graph;
import java.util.*;

public class cloneGraph {
	
	public static Map<Integer,GraphNode> cloneGraphDFS(Map<Integer, GraphNode> inputG)
    {
		System.out.println("Graph is :");
	    printGraph(inputG);

	    Map<Integer, GraphNode> result = new HashMap<Integer, GraphNode>();
	    Iterator<GraphNode> it = inputG.values().iterator();
	    Map<GraphNode, GraphNode> visitedMap = new HashMap<>();
	    
	    while (it.hasNext()) {
	        GraphNode currentNode = it.next();
	        GraphNode clonedNode = dfsCopy(currentNode, visitedMap);
	        result.put(clonedNode.label, clonedNode);
	    }
	    
	    System.out.println("Cloned Graph is :");
	    printGraph(result);

	    return result;
    }
	
	public static void printGraph(Map<Integer, GraphNode> result) {
	    for (Map.Entry<Integer, GraphNode> e : result.entrySet()) {
	      int key = e.getKey();
	      GraphNode value = e.getValue();
	      System.out.print(key + "=> ");
	      for (GraphNode u : value.neighbors) {
	        System.out.print(u.label + " ");
	      }
	      System.out.println();
	   }
	}
	
	public static GraphNode dfsCopy(GraphNode node, Map<GraphNode, GraphNode> visited) {
	    if (visited.containsKey(node)) {
	    		return visited.get(node);
	    }
	    GraphNode copy = new GraphNode(node.label);
	    visited.put(node, copy);
	    for (int i = 0; i < node.neighbors.size(); i++) {
	    		copy.neighbors.add(dfsCopy(node.neighbors.get(i), visited));
	    }
	    return copy;
    }
}
