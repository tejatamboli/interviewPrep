package LinkedList;

public class mergeTwoLists {
	
	public static void main(String[] args) {
		Node l1 = new Node(1);
		Node l2 = new Node(1);
		Node l3 = mergeTwoSortedLists(l1, l2);
        while(l3 != null) {
            System.out.println(l3.data);
            l3 = l3.next;
        }        
	}
	
	    public static Node mergeTwoSortedLists(Node l1, Node l2) {
	        
	        Node result = new Node(-1);
	        Node newHead = result;
	        
	        if(l1 == null)
	            return l2;
	        if(l2 == null)
	            return l1;
	        
	        while(l1 != null && l2 != null) {
	            if(l1.data < l2.data) {
	                result.next = l1;
	                l1 = l1.next;
	            } else {
	                result.next = l2;
	                l2 = l2.next;
	            } 
	            result = result.next;
	        }
	        if(l1 != null) {
	            result.next = l1;
	        } else if(l2 != null) {
	            result.next = l2;
	        }
	        
	        return newHead.next;
	        
	        
	    }
}
