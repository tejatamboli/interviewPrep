package LinkedList;

/* Leetcode: https://leetcode.com/problems/sort-list/description/
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

public class sortLinkedList {
	
	    public Node sortList(Node h) {
	        if(h == null || h.next == null)
	            return h;
	        Node middle = getMiddle(h);
	        Node next = middle.next;
	        middle.next = null;
	        
	        Node one = sortList(h);
	        Node two = sortList(next);
	        Node sorted = merge(one, two);
	        return sorted;
	    }
	    
	    public Node merge(Node one, Node two) {
	        Node result = null;
	        if(one == null)
	            return two;
	        if(two == null)
	            return one;
	        if(one.data < two.data) {
	            result = one;
	            result.next = merge(one.next, two);
	        } else {
	            result = two;
	            result.next = merge(one, two.next);
	        }
	        return result;
	    }
	    
	    public Node getMiddle(Node h) {
	        Node slow = h;
	        Node fast = h.next;
	        while(fast != null) {
	            fast = fast.next;
	            if(fast != null) {
	                slow = slow.next;
	                fast = fast.next;
	            }
	        }
	        return slow;
	    }
	

}
