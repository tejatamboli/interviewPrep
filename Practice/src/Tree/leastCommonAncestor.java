package Tree;

public class leastCommonAncestor {
	
	static int d1 = -1;
	static int d2 = -1;
	static int dist = 0;
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
	    root.right = new BinaryTree(3);
	    root.left.left = new BinaryTree(4);
	    root.left.right = new BinaryTree(5);
	    root.right.left = new BinaryTree(6);
	    root.right.right = new BinaryTree(7);
	    root.right.left.right = new BinaryTree(8);
		System.out.println("dist is[4,5]: " +  getDist(root, 4, 5));
		d1 = -1; d2 = -1; dist = 0;
		System.out.println("dist is[4,6]: " +  getDist(root, 4, 6));
		d1 = -1; d2 = -1; dist = 0;
		System.out.println("dist is[3,4]: " +  getDist(root, 3, 4));
		d1 = -1; d2 = -1; dist = 0;
		System.out.println("dist is[2,4]: " +  getDist(root, 2, 4));
		d1 = -1; d2 = -1; dist = 0;
		System.out.println("dist is[8,5]: " +  getDist(root, 8, 5));
	}
	
	public static int getDist(BinaryTree root, int m1, int m2) {
		
		int level = 0; 
		BinaryTree ca = lca(root, m1, m2, level);
		
		if(d1 != -1 && d2 != -1)
			return dist;
		if(d1!= -1)  {
			level = 0;
			return findLevel(ca, m2, level);
		} if(d2 != -1) {
			level = 0;
			return findLevel(ca, m1, level);
		}
		return -1;
	}	
	
	public static BinaryTree lca(BinaryTree root, int m1, int m2, int level) {
		if(root == null)
			return null;
		if(root.data == m1) {
			d1 = level;
			return root;
		}
		if(root.data == m2) {
			d2 = level;
			return root;
		}
		
		BinaryTree left = lca(root.left, m1, m2, level+1);
		BinaryTree right = lca(root.right, m1, m2, level+1);
	
		if(left != null && right != null) {
			dist = d1 + d2 - 2 * level;
			return root;
		}
		return (left != null) ? left : right;
	}
	
	public static int findLevel(BinaryTree root, int data, int level) {
		if(root == null)
			return -1;
		if(root.data == data)
			return level;
		int left = findLevel(root.left, data, level+1);
		return (left != -1) ? left : findLevel(root.right,data,level+1);			
	}
}

