package LinkedList;

/* Leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class removeNthNode {
	
	    public Node removeNthFromEnd(Node head, int n) {
	        Node start = new Node(0);
	        start.next = head;
	        
	        Node temp = start;
	        for(int i = 0; i <= n; i++)
	            temp = temp.next;
	    
	        Node cur = start;
	        while(temp != null) {
	            cur = cur.next;
	            temp = temp.next;
	        }
	        cur.next = cur.next.next;
	        return start.next;      
	    }
	

}
