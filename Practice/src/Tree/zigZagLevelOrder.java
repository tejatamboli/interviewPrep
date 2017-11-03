package Tree;

import java.util.*;

public class zigZagLevelOrder {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(3);
		root.left = new BinaryTree(9);
		root.right = new BinaryTree(20);
		root.right.left = new BinaryTree(15);
		root.right.right = new BinaryTree(7);
		List<List<Integer>>l = zigzagLevelOrderTraversal(root);
		System.out.println("List: " + l);		
	}
	
	public static List<List<Integer>> zigzagLevelOrderTraversal(BinaryTree root) {
        int h = height(root);
        List<List<Integer>> l = new LinkedList<>();
        
        boolean zigzag = false;
        
        for(int i = 1; i <= h; i++) {
            l.add(new LinkedList<Integer>());
            printGivenLevel(root, i, zigzag, l.get(l.size()-1));
            zigzag = !zigzag;
        }         
        return l;
    }
    
    public static int height(BinaryTree root) {
        if(root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        return 1 + Math.max(lheight, rheight);
    }
    
    public static void printGivenLevel(BinaryTree root, int level, boolean zigzag, List<Integer> l1) {
        if(root == null)
            return;
        if(level == 1)
            l1.add(root.data);
        else if(level > 1) {
            if(zigzag != true) {
                printGivenLevel(root.left, level-1, zigzag, l1);
                printGivenLevel(root.right, level-1, zigzag, l1);
            } else {
                printGivenLevel(root.right, level-1, zigzag, l1);
                printGivenLevel(root.left, level-1, zigzag, l1);   
            }
        }        
    }
}
