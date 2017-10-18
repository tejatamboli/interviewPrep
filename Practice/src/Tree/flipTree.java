package Tree;

public class flipTree {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.left.left.left = new BinaryTree(6);
		root.left.left.right= new BinaryTree(7);
		
		BinaryTree newRoot = flipAllNodesIter(root);
		printLevelByLevel pl = new printLevelByLevel();
		pl.printLevel(newRoot);
	}
	
	public static BinaryTree flipAllNodes(BinaryTree root) {
		if (root == null)
			return null;
		if ((root.left == null) && (root.right == null))
			return root;
		BinaryTree newRoot = flipAllNodes(root.left);
		
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		
		return newRoot;	
	}
	
	public static BinaryTree flipAllNodesIter(BinaryTree root) {
		if(root == null)
			return null;
		
		BinaryTree parent = null;
		BinaryTree parentRightChild = null;
		BinaryTree p = root;
		
		while(p != null) {
			BinaryTree next = p.left;
			p.left = parentRightChild;
			parentRightChild = p.right;
			p.right = parent;
			
			parent = p;
			p = next;
		}
		return parent;			
	}
}
