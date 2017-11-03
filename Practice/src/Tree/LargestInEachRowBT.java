package Tree;

import java.util.*;

public class LargestInEachRowBT {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.left.left.left = new BinaryTree(6);
		root.left.left.right= new BinaryTree(7);
		
		List<Integer> res = largestValues(root);
		
		for(int i = 0; i < res.size(); i++)
			System.out.println(" " + res.get(i));
		
	}
	
	public static List<Integer> largestValues(BinaryTree root) {
        Queue<BinaryTree> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int qSize = 0;
        if(root != null) {
            q.add(root);
            qSize = 1;
        } else
            return res;
        while(qSize > 0) {
            int largest = Integer.MIN_VALUE;
            for(int i = 0; i < qSize; i++) {
                BinaryTree t = q.remove();
                if(t.data > largest)
                    largest = t.data;
                if(t.left!= null)
                    q.add(t.left);
                if(t.right!= null)
                    q.add(t.right);
            }
            res.add(largest);
            qSize = q.size();
        }
        return res;
    }
}
