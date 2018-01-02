package Tree;

public class BSTInsertSearch {
	
	public static void main(String[] args) {
		BinaryTree root = null;
		root = insertRec(root, 5);
		insertRec(root, 4);
		insertRec(root, 6);
		insertRec(root, 3);
		insertRec(root, 7);
	}
	
	public static BinaryTree insertRec(BinaryTree root, int key) {
		if(root == null) {
			root = new BinaryTree(key);
			return root;
		} else if(root.data < key) {
			root.right = insertRec(root.right, key);
		} else if(root.data > key){
			root.left = insertRec(root.left, key);
		}
		return root;
	}
	
	public static BinaryTree insert(BinaryTree root, int key) {
		BinaryTree newNode = new BinaryTree(key);
		if(root == null) {
			root = newNode;
			return root;
		}
		BinaryTree parent = root;
		while(root != null) {
			parent = root;
			if(key < root.data) {
				root = root.left;
			} else if(key > root.data) {
				root = root.right;
			}
		}
		if(key < parent.data)
			parent.left = newNode;
		else
			parent.right = newNode;
		return newNode;
	}
	
	public static BinaryTree searchRec(BinaryTree root, int key) {
		if(root == null || root.data == key)
			return root;
		else if(root.data < key)
			return searchRec(root.right, key);
		else
			return searchRec(root.left, key);
	}
	
	public static BinaryTree search(BinaryTree root, int key) {
		if(root == null)
			return root;
		while(root != null) {
			if(root.data == key) 
				break;
			else if(root.data < key)
				root = root.right;
			else if(root.data > key)
				root = root.left;
		}
		return root;
	}
	
/* Delete
 * 
void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }
 
    // A recursive function to insert a new key in BST 
    Node deleteRec(Node root, int key)
    {
        // Base Case: If the tree is empty 
        if (root == null)  return root;
 
        // Otherwise, recur down the tree 
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    */
 
	
}
