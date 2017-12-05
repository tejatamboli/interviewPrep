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
	
	//leetcode
	public static List<List<Integer>> levelOrder(BinaryTree root) {
        List<List<Integer>> l = new LinkedList<>();
        if(root == null)
            return l;
        
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.add(root);
        while(true) {
            int nodeCnt = q.size();
            if(nodeCnt == 0)
                break;
            l.add(new LinkedList<Integer>());
            while(nodeCnt > 0) {
                BinaryTree p = q.poll();//removes the head. different from remove as this does not throw exception for empty q
                l.get(l.size()-1).add(p.data);
                if(p.left != null)
                    q.add(p.left);
                if(p.right != null)
                    q.add(p.right);
                nodeCnt--;
                
            }
        }
        return l;
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
        System.out.println("Accepted Sol: " + levelOrder(root));
    }
}
