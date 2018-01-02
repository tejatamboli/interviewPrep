package Tree;
/* Leetcode: https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */

public class BSTtoSumTree {
	    int sum = 0;
	    public BinaryTree convertBST(BinaryTree root) {
	        return convertBSTUtil(root);
	    }
	    
	    public BinaryTree convertBSTUtil(BinaryTree root) {
	        if(root == null)
	            return null;
	        convertBSTUtil(root.right);
	        sum += root.data;
	        System.out.println("root: " + root.data + " sum: " + sum);
	        root.data = sum;
	        convertBSTUtil(root.left);
	        return root;
	    }
}
