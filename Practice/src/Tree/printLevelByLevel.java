package Tree;

import java.util.*;

public class printLevelByLevel {
	
	public static void printLevel(BinaryTree root) {
		Queue<BinaryTree> q = new LinkedList<>();
		BinaryTree dummy = new BinaryTree(-1);
		q.add(root);
		q.add(dummy);
		while(!q.isEmpty()) {
			BinaryTree t = q.poll();
			if (t.data == -1) {
				System.out.println("");
				if (!q.isEmpty())
					q.add(dummy);
			} else
				System.out.print(" " + t.data);
			if (t.left != null) {
				q.add(t.left);
			}
			if (t.right != null) {
				q.add(t.right);
			}
		}
	}
	
	public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
		
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        printLevel(root);
    }
}
