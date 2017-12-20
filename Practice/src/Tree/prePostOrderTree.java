package Tree;

public class prePostOrderTree {
	
	/*
	 * void postOrderIterative(struct Node* root)
{
    if (root == NULL) 
        return;
 
    // Create two stacks
    struct Stack* s1 = createStack(MAX_SIZE);
    struct Stack* s2 = createStack(MAX_SIZE);
 
    // push root to first stack
    push(s1, root);
    struct Node* node;
 
    // Run while first stack is not empty
    while (!isEmpty(s1))
    {
        // Pop an item from s1 and push it to s2
        node = pop(s1);
        push(s2, node);
 
        // Push left and right children of removed item to s1
        if (node->left)
            push(s1, node->left);
        if (node->right)
            push(s1, node->right);
    }
 
    // Print all elements of second stack
    while (!isEmpty(s2))
    {
        node = pop(s2);
        printf("%d ", node->data);
    }
}


void iterativePreorder(node *root)
{
    // Base Case
    if (root == NULL)
       return;
 
    // Create an empty stack and push root to it
    stack<node *> nodeStack;
    nodeStack.push(root);
 
     Pop all items one by one. Do following for every popped item
       a) print it
       b) push its right child
       c) push its left child
    Note that right child is pushed first so that left is processed first 
    while (nodeStack.empty() == false)
    {
        // Pop the top item from stack and print it
        struct node *node = nodeStack.top();
        printf ("%d ", node->data);
        nodeStack.pop();
 
        // Push right and left children of the popped node to stack
        if (node->right)
            nodeStack.push(node->right);
        if (node->left)
            nodeStack.push(node->left);
    }
}
 
 Graph DFS
 * 
 * 
void Graph::DFSUtil(int v, bool visited[])
{
    // Mark the current node as visited and
    // print it
    visited[v] = true;
    cout << v << " ";
 
    // Recur for all the vertices adjacent
    // to this vertex
    list<int>::iterator i;
    for (i = adj[v].begin(); i != adj[v].end(); ++i)
        if (!visited[*i])
            DFSUtil(*i, visited);
}
 
// DFS traversal of the vertices reachable from v.
// It uses recursive DFSUtil()
void Graph::DFS(int v)
{
    // Mark all the vertices as not visited
    bool *visited = new bool[V];
    for (int i = 0; i < V; i++)
        visited[i] = false;
 
    // Call the recursive helper function
    // to print DFS traversal
    DFSUtil(v, visited);
} 


*
* Remove duplicates from the linkedlist
* 
* // Function to remove duplicates from an
       unsorted linked list 
    void remove_duplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;
 
        // Pick elements one by one 
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
 
            // Compare the picked element with rest
            //    of the elements 
            while (ptr2.next != null) {
 
                // If duplicate then delete it 
                if (ptr1.data == ptr2.next.data) {
 
                    // sequence of steps is important here
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
	 */

}
