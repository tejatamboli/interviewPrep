package Tree;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/subtree-of-another-tree/description/
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.

 */

public class isSubTree {
	    public boolean isSubtree(BinaryTree s, BinaryTree t) {
	        if(s == null)
	            return false;
	        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
	        q.offer(s);
	        while(!q.isEmpty()) {
	            BinaryTree t1 = q.poll();
	            if(isSame(t, t1))
	                return true;
	            if(t1.left != null)
	                q.offer(t1.left);
	            if(t1.right != null)
	                q.offer(t1.right);
	        }
	        return false;
	    }
	    public boolean isSame(BinaryTree t, BinaryTree t1) {
	        if(t == null && t1 == null)
	            return true;
	        if(t == null || t1 == null)
	            return false;
	        if(t.data != t1.data)
	            return false;
	        return isSame(t.left, t1.left) && isSame(t.right, t1.right);    
	    }
}

/* Leetcode: https://leetcode.com/problems/same-tree/description/
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

class Solution {
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null)
        return true;
    if(p == null || q == null)
        return false;
    if(p.val != q.val)
        return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);   
}
}
*/