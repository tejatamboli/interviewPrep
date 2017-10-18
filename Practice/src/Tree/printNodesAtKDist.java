package Tree;

public class printNodesAtKDist {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(20);
		root.left = new BinaryTree(8);
		root.right = new BinaryTree(22);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(12);
		root.left.right.left = new BinaryTree(10);
		root.left.right.right = new BinaryTree(14);
		int k = 3;
		BinaryTree target = root.left.right.right;
		printNodesAtKDistance(root, target, k);
	}
	
	public static int printNodesAtKDistance(BinaryTree root, BinaryTree target, int k) {
		if(root == null)
			return -1;
		if(root.data == target.data) {
			searchInSubtree(root, k);
			return 0;
		}
		int dl = printNodesAtKDistance(root.left, target, k);
		/* Node found in left subtree */
		if(dl != -1) {
			if(dl+1 == k)
				System.out.println(root.data);
			else
				searchInSubtree(root.right, k-dl-2);
			return (dl+1);
		}
		
		int dr = printNodesAtKDistance(root.right, target, k);
		if(dr != -1) {
			if(dr+1 == k)
				System.out.println(root.data);
			else
				searchInSubtree(root.left, k-dr-2);
			return (dr+1);
		}
		return -1;
	}
	
	public static void searchInSubtree(BinaryTree root, int k) {
		if(root == null || k < 0)
			return;
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		searchInSubtree(root.left, k-1);
		searchInSubtree(root.right, k-1);
	}	
}
