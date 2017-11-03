package LinkedList;

public class LRUHash {
	int capacity;
	DLL[] arr;
		
	public LRUHash(int capacity) {
		this.capacity = capacity;
		this.arr = new DLL[capacity];      
		for(int i = 0; i < capacity; i++)
			this.arr[i] = null;
	}
}


