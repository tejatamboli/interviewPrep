package Tree;

/* https://leetcode.com/problems/diameter-of-binary-tree/description/
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the 
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

In this post a new simple O(n) method is discussed. Diameter of a tree can be calculated by only using the height function, 
because the diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each node. So we need to 
calculate this value (left_height + right_height + 1) for each node and update the result. Time complexity – O(n)
*/

public class diameter {
	    int max = 0;
	    public int diameterOfBinaryTree(BinaryTree root) {
	        height(root);
	        return max;
	    }
	    public int height(BinaryTree root) {
	        if(root == null )
	            return 0;
	        int left = height(root.left);
	        int right = height(root.right);
	        max = Math.max(left + right, max);
	        return Math.max(left, right) + 1;
	    }
}
