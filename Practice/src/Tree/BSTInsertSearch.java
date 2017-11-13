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
			root.right = insert(root.right, key);
		} else if(root.data > key){
			root.left = insert(root.left, key);
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
	
}
