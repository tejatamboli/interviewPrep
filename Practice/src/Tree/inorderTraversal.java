package Tree;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * 
 */

public class inorderTraversal {
	
	    public List<Integer> inorderTraversal1s(BinaryTree root) {
	        Stack<BinaryTree> s = new Stack<>();
	        List<Integer>res = new ArrayList<>();
	        BinaryTree curr = root;
	        while(true) {
	            while(curr != null) {
	                s.push(curr);
	                curr = curr.left;
	            }
	            if(s.size() == 0)
	                break;
	            curr = s.pop();
	            res.add(curr.data);
	            curr = curr.right;	            
	        }
	        return res;      
	    }
}
