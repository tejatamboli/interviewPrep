package Tree;

/* Leetcode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

public class kSmallestElement {
	
		 int count = 0;
		 int num = 0;

		public int kthSmallest(BinaryTree root, int k) {
		    traverse(root, k);
		    return num;
		}

		public void traverse(BinaryTree root, int k) {
		    if(root == null) 
		        return;
		    traverse(root.left, k);
		    count++;
		    if(count == k) 
		        num = root.data;
		    traverse(root.right, k);       
		}
		

}
