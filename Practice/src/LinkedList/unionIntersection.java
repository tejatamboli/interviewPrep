package LinkedList;

public class unionIntersection {
	
	public Node getUnion(Node l1, Node l2) {
		Node result = new Node(-1);
		Node head = result;
		while(l1 != null && l2 != null) {
			if(l1.data < l2.data) {
				result.next = l1;
				l1 = l1.next;
			} else if(l1.data > l2.data) {
				result.next = l2;
				l2 = l2.next;
			} else {
				result.next = l1;
				l1 = l1.next;
				l2 = l2.next;
			}
			result = result.next;
		}
		if(l1 != null)
			result.next = l1;
		else if(l2 != null)
			result.next = l2;
		else
			result.next = null;
		
		return head.next;
	}
	
	public Node getIntersection(Node l1, Node l2) {
		Node result = new Node(-1);
		Node head = result;
		while(l1 != null && l2 != null) {
			if(l1.data < l2.data) 
				l1 = l1.next;
		    else if(l1.data > l2.data) 
				l2 = l2.next;
			else {
				result.next = l1;
				result = result.next;
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		result.next = null;
		return head.next;		
	}

}
