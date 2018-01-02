package LinkedList;

public class misc {
	
/* 1.  The function removes duplicates from a sorted list 
void removeDuplicates(struct Node* head)
{
    // Pointer to traverse the linked list 
    struct Node* current = head;
 
    // Pointer to store the next pointer of a node to be deleted
    struct Node* next_next; 
   
    // do nothing if the list is empty 
    if (current == NULL) 
       return; 
 
    // Traverse the list till last node 
    while (current->next != NULL) 
    {
       // Compare current node with next node 
       if (current->data == current->next->data) 
       {
           // The sequence of steps is important            
           next_next = current->next->next;
           free(current->next);
           current->next = next_next;  
       }
       else // This is tricky: only advance if no deletion 
       {
          current = current->next; 
       }
    }
}
*/
	
/*
 * 2. Function to remove duplicates from a
   unsorted linked list 
void removeDuplicates(struct Node *start)
{
    struct Node *ptr1, *ptr2, *dup;
    ptr1 = start;
 
    // Pick elements one by one 
    while (ptr1 != NULL && ptr1->next != NULL)
    {
        ptr2 = ptr1;
 
        // Compare the picked element with rest
           of the elements 
        while (ptr2->next != NULL)
        {
            // If duplicate then delete it 
            if (ptr1->data == ptr2->next->data)
            {
                // sequence of steps is important here 
                dup = ptr2->next;
                ptr2->next = ptr2->next->next;
                delete(dup);
            }
            else // This is tricky 
                ptr2 = ptr2->next;
        }
        ptr1 = ptr1->next;
    }
}
 */

	/* Reverses the linked list in groups of size k and returns the 
	   pointer to the new head node. 
	struct Node *reverse (struct Node *head, int k)
	{
	    struct Node* current = head;
	    struct Node* next = NULL;
	    struct Node* prev = NULL;
	    int count = 0;   
	     
	    //reverse first k nodes of the linked list 
	    while (current != NULL && count < k)
	    {
	        next  = current->next;
	        current->next = prev;
	        prev = current;
	        current = next;
	        count++;
	    }
	     
	     next is now a pointer to (k+1)th node 
	       Recursively call for the list starting from current.
	       And make rest of the list as next of first node 
	    if (next !=  NULL)
	       head->next = reverse(next, k); 
	 
	    // prev is new head of the input list 
	    return prev;
	}
	*/
	
	/* Reverses alternate k nodes and
	   returns the pointer to the new head node 
	struct Node *kAltReverse(struct Node *head, int k)
	{
	    struct Node* current = head;
	    struct Node* next;
	    struct Node* prev = NULL;
	    int count = 0;   
	 
	    1) reverse first k nodes of the linked list 
	    while (current != NULL && count < k)
	    {
	       next  = current->next;
	       current->next = prev;
	       prev = current;
	       current = next;
	       count++;
	    }
	   
	    2) Now head points to the kth node.  So change next 
	       of head to (k+1)th node
	    if(head != NULL)
	      head->next = current;   
	 
	     3) We do not want to reverse next k nodes. So move the current 
	        pointer to skip next k nodes 
	    count = 0;
	    while(count < k-1 && current != NULL )
	    {
	      current = current->next;
	      count++;
	    }
	 
	     4) Recursively call for the list starting from current->next.
	       And make rest of the list as next of first node 
	    if(current !=  NULL)
	       current->next = kAltReverse(current->next, k); 
	 
	     5) prev is new head of the input list 
	    return prev;
	}*/
	
	/* Deletes nodes which have a node with greater value node
	  on left side 
	void delLesserNodes(struct Node **head_ref)
	{
	     1) Reverse the linked list 
	    reverseList(head_ref);
	 
	     2) In the reversed list, delete nodes which have a node
	       with greater value node on left side. Note that head
	       node is never deleted because it is the leftmost node.
	    _delLesserNodes(*head_ref);
	 
	     3) Reverse the linked list again to retain the
	       original order 
	    reverseList(head_ref);
	}
	 
	/* Deletes nodes which have greater value node(s) on left side 
	void _delLesserNodes(struct Node *head)
	{
	     struct Node *current = head;
	 
	      //Initialize max 
	     struct Node *maxnode = head;
	     struct Node *temp;
	 
	     while (current != NULL && current->next != NULL)
	     {
	         // If current is smaller than max, then delete current 
	         if(current->next->data < maxnode->data)
	         {
	             temp = current->next;
	             current->next = temp->next;
	             free(temp);
	         }
	 
	         // If current is greater than max, then update max and
	         //   move current 
	         else
	         {
	             current = current->next;
	             maxnode = current;
	         }
	     }
	}*/
	
	/*
	 *  Adds contents of two linked lists and return the head node of resultant list 
struct Node* addTwoLists (struct Node* first, struct Node* second)
{
    struct Node* res = NULL; // res is head node of the resultant list
    struct Node *temp, *prev = NULL;
    int carry = 0, sum;
 
    while (first != NULL || second != NULL) //while both lists exist
    {
        // Calculate value of next digit in resultant list.
        // The next digit is sum of following things
        // (i)  Carry
        // (ii) Next digit of first list (if there is a next digit)
        // (ii) Next digit of second list (if there is a next digit)
        sum = carry + (first? first->data: 0) + (second? second->data: 0);
 
        // update carry for next calulation
        carry = (sum >= 10)? 1 : 0;
 
        // update sum if it is greater than 10
        sum = sum % 10;
 
        // Create a new node with sum as data
        temp = newNode(sum);
 
        // if this is the first node then set it as head of the resultant list
        if(res == NULL)
            res = temp;
        else // If this is not the first node then connect it to the rest.
            prev->next = temp;
 
        // Set prev for next insertion
        prev  = temp;
 
        // Move first and second pointers to next nodes
        if (first) first = first->next;
        if (second) second = second->next;
    }
 
    if (carry > 0)
      temp->next = newNode(carry);
 
    // return head of the resultant list
    return res;
}
	 */
	
	/*Write code to partition a linked list around a value x, such that all nodes less than x come before alt nodes 
	 * greater than or equal to x.
	 * 
	 *  Pass in the head of the linked list and the value to partition  around 
publicLinkedListNodepartition(LinkedListNodenode,intx){
LinkedListNode beforeStart = null; 
LinkedListNode beforeEnd = null; 
LinkedListNode after-Start = null; 
LinkedListNode afterEnd = null;
//Partition list 
while (node != null) {
LinkedListNode next = node.next; node.next = null;
if (node.data < x) {
/* Insert node into end of before list 
 *  if (beforeStart == null) {
beforeStart = node;
beforeEnd = beforeStart;
}else{
beforeEnd.next = node; beforeEnd = node;
}
}else{
}
}
node = next; 
}

if(beforeStart ==null){
afterEnd.next = node; afterEnd = node;
Solutions to Chapter 2 j Linked Lists
 Insert node into end of after list 
 if (after-Start == null) {
afterStart = node;
afterEnd = afterStart; }else{

 } 
 Merge before list and after list 
 beforeEnd.next = afterStart;
 return beforeStart;
 }
*/

/*
//https://www.geeksforgeeks.org/sum-of-two-linked-lists/
*/

/*
 * The main function that flattens a multilevel linked list 
void flattenList(struct Node *head)
{
    
    if (head == NULL)
       return;
 
    struct Node *tmp;
 
    // Find tail node of first level linked list 
    struct Node *tail = head;
    while (tail->next != NULL)
        tail = tail->next;
 
    // One by one traverse through all nodes of first level
    // linked list till we reach the tail node
    struct Node *cur = head;
    while (cur != tail)
    {
        // If current node has a child
        if (cur->child)
        {
            // then append the child at the end of current list
            tail->next = cur->child;
 
            // and update the tail to new last node
            tmp = cur->child;
            while (tmp->next)
                tmp = tmp->next;
            tail = tmp;
        }
 
        // Change current node
        cur = cur->next;
    }
}
 */
	
/*
 * // Flattens a multi-level linked list depth wise
 * do it using stack
Node* flattenList(Node* node)
{
    // Base case
    if (node == NULL)
        return NULL;
 
    // To keep track of last visited node
    // (NOTE: This is static)
    static Node *last;
    last = node;
 
    // Store next pointer
    Node *next = node->next;
 
    // If down list exists, process it first
    // Add down list as next of current node
    if (node->down)
       node->next = flattenList(node->down);
 
    // If next exists, add it after the next
    // of last added node
    if (next)
       last->next = flattenList(next);
 
    return node;
}
 */
	

}
