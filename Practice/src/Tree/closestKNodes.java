package Tree;
import java.util.*;

/* LinkedIn: careercup
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

public class closestKNodes {
	class Solution {
	    public List<Integer> closestKValues(BinaryTree root, double target, int k) {
	        LinkedList<Integer> res = new LinkedList<>();
	        helperRec(res, root, target, k);
	        return res;
	    }
	    
	    public void helperIter(BinaryTree root, LinkedList<Integer> res, double target, int k) {
	        Stack<BinaryTree> st = new Stack<>();
	        while(root != null || !st.isEmpty()) {
	            while(root!= null) {
	                st.push(root);
	                root = root.left;
	            } 
	            BinaryTree del = st.pop();
	            if(res.size() == k) {
	                if(Math.abs(res.getFirst() - target) >  Math.abs(del.data - target))
	                    res.removeFirst();
	                else
	                    return;
	            }
	            res.addLast(del.data);
	            root = del.right;
	        }
	    }
	}      
	    private boolean helperRec(LinkedList<Integer> list, BinaryTree root, double target, int k) {
	        if (root == null) {
	            return false;
	        }
	        
	        if (helperRec(list, root.left, target, k)) {
	            return true;
	        }
	        
	        if (list.size() == k) {
	            if (Math.abs(list.getFirst() - target) < Math.abs(root.data - target)) {
	                return true;
	            } else {
	                list.removeFirst();
	            }
	        }
	        
	        list.addLast(root.data);
	        return helperRec(list, root.right, target, k);
	    }
}
