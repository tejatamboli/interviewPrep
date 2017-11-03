package Tree;

import java.util.*;

public class Symmetric {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(2);
		root.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(4);
		root.right.left = new BinaryTree(4);
		root.right.right = new BinaryTree(3);
		
		System.out.println("isSymmetric: " + isSymmetric(root));
	}
	
	public static boolean isSymmetric(BinaryTree root) {
        boolean r = isMirror(root, root);  
        boolean i = isMirrorIter(root);
        
        System.out.println("recursive: " + r);
        System.out.println("iterative: " + i);
        
        return r;
    }
    
    public static boolean isMirror(BinaryTree root1, BinaryTree root2) {
        if(root1 == null && root2 == null)
            return true;
        if((root1 != null) && (root2 != null) && (root1.data == root2.data))
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        return false;
    }
    
    public static boolean isMirrorIter(BinaryTree root) {
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        if(root == null)
            return true;
        
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()) {
            
            BinaryTree leftNode = q.remove();
            BinaryTree rightNode = q.remove();
            
            if(leftNode == null && rightNode == null)
                continue;
            if((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null))
                return false;
            if(leftNode.data != rightNode.data)
                return false;
            q.add(leftNode.left);
            q.add(rightNode.right);
            q.add(leftNode.right);
            q.add(rightNode.left);
        }
        return true;   
    }
}
