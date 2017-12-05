package LinkedList;

/* Leetcode: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
 */

public class getIntersectionPoint {
	
	    public Node getIntersectionNode(Node headA, Node headB) {
	        int cntA = getLen(headA);
	        int cntB = getLen(headB);
	        if(cntA > cntB) {
	            int d = cntA - cntB;
	            return intersectPoint(d, headA, headB);
	        } else {
	            int d = cntB - cntA;
	            return intersectPoint(d, headB, headA);
	        }
	    }
	    public int getLen(Node h) {
	        int cnt = 0;
	        while(h != null) {
	            cnt++;
	            h = h.next;
	        }
	        return cnt;
	    }
	    public Node intersectPoint(int d, Node ha, Node hb) {
	        for(int i = 0; i < d; i++)
	            ha = ha.next;
	        while(ha != null && hb != null) {
	            if(ha == hb)
	                return ha;
	            ha = ha.next;
	            hb = hb.next;
	        }
	        return null;
	    }
	

}
