package Tree;

import java.util.*;


public class serializeDeserialize {
	
	public static void main(String[] args) {
		BinaryTree root        = new BinaryTree(20);
	    root.left               = new BinaryTree(8);
	    root.right              = new BinaryTree(22);
	    root.left.left         = new BinaryTree(4);
	    root.left.right        = new BinaryTree(12);
	    root.left.right.left  = new BinaryTree(10);
	    root.left.right.right = new BinaryTree(14);
	
	    String sb = serialize(root);
	    System.out.println("serialize: " + sb);
	    Deque<String> nodes = new LinkedList<>();  //imp step 
	    nodes.addAll(Arrays.asList(sb.split(" "))); //imp step
	    BinaryTree root1 = deserialize(nodes);
	    inorder(root1);
	}
	
	public static void inorder(BinaryTree root1) {
		if(root1 == null)
			return;
		inorder(root1.left);
		System.out.println(root1.data + " ");
		inorder(root1.right);
	}
	
	public static String serialize(BinaryTree root) {
		StringBuilder sb = new StringBuilder();
		serializeIntoString(root,sb);
		return sb.toString();
	}
	public static void serializeIntoString(BinaryTree root, StringBuilder sb) {
		if(root == null) {
			sb.append("#").append(" ");
			return;
		}
		sb.append(root.data).append(" ");
		serializeIntoString(root.left, sb);
		serializeIntoString(root.right, sb);
	}
	
	public static BinaryTree deserialize(Deque<String>nodes) {
		String val = nodes.remove();
		if(val.contains("#"))
			return null;
		BinaryTree root = new BinaryTree(Integer.valueOf(val));
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;	
	}
}
