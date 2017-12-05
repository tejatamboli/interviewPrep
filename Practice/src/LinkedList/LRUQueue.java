package LinkedList;

public class LRUQueue {
	
	DLL front;
	DLL rear;
	int count;
	int numberOfFrames;
	
	public LRUQueue(int numFrames) {
		this.front = null;
		this.rear = null;
		this.count = 0;
		this.numberOfFrames = numFrames;
	}
}
