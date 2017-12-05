package Tree;

/* Leetcode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/
 * 
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */

public class nextRight {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        root.next = null;
        connectRecur(root);
    }
    
    public void connectRecur(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            root.right.next = (root.next != null) ? root.next.left : null;
        }
        connectRecur(root.left);
        connectRecur(root.right);
    }

}
