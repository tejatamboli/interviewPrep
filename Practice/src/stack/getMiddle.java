package stack;

public class getMiddle {
	
	public static void main(String[] args) {
		getMiddle ob = new getMiddle();
		middleStack ms = ob.createMiddleStack();
		ob.push(ms, 11);
		ob.push(ms, 22);
		ob.push(ms, 33);
		ob.push(ms, 44);
		ob.push(ms, 55);
		ob.push(ms, 66);
		ob.push(ms, 77);
     
		System.out.println("Item popped is " + ob.pop(ms));
		System.out.println("Item popped is " + ob.pop(ms));
		System.out.println("Middle Element is " + ob.findMiddle(ms));
	    
		ob.display(ms);
	}

	public middleStack createMiddleStack( ) {
		middleStack ms = new middleStack();
		ms.count = 0;
		ms.mid = null;
		ms.head = null;
		return ms;
	}
	
	public void push(middleStack ms, int data) {
		//System.out.println(data);
		DLLNode node = new DLLNode(data);
		node.prev = null;
		node.next = ms.head;
		if(ms.head != null) 
			ms.head.prev = node;
		else
			ms.mid = node;
		ms.count++;
		if(ms.count != 1 && ms.count %2 != 0)
			ms.mid = ms.mid.prev;
		ms.head = node;
		//System.out.println(node.data);
	}
	
	public int pop(middleStack ms) {
		if(ms.count == 0)
			return -1;
		if(ms.head == null)
			return -1;
		DLLNode hnode = ms.head.next;
		if(hnode != null)
			hnode.prev = null;
		int data = ms.head.data;
		ms.head = hnode;
		ms.count--;
		if(ms.count %2 == 0)
			ms.mid = ms.mid.next;
		return data;
	}
	
	public int findMiddle(middleStack ms) {
		if(ms.count == 0)
			return -1;
		return ms.mid.data;
		
	}
	
	public void display(middleStack ms) {
		DLLNode temp = ms.head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
