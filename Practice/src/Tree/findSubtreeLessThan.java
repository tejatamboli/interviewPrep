package Tree;

/* Intel
 * Given number find out if the tree has all numbers less than N
 * This can be done easily by doing BFS and if number at any time is greater than N 
 * return false else return true
 * Follow Up: Return the subtree of the binary tree which has all elements less then N
 * if both children are like that then return the subtree which has max number of elements.
 */

class MyNode {
	int data;
	MyNode left;
	MyNode right;
	int max;
	
	public MyNode(int d) {
		this.data = d;
		this.max = 0;
		this.left = null;
		this.right = null;
	}
}
//build the tree with max number in the bottom to up approach
public class findSubtreeLessThan {
	public static void getTheNode(MyNode root) {
		if(root == null)
			return;
		getTheNode(root.left);
		getTheNode(root.right);
		if(root.left == null && root.right == null) {
			root.max = root.data;
			//return;
		} else if(root.left != null && root.right != null) {
			int max = Math.max(root.left.max, root.right.max);
			root.max = Math.max(root.data, max);
			//return;
		} else if(root.left == null && root.right != null) {
			root.max = Math.max(root.data, root.right.max);
			//return;
		} else if(root.left != null && root.right == null) {
			root.max = Math.max(root.data, root.left.max);
			//return;
		}	
		System.out.println("root: " + root.data + " max: " + root.max);
	}
	
	public static void main(String[] args) {
		MyNode root = new MyNode(1);
		root.left = new MyNode(2);
		root.right = new MyNode(3);
		root.left.left = new MyNode(4);
		root.left.right = new MyNode(5);
		root.left.left.left = new MyNode(6);
		root.left.left.right= new MyNode(7);
		getTheNode(root);
		inorder(root);
	}
	
	public static void inorder(MyNode root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.println(root.data + " max: " + root.max);
		inorder(root.right);
	}	
	
	//write a function and do BFS and check this max number of root, root.left and root.right
}

/*     1
    2     3
  4   5  
 6 7

*/