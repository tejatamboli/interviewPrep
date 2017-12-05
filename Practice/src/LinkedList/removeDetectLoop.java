package LinkedList;

/* Leetcode: https://leetcode.com/problems/linked-list-cycle/description/
 * 
 */

public class removeDetectLoop {
	
	    public boolean hasCycle(Node head) {
	        if(head == null)
	            return false;
	        Node slow = head, fast = head.next;
	        while(fast != null) {
	            if(slow == fast)
	                return true;
	            slow = slow.next;
	            fast = (fast.next != null) ? fast.next.next : fast.next;
	        }
	        return false;       
	    }
}

/*
 * Leetcode: https://leetcode.com/problems/linked-list-cycle-ii/discuss/
 

public ListNode detectCycle(ListNode head) {
ListNode slow = head;
ListNode fast = head;
boolean cycle = false;

while (fast!=null && fast.next!=null){
    fast = fast.next.next;
    slow = slow.next;
    if (fast == slow){
        cycle = true;
        break;   
    }
}
if(cycle) {
    fast = head;
    while (fast != slow){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
return null;
}
*/