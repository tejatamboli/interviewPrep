package Tree;

/* Leetcode: https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/
 * Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
 */

public class BinaryTreeMaxPathSum {
	
	static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(BinaryTree root) {
        getMax(root); 
        return max;
    }
    
    public static int getMax(BinaryTree root) {
        if(root == null)
            return 0;
        
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        
        max = Math.max(max, left+right+root.data);
        return root.data + Math.max(left, right);
    }
}
