package Tree;

import java.util.*;

public class buildTreeParentChild {
	public static void main(String[] args) {
		List<Relation> l1 = new ArrayList<>();
		l1.add(new Relation(15, 20, true));
		l1.add(new Relation(19, 80, true));
		l1.add(new Relation(17, 20, false));
		l1.add(new Relation(16, 80, false));
		l1.add(new Relation(80, 50, false));
		l1.add(new Relation(50, -1, false));
		l1.add(new Relation(20, 50, true));
		
		BinaryTree root = buildTree(l1);
		printLevelByLevel pl = new printLevelByLevel();
		pl.printLevel(root);
	}
	
	public static BinaryTree buildTree(List<Relation> l1) {
		
		Map<Integer, BinaryTree> m1 = new HashMap<>();
		BinaryTree root = null;
		
		for(Relation r: l1) {
			BinaryTree parent = null, child = null;
			System.out.println("c:"+r.child+"p:"+r.parent+"isLeft:"+r.isLeft);
			
			if ((child = m1.get(r.child)) == null) {
				child = new BinaryTree(r.child);
				m1.put(r.child, child);
			} 
			if (r.parent == -1) {
				root = child;
				continue;
			} 
			if ((parent = m1.get(r.parent)) == null) {
				parent = new BinaryTree(r.parent);
				m1.put(r.parent, parent);
			} 
			if (r.isLeft) 
				parent.left = child;
			else 
				parent.right = child;
		}
		return root;
	}
}
