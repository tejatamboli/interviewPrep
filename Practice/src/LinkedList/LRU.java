package LinkedList;

public class LRU {
	
	public static void main(String[] args) {
		//cache can hold 4 most recents nodes
		LRUQueue q = new LRUQueue(4);
		
		//maximum frames are 10
		LRUHash h = new LRUHash(10);		
		// Let us refer pages 1, 2, 3, 1, 4, 5
	    ReferencePage( q, h, 1);
	    ReferencePage( q, h, 2);
	    ReferencePage( q, h, 3);
	    ReferencePage( q, h, 1);
	    ReferencePage( q, h, 4);
	    ReferencePage( q, h, 5);
	    
	    System.out.println(q.front.data);
	    System.out.println(q.front.next.data);
	    System.out.println(q.front.next.next.data);
	    System.out.println(q.front.next.next.next.data);
	}
	
	public static void ReferencePage(LRUQueue q, LRUHash h, int pageNum) {
		if(pageNum > h.capacity)
			return;
		DLL node = h.arr[pageNum];
		if (node == null) {
			enQueue(q, h, pageNum);
		} else if(node == q.front) {
			return;
		} else {
			node.prev.next = node.next;
			if(node.next != null)
				node.next.prev = node.prev;
			
			if (node == q.rear) {
				q.rear = node.prev;
				q.rear.next = null;
			}
			
			node.next = q.front;
			node.prev = null;
			
			q.front.prev = node;
			q.front = node;
			
		}
	}
	
	public static void enQueue(LRUQueue q, LRUHash h, int pageNum) {
		
	    //queue is full so remove page from the rear side
		if(q.count == q.numberOfFrames) {
			h.arr[q.rear.data] = null;
			deQueue(q);
		}
		
		DLL newNode = new DLL(pageNum);
		newNode.next = q.front;
		
		if(q.front == null && q.rear == null)
			q.front = q.rear = newNode;
		else {
			q.front.prev = newNode;
			q.front = newNode;
		}
		h.arr[pageNum] = newNode;
		q.count++;
	}
	
	public static void deQueue(LRUQueue q) {
		//queue is empty
		if(q.front == null && q.rear == null)
			return;
		//only one node in the queue
		if(q.front == q.rear)
			q.front = null;
		//remove last node from the queue
		if(q.rear != null) {
			if(q.rear.prev != null)
				q.rear.prev.next = null;
			q.rear = q.rear.prev;
		}
		q.count--;
	}
}
