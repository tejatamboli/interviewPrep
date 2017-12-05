package LinkedList;
class RandomListNode {
	int label;
	RandomListNode next, random;
	public RandomListNode(int x) { 
		this.label = x; 
	}
}

/* Leetcode: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * A linked list is given such that each node contains an additional random pointer which
 * could point to any node in the list or null. Return a deep copy of the list.
 */

public class copyRandomPtr {
    public RandomListNode copyRandomList(RandomListNode head) {
	        RandomListNode curr = head;
	        //create new node and attach it i to original node
	        if(head == null)
	            return head;
	        while(curr != null) {
	            RandomListNode next = curr.next;
	            RandomListNode t = new RandomListNode(curr.label);
	            t.next = next;
	            curr.next = t;
	            curr = next;
	        }
	        
	        curr = head;
	        while(curr != null) {
	            curr.next.random = curr.random.next;
	            curr = curr.next != null? curr.next.next : curr.next;
	        }
	        
	        RandomListNode orig = head;
	        RandomListNode copy = head.next;
	        RandomListNode clone = copy;
	        while(orig != null && copy != null) {
	            orig.next = orig.next != null? orig.next.next : orig.next;
	            copy.next = copy.next != null? copy.next.next : copy.next;
	            orig = orig.next;
	            copy = copy.next;
	        }
	        return clone;        
	    }
}
