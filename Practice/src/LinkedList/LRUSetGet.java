package LinkedList;

//Asked in casper phone interview

import java.util.*;

public class LRUSetGet {

	   private static Map<Character, DLL> map;
	   private static LRUQueue q;

	   public LRUSetGet(int N) {
			q = new LRUQueue(N);
			map = new HashMap<Character, DLL>();
	   }
	  
	   // This function removes node from doubly linked list and
	   // sets head and tail pointers accordingly.
	   public static void removeNode(DLL node) {
		   if (q.front == node) {
			   q.front = q.front.next;
	       return;
	   }
	    
	  	DLL prev = node.prev;
	    DLL next = node.next;
	    if (prev != null) 
	    		prev.next = next;
	    else 
	    		q.front = next; 
	    if (next != null) 
	    		next.prev = prev;
	    else 
	    		q.rear = prev;
	  }

	  public static void Set(char key, int value) {
	  	if (map.containsKey(key)) {
	  		DLL old = map.get(key);
	  		old.data = value;
	  		removeNode(old);
	    } else {
	    		if (q.count < q.numberOfFrames) {
	    			q.count ++;
	    		} else {
	    			map.remove(q.front.key);
	    			q.front = q.front.next;
	    		}
	    }
	    // Allocate new node and set it as tail
	    DLL newNode = new DLL(value, key);
	    setTail(newNode);
	    map.put(key, newNode);
	  } 
	  
	  // Sets new node at the end of the doublu linked list.
	  public static void setTail(DLL node) {
	    if (q.front == null) 
	    		q.front = node;
	    
	  	if (q.rear == null) 
	  		q.rear = node;
	    else {
	    		q.rear.next = node;
	    		node.prev = q.rear;
	    		q.rear = node;
	    }
	  }

	  public static int get(char key) {
	     /*
	      Key can be any key in the LRU, so I am deleting node associated with key
	      and returning it's value. In the example above, get was called on only head
	      of the linked list.
	      */
	  	if (map.containsKey(key)) {
	  		DLL recent = map.get(key);
	  		removeNode(recent);
	  		setTail(recent);
	  		return recent.data;
	    } else 
	    		return -1;
	    
	  }
	  
	  public static void main(String[] args) {
	  }
}
