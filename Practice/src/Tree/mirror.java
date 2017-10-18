package Tree;

public class mirror {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.left.left.left = new BinaryTree(6);
		root.left.left.right= new BinaryTree(7);
		printLevelByLevel pl = new printLevelByLevel();
		pl.printLevel(root);
		BinaryTree newRoot = mirrorTree(root);
		pl.printLevel(newRoot);
	}
	
	public static BinaryTree mirrorTree(BinaryTree root) {
		if(root == null)
			return null;
		if(root.left == null && root.right == null) {
			return root;
		}
		BinaryTree temp = root.left;
		root.left = root.right;
		root.right = temp;	
		mirrorTree(root.left);
		mirrorTree(root.right);
		
		return root;
	}
}
