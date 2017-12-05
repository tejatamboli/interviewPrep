package LinkedList;

/* Leetcode: https://leetcode.com/problems/odd-even-linked-list/description/
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
 */


public class evenOddLinkedList {
	
	    public Node oddEvenList(Node head) {
	        if(head == null || head.next == null)
	            return head;
	        Node odd = head;
	        Node even = head.next;
	        Node evenList = even;
	        Node curr = head.next.next;
	        while(curr != null) {
	            odd.next = curr;
	            odd = odd.next;
	            curr = curr.next;
	            if(curr != null) {
	                even.next = curr;
	                even = even.next;
	                curr = curr.next;
	            }
	        }
	        even.next = null;
	        odd.next = evenList;
	        return head;
	    }
}
