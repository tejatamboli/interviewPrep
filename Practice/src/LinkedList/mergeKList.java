package LinkedList;

public class mergeKList {
	
	public static void main(String[] args) {
		Node[] lists = new Node[3];
		Node l1 = new Node(1);
		l1.next = new Node(2);
		l1.next.next = new Node(3);
		
		Node l2 = new Node(4);
		l2.next = new Node(6);
		l2.next.next = new Node(8);
		
		Node l3 = new Node(5);
		l3.next = new Node(7);
		l3.next.next = new Node(9);
		
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;
		
		Node l4 = mergeKLists(lists);
		
		while(l4!= null) {
			System.out.println(l4.data);
			l4 = l4.next;
		}	
	}
	
	public static Node mergeKLists(Node[] lists) {
        
        int last = lists.length-1;
        if(last < 0)
            return null;
        while(last != 0) {
            int i = 0;
            int j = last;
            while(i < j) {
                lists[i] = mergePair(lists[i], lists[j]);
                i++;
                j--;
                if(i >= j)
                    last = j;
            }
        }
        return lists[0];
    }
    
    public static Node mergePair(Node l1, Node l2) {
        Node result = null;
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        if(l1.data <= l2.data) {
            result = l1;
            result.next = mergePair(l1.next, l2);     
        } else {
            result = l2;
            result.next = mergePair(l1, l2.next);
        }
        return result;       
    }
}


/* For input n streams of infinite numbers
 * class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> minpq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        for(ListNode l: lists) {
            if(l != null)
                minpq.offer(l);
        }
        
        while(!minpq.isEmpty()) {
            ListNode del = minpq.poll();
            if(del.next != null)
                minpq.offer(del.next);
            del.next = null;
            tail.next = del;
            tail = tail.next;
        }
        return dummy.next;
    }
}
*/

