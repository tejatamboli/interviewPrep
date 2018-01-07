package Tree;

/* Leetcode: https://leetcode.com/problems/inorder-successor-in-bst/description/
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */

public class inorderSuccessor {
	
	    public BinaryTree inorderSuccessorI(BinaryTree root, BinaryTree p) {
	        if(p.right != null) {
	            return minValue(p.right);
	        }
	        BinaryTree curr = root, succ = null;
	        while(curr != null) {
	            if(p.data < curr.data) {
	                succ = curr;
	                curr = curr.left;
	            } else if(p.data > curr.data)
	                curr = curr.right;
	            else
	                break;
	        }
	        return succ;
	    }
	    public BinaryTree minValue(BinaryTree curr) {
	        while(curr.left != null)
	            curr = curr.left;
	        return curr;
	    }
}

/*
 * // This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
void findPreSuc(Node* root, Node*& pre, Node*& suc, int key)
{
    // Base case
    if (root == NULL)  return ;
 
    // If key is present at root
    if (root->key == key)
    {
        // the maximum value in left subtree is predecessor
        if (root->left != NULL)
        {
            Node* tmp = root->left;
            while (tmp->right)
                tmp = tmp->right;
            pre = tmp ;
        }
 
        // the minimum value in right subtree is successor
        if (root->right != NULL)
        {
            Node* tmp = root->right ;
            while (tmp->left)
                tmp = tmp->left ;
            suc = tmp ;
        }
        return ;
    }
 
    // If key is smaller than root's key, go to left subtree
    if (root->key > key)
    {
        suc = root ;
        findPreSuc(root->left, pre, suc, key) ;
    }
    else // go to right subtree
    {
        pre = root ;
        findPreSuc(root->right, pre, suc, key) ;
    }
}
 */

 

