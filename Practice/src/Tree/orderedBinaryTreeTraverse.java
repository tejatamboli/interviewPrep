package Tree;

import java.util.*;

/*
 * Traverse a binary there so that the order returned is  ordered from smallest to greatest.
 * If it isn't a binary search tree, then just traverse the tree in any which way and put the 
 * elements into a min heap. Then iteratively pop the min off the top to return smallest to greatest. 
 * Traversal would take O(n), building the min heap is also O(n), and popping min off n times is also O(nlogn)
 * so total is O(nlogn).
 */

public class orderedBinaryTreeTraverse {
	
	static PriorityQueue<Integer>q = new PriorityQueue<Integer>();
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		
		printOrder(root);
		printQueue();
	}
	
	public static void printOrder(BinaryTree root) {
		if(root == null)
			return;
		printOrder(root.left);
		q.add(root.data);
		printOrder(root.right);	
	}
	
	public static void printQueue() {
		Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {
        	    int d = q.poll();
            System.out.println(" " + d);
        }
	}
}
