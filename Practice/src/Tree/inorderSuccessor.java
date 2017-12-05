package Tree;

/* Leetcode: https://leetcode.com/problems/inorder-successor-in-bst/description/
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */

public class inorderSuccessor {
	
	    public BinaryTree inorderSuccessor(BinaryTree root, BinaryTree p) {
	        if(p.right != null) {
	            return minValue(p.right);
	        }
	        BinaryTree curr = root, succ = null;
	        while(curr != null) {
	            if(p.data < curr.data) {
	                succ = curr;
	                curr = curr.left;
	            } else if(p.data > curr.data)
	                curr = curr.right;
	            else
	                break;
	        }
	        return succ;
	    }
	    public BinaryTree minValue(BinaryTree curr) {
	        while(curr.left != null)
	            curr = curr.left;
	        return curr;
	    }
}
