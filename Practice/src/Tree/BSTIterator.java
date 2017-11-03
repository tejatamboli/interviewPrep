package Tree;

import java.util.*;

public class BSTIterator {
    
    Stack<BinaryTree> st = new Stack<>();

    public BSTIterator(BinaryTree root) {
        pushAllLeft(root);   
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();    
    }

    /** @return the next smallest number */
    public int next() {
        BinaryTree temp = st.pop();
        pushAllLeft(temp.right);
        return temp.data;       
    }
    
    private void pushAllLeft(BinaryTree root) {
        while(root!= null) {
            st.push(root);
            root = root.left;
        }   
    }
    
    public static void main(String[] args) {
    		BinaryTree root = new BinaryTree(4);
    		root.left        = new BinaryTree(2);
    	    root.right       = new BinaryTree(6);
    	    root.left.left  = new BinaryTree(1);
    	    root.left.right = new BinaryTree(3);
    	    root.right.left  = new BinaryTree(5);
    	    root.right.right = new BinaryTree(7);
    	    
    	    BSTIterator it = new BSTIterator(root);
    	    while (it.hasNext()) 
    	    		System.out.println(it.next() + " ");	
    }
}
