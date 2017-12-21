package Tree;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/invert-binary-tree/discuss/
 * Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class invertTree {
	
	    public BinaryTree invertTreeRec(BinaryTree root) {
	        if(root == null)
	            return null;
	        final BinaryTree left = root.left;
	        final BinaryTree right = root.right;
	        root.left = invertTreeRec(right);
	        root.right = invertTreeRec(left);
	        return root;
	    }
	
	    public BinaryTree invertTreeIter(BinaryTree root) {
	    		if (root == null) {
	            return null;
	        }

	        Queue<BinaryTree> queue = new LinkedList<>();
	        queue.offer(root);

	        while(!queue.isEmpty()) {
	            BinaryTree node = queue.poll();
	            BinaryTree temp = node.left;
	            node.left = node.right;
	            node.right = temp;

	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        return root;
	    	
	    }
}
