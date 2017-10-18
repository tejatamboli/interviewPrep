package Tree;

public class isBST {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(4);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(5);
		root.left.left  = new BinaryTree(1);
		root.left.right = new BinaryTree(3);
		
		System.out.println("isBST: " + isBST(root));
	}
	
	public static boolean isBST(BinaryTree root) {
		return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static boolean isBSTUtil(BinaryTree root, int max, int min) {
		if(root == null)
			return true;
		if(root.data < min || root.data > max)
			return false;
		
		return (isBSTUtil(root.left, root.data-1, min) && 
				isBSTUtil(root.right, max, root.data+1));
					
	}

}
