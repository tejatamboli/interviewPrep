package Tree;

/* Leetcode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

public class treePreInorder {
	    static int pIndex = 0;
	    public BinaryTree buildTree(int[] preorder, int[] inorder) {
	        System.out.println("pIndex: " + pIndex);
	        return tree(preorder, inorder, 0, inorder.length-1);
	    }
	    
	    public BinaryTree tree(int[] pre, int[] in, int s, int e) {
	        if(s > e)
	            return null;
	        System.out.println("pIndex: " + pIndex);
	        BinaryTree root = new BinaryTree(pre[pIndex]);
	        pIndex++;
	        if(s == e)
	            return root;
	        int iIndex = search(in, s, e, root.data);
	        root.left = tree(pre, in, s, iIndex-1);
	        root.right = tree(pre, in, iIndex+1, e);
	        return root;
	    }
	    
	    public int search(int[] in, int s, int e, int val) {
	        for(int i = s; i <= e; i++) {
	            if(in[i] == val)
	                return i;
	        }
	        return -1;
	    }	
}
