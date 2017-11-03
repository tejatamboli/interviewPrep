package Tree;

import java.util.*;
//https://leetcode.com/problems/find-leaves-of-binary-tree/description/

public class findLeavesBinaryTree {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		
		List<List<Integer>> res = findLeaves(root);
		System.out.println(res);
	}
	
	public static List<List<Integer>> findLeaves(BinaryTree root) {
        List<List<Integer>> result = new ArrayList<>();
        createList(result, root);
        return result;
    }
    
    public static int createList(List<List<Integer>>res, BinaryTree root) {
        if(root == null) {
            return -1;
        }
        int level = 1 + Math.max(createList(res, root.left),createList(res, root.right));
        if(res.size() == level) {
            res.add(new ArrayList<>());
        }
        System.out.println("level: " + level + "root: " + root.data);
        res.get(level).add(root.data);
        root.left = root.right = null;
        return level;
    }
}
