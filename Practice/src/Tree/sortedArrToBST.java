package Tree;

/* Leetcode: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

public class sortedArrToBST {
	public BinaryTree sortedArrayToBST(int[] nums) {
        BinaryTree root = makeTree(nums, 0, nums.length-1);
        return root;
    }
    
    public BinaryTree makeTree(int[] nums, int l, int h) {
        if(l > h)
            return null;
        int mid = (l + h) / 2;
        BinaryTree node = new BinaryTree(nums[mid]);
        node.left = makeTree(nums, l, mid - 1);
        node.right = makeTree(nums, mid + 1, h);
        return node;
    }
}
