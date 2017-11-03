package Tree;

/* 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
 * then this node's value is the smaller value among its two sub-nodes.
 * Given such a binary tree, you need to output the second minimum value in the set made of all 
 * the nodes' value in the whole tree. If no such second minimum value exists, output -1 instead.
 */
public class secondMinimumNodeBinaryTree {
	
	public static void main(String[] atgs) {
		BinaryTree root = new BinaryTree(2);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(5);
		root.right.left = new BinaryTree(5);
		root.right.right = new BinaryTree(7);
		
		System.out.println("Second min num is: " + findSecondMinimumValue(root));
	}
	
	public static int findSecondMinimumValue(BinaryTree root) {
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return -1;
        
        int left = root.left.data;
        int right = root.right.data;
        if(left == root.data)
            left = findSecondMinimumValue(root.left);
        if(right == root.data)
            right = findSecondMinimumValue(root.right);
        if(left != -1 && right != -1)
            return Math.min(left, right);
        else if(left != -1)
            return left;
        else
            return right;
    }

}
