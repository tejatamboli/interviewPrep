package LinkedList;

public class DLL {
	int data;
	char key;
	DLL next;
	DLL prev;
	
	public DLL(int data) {
		this.data = data;
		this.key = '0';
		this.next = null;
		this.prev = null;	
	}
	
	public DLL(int data, char key) {
		this.data = data;
		this.key = key;
		this.next = null;
		this.prev = null;	
	}
}


