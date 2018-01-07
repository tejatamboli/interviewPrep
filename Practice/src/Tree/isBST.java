package Tree;

public class isBST {
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(4);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(5);
		root.left.left  = new BinaryTree(1);
		root.left.right = new BinaryTree(3);
		
		System.out.println("isBST: " + isBSTI(root));
	}
	
	public static boolean isBSTI(BinaryTree root) {
		return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static boolean isBSTUtil(BinaryTree root, int max, int min) {
		if(root == null)
			return true;
		if(root.data < min || root.data > max)
			return false;
		
		return (isBSTUtil(root.left, root.data-1, min) && 
				isBSTUtil(root.right, max, root.data+1));
					
	}
}

/* Leetcode: https://leetcode.com/problems/validate-binary-search-tree/discuss/
 
 
 class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);    
    }
    
    public boolean isValid(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        else if(root.val <= min || root.val >= max)
            return false;
        return (isValid(root.left, min, root.val) && isValid(root.right, root.val, max));
    }
}
*/
