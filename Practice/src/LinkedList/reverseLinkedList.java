package LinkedList;

public class reverseLinkedList {
	
	public static void main(String[] args) {
		Node head = new Node(85);
		head.next = new Node(15);
	    head.next.next = new Node(4);
	    head.next.next.next = new Node(20);
	    
	    printList(head);
	    head = reverseList(head);
	    printList(head);
	}
	
	public static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(" " + temp.data);
			temp = temp.next;
		}
	}
	
	public static Node reverseList(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}
