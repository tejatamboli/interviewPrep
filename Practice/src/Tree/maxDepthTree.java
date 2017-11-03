package Tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class maxDepthTree {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		
		int res = maxDepth(root);
		System.out.println(res);
	}
	
	public static int maxDepth(BinaryTree root) {
		if(root == null)
			return 0;
	     return(1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}
}
