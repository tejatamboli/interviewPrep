package Tree;

public class kthLargestElement {
	static int c = 0;
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(50);
		root.left = new BinaryTree(30);
		root.right = new BinaryTree(70);
		root.left.left = new BinaryTree(20);
		root.left.right = new BinaryTree(40);
		root.right.left = new BinaryTree(60);
		root.right.right = new BinaryTree(80);	
	
		for(int i = 1; i < 8; i++) {
			c = 0;
			findKthLargest(root,i);
		}
	}
	
	public static void findKthLargest(BinaryTree root, int k) {
		if((root == null) || (c > k))
			return;
		
		findKthLargest(root.right, k);
		c++;
		if(k == c) {
			System.out.println("k: " + k + " " + root.data);
			return;
		}
		findKthLargest(root.left, k);
	}
}


