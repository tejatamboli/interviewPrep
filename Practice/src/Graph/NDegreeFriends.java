package Graph;

import java.util.*;
//SalesForce

public class NDegreeFriends {
	
	public static List<String> getFriends(String person, Map<String, GraphNode> graph, int N) {
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		List<String> friendNames = new LinkedList<>();
		if(!graph.containsKey(person))
			return friendNames;
		q.add(graph.get(person));
		int qSize = q.size();
		Set<String> s = new HashSet<String>();
		int degree = 0;
		s.add(person);
		while(qSize > 0) {
			for(int i = 0; i < qSize; i++) {
				GraphNode curr = q.poll();
				Iterator<GraphNode> it = curr.neighbors.iterator();
				while(it.hasNext()) {
					GraphNode t = it.next();
					System.out.println("hashSet: " + t.name);
					if(!s.contains(t.name)) {
						friendNames.add(t.name);
						q.add(t);
						s.add(t.name);
					}
				}
			}
			qSize = q.size();
			degree = degree+1;
			if(degree == N) {
				break;
			}
		}
		return friendNames;
	}
	
	public static void main(String args[]) {
		Map<String, GraphNode> graph = new HashMap<String, GraphNode>();
		GraphNode g = new GraphNode("Peter");
		GraphNode g1 = new GraphNode("John");
		GraphNode g2 = new GraphNode("Sam");
		GraphNode g3 = new GraphNode("Martin");
		GraphNode g4 = new GraphNode("Martin2");
		GraphNode g5 = new GraphNode("Martin3");
		g.neighbors.add(g1);
		g.neighbors.add(g2);
		g1.neighbors.add(g3);
		g1.neighbors.add(g4);
		g2.neighbors.add(g4);
		g2.neighbors.add(g5);
		g3.neighbors.add(g);
		g4.neighbors.add(g5);
		g5.neighbors.add(g);
		
		graph.put("Peter", g);
		graph.put("John", g1);
		graph.put("Sam", g2);
		graph.put("Martin", g3);
		graph.put("Martin2", g4);
		graph.put("Martin3", g5);
		
		for(String n: getFriends("Peter", graph, 3)) {
			System.out.println(n);
			
		}		
//		g - g1 - g3, g4
//		  - g2 - g4, g5
//  Peter - John - Martin - Peter
//				 - Martin2 - Martin3
//		  - Sam  - Martin2, 
//		  		 - Martin3 - Peter		
	}
}
