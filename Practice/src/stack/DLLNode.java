package stack;

public class DLLNode {
	int data;
	DLLNode prev;
	DLLNode next;
	
	public DLLNode(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

}
