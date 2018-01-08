package Tree;

/* Leetcode: https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values 
 * along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class pathSum {	
	    public boolean hasPathSumI(BinaryTree root, int sum) {
	        if(root == null)
	            return false;
	        if(root.left == null && root.right == null)
	            return root.data == sum;
	        return hasPathSumI(root.left, sum-root.data) || hasPathSumI(root.right, sum-root.data);        
	    }
}


/* Leetcode: https://leetcode.com/problems/path-sum-ii/description/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 
 class Solution {
 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        util(res, path, root, sum);
        return res;
    }
    
    public void util(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList<>(path));
        else {
            util(res, path, root.left, sum-root.val);
            util(res, path, root.right, sum-root.val);
        }
        path.remove(path.size()-1);
    }
}
*/

/* Leetcode: https://leetcode.com/problems/path-sum-iii/description/

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumFrom(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int add = (root.val == sum) ? 1 : 0;
        return add + pathSumFrom(root.left, sum-root.val) + pathSumFrom(root.right, sum-root.val);
    }  
}
*/

