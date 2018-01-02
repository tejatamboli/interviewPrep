package Tree;

/* Leetcode:https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */

public class flattenTreetoDLL {
	    BinaryTree prev = null;
	    public void flatten(BinaryTree root) {
	        if(root == null)
	            return;
	        flatten(root.right);
	        flatten(root.left);
	        root.right = prev;
	        root.left = null;
	        prev = root;
	    }
}
