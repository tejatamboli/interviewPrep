package Tree;

// BT relates questions from geeksforgeeks

public class GeeksForGeeks {
	
/*	1. return the size of the Largest BST subtree in binary tree

	struct Info
	{
	    int sz;  // Size of subtree
	    int max; // Min value in subtree
	    int min; // Max value in subtree
	    int ans; // Size of largest BST which
	             // is subtree of current node
	    bool isBST; // If subtree is BST
	};
	 
	// Returns Information about subtree. The
	// Information also includes size of largest
	// subtree which is a BST.
	Info largestBSTBT(Node* root)
	{
	    // Base cases : When tree is empty or it has
	    // one child.
	    if (root == NULL)
	        return {0, INT_MIN, INT_MAX, 0, true};
	    if (root->left == NULL && root->right == NULL)
	        return {1, root->data, root->data, 1, true};
	 
	    // Recur for left subtree and right subtrees
	    Info l = largestBSTBT(root->left);
	    Info r = largestBSTBT(root->right);
	 
	    // Create a return variable and initialize its
	    // size.
	    Info ret;
	    ret.sz  = (1 + l.sz + r.sz);
	 
	    // If whole tree rooted under current root is
	    // BST.
	    if (l.isBST && r.isBST && l.max < root->data &&
	        r.min > root->data)
	    {
	        ret.min = l.min;
	        ret.max = r.max;
	 
	        // Update answer for tree rooted under
	        // current 'root'
	        ret.ans = ret.sz;
			I think it should be
			ret.ans = 1 + l.ans + r.ans;
	        ret.isBST = true;
	 
	        return ret;
	    }
	 
	    // If whole tree is not BST, return maximum
	    // of left and right subtrees
	    ret.ans = max(l.ans, r.ans);
	    ret.isBST = false;
	 
	    return ret;
	}*/

	
	/*
	 * 2. Find the kth smallest number from the BST
	 */
	
/*	
struct node_t
{
    int data;
    int lCount;
 
    node_t* left;
    node_t* right;
};
 

node_t *insert_node(node_t *root, node_t* node)
{
    // A crawling pointer 
    node_t *pTraverse = root;
    node_t *currentParent = root;
 
    // Traverse till appropriate node
    while(pTraverse)
    {
        currentParent = pTraverse;
 
        if( node->data < pTraverse->data )
        {
            // We are branching to left subtree
            //   increment node count 
            pTraverse->lCount++;
            
            pTraverse = pTraverse->left;
        }
        else
        {
            
            pTraverse = pTraverse->right;
        }
    }
 
    // If the tree is empty, make it as root node 
    if( !root )
    {
        root = node;
    }
    else if( node->data < currentParent->data )
    {
        // Insert on left side 
        currentParent->left = node;
    }
    else
    {
        // Insert on right side 
        currentParent->right = node;
    }
 
    return root;
}
 
// Elements are in an array. The function builds binary tree 
node_t* binary_search_tree(node_t *root, int keys[], int const size)
{
    int iterator;
    node_t *new_node = NULL;
 
    for(iterator = 0; iterator < size; iterator++)
    {
        new_node = (node_t *)malloc( sizeof(node_t) );
 
        // initialize 
        new_node->data   = keys[iterator];
        new_node->lCount = 0;
        new_node->left   = NULL;
        new_node->right  = NULL;
 
        // insert into BST 
        root = insert_node(root, new_node);
    }
 
    return root;
}
 
int k_smallest_element(node_t *root, int k)
{
    int ret = -1;
 
    if( root )
    {
        // A crawling pointer 
        node_t *pTraverse = root;
 
        // Go to k-th smallest 
        while(pTraverse)
        {
            if( (pTraverse->lCount + 1) == k )
            {
                ret = pTraverse->data;
                break;
            }
            else if( k > pTraverse->lCount )
            {
                //  There are less nodes on left subtree
                 //   Go to right subtree 
                k = k - (pTraverse->lCount + 1);
                pTraverse = pTraverse->right;
            }
            else
            {
                // The node is on left subtree 
                pTraverse = pTraverse->left;
            }
        }
    }
 
    return ret;
}
*/
	
/*
 * 	3. Add all greater values to every node in a given BST
 */
	
/*
 void modifyBSTUtil(struct node *root, int *sum)
{
    // Base Case
    if (root == NULL)  return;
 
    // Recur for right subtree
    modifyBSTUtil(root->right, sum);
 
    // Now *sum has sum of nodes in right subtree, add
    // root->data to sum and update root->data
    *sum = *sum + root->data;
    root->data = *sum;
 
    // Recur for left subtree
    modifyBSTUtil(root->left, sum);
}
 
// A wrapper over modifyBSTUtil()
void modifyBST(struct node *root)
{
    int sum = 0;
    modifyBSTUtil(root, &sum);
}
*/
 
/*
 *  4. Remove outside range elements min and max
 */
	
/*
node* removeOutsideRange(node *root, int min, int max)
{
   // Base Case
   if (root == NULL)
      return NULL;
 
   // First fix the left and right subtrees of root
   root->left =  removeOutsideRange(root->left, min, max);
   root->right =  removeOutsideRange(root->right, min, max);
 
   // Now fix the root.  There are 2 possible cases for toot
   // 1.a) Root's key is smaller than min value (root is not in range)
   if (root->key < min)
   {
       node *rChild = root->right;
       delete root;
       return rChild;
   }
   // 1.b) Root's key is greater than max value (root is not in range)
   if (root->key > max)
   {
       node *lChild = root->left;
       delete root;
       return lChild;
   }
   // 2. Root is in range
   return root;
}
 */

/*
 * 6. Find if there is a triplet in a Balanced BST that adds to zero
 */
	
/*
void inorder(node *root) {
    if (!root)
        return NULL;
    inorder(root->left);
    arr[index++] = root->key;
    inorder(root->right);
}

int isTripletPresent(node *root)
{
    int i;
    int is_present = 0;
    
    inorder(root);
    
    for(i = 0; i < index - 2; i++) {
        int l = i+1;
        int r = index-1;
        while(l < r) {
            int sum = arr[i] + arr[l] + arr[r];
            if (sum == 0) {
                printf("\n%d %d %d", arr[i], arr[l], arr[r]);
                l++; r--;
                is_present = 1;
            }
            else if (sum < 0)
                l++;
            else
                r--;
        }
    }
    
    return (is_present);
}
*/

/*
 * 7.  Function two print common elements in given two trees
 */
/*
void printCommon(Node *root1, Node *root2)
{
    // Create two stacks for two inorder traversals
    stack<Node *> stack1, s1, s2;
 
    while (1)
    {
        // push the Nodes of first tree in stack s1
        if (root1)
        {
            s1.push(root1);
            root1 = root1->left;
        }
 
        // push the Nodes of second tree in stack s2
        else if (root2)
        {
            s2.push(root2);
            root2 = root2->left;
        }
 
        // Both root1 and root2 are NULL here
        else if (!s1.empty() && !s2.empty())
        {
            root1 = s1.top();
            root2 = s2.top();
 
            // If current keys in two trees are same
            if (root1->key == root2->key)
            {
                cout << root1->key << " ";
                s1.pop();
                s2.pop();
 
                // move to the inorder successor
                root1 = root1->right;
                root2 = root2->right;
            }
 
            else if (root1->key < root2->key)
            {
                // If Node of first tree is smaller, than that of
                // second tree, then its obvious that the inorder
                // successors of current Node can have same value
                // as that of the second tree Node. Thus, we pop
                // from s2
                s1.pop();
                root1 = root1->right;
 
                // root2 is set to NULL, because we need
                // new Nodes of tree 1
                root2 = NULL;
            }
            else if (root1->key > root2->key)
            {
                s2.pop();
                root2 = root2->right;
                root1 = NULL;
            }
        }
 
        // Both roots and both stacks are empty
        else  break;
    }
} 
 */
	
/*
 * 8. // Returns count of nodes in BST in range [low, high]
int getCount(node *root, int low, int high)
{
    // Base case
    if (!root) return 0;
 
    // Special Optional case for improving efficiency
    if (root->data == high && root->data == low)
        return 1;
 
    // If current node is in range, then include it in count and
    // recur for left and right children of it
    if (root->data <= high && root->data >= low)
         return 1 + getCount(root->left, low, high) +
                    getCount(root->right, low, high);
 
    // If current node is smaller than low, then recur for right
    // child
    else if (root->data < low)
         return getCount(root->right, low, high);
 
    // Else recur for left child
    else return getCount(root->left, low, high);
}
*/
/*
	9. Merge two BST
	struct node* mergeTrees(struct node *root1, struct node *root2, int m, int n)
	{
	    // Store inorder traversal of first tree in an array arr1[]
	    int *arr1 = new int[m];
	    int i = 0;
	    storeInorder(root1, arr1, &i);
	 
	    // Store inorder traversal of second tree in another array arr2[]
	    int *arr2 = new int[n];
	    int j = 0;
	    storeInorder(root2, arr2, &j);
	 
	    // Merge the two sorted array into one
	    int *mergedArr = merge(arr1, arr2, m, n);
	 
	    // Construct a tree from the merged array and return root of the tree
	    return sortedArrayToBST (mergedArr, 0, m+n-1);
	}
	
// A utility unction to merge two sorted arrays into one
int *merge(int arr1[], int arr2[], int m, int n)
{
    // mergedArr[] is going to contain result
    int *mergedArr = new int[m + n];
    int i = 0, j = 0, k = 0;
 
    // Traverse through both arrays
    while (i < m && j < n)
    {
        // Pick the smaler element and put it in mergedArr
        if (arr1[i] < arr2[j])
        {
            mergedArr[k] = arr1[i];
            i++;
        }
        else
        {
            mergedArr[k] = arr2[j];
            j++;
        }
        k++;
    }
 
    // If there are more elements in first array
    while (i < m)
    {
        mergedArr[k] = arr1[i];
        i++; k++;
    }
 
    // If there are more elements in second array
    while (j < n)
    {
        mergedArr[k] = arr2[j];
        j++; k++;
    }
 
    return mergedArr;
}
// A helper function that stores inorder traversal of a tree rooted with node
void storeInorder(struct node* node, int inorder[], int *index_ptr)
{
    if (node == NULL)
        return;
 
    storeInorder(node->left, inorder, index_ptr);
 
    inorder[*index_ptr] = node->data;
    (*index_ptr)++;  // increase index for next entry
 
    storeInorder(node->right, inorder, index_ptr);
}
struct node* sortedArrayToBST(int arr[], int start, int end)
{

    if (start > end)
      return NULL;
 

    int mid = (start + end)/2;
    struct node *root = newNode(arr[mid]);
 
    root->left =  sortedArrayToBST(arr, start, mid-1);
     root->right = sortedArrayToBST(arr, mid+1, end);
    return root;
}
*/
/*
 * 10. Given a valid BST, find the minimum value difference between any two nodes of the tree.
 * Riverbed

Input:
        10
     /      \
    5       16
          /    \
        12     20


5, 10, 12, 1

Output:
2 (contributed 12 - 10)

struct tnode {
    int data;
    struct tnode *left;
    struct tnode *right;
};

void inorder(struct tnode *root, struct tnode *prev, int *min) {
        
    if (root == NULL)
        return;
 
    inorder(root->left, prev, min);
    if (prev != NULL)
        diff = root->data - prev->data;
        if (diff < *min)
            *min = diff;
    prev = root;     
    inorder(root->right, prev, min);
}

int main(struct tnode *tree1, struct tnode *tree2) {
    struct tnode *prev = NULL;
    int min = INT_MAX;
    int diff_num = inorder(tree1, prev, &min);
    printf("\nMin distance is %d", diff_num);
    
    prev = NULL;
    min = INT_MAX;
    diff_num = inorder(tree2, prev, &min);
    printf("\nMin distance is %d", diff_num);
   
}
*/
/*
 * 11.sorted linked list to balanced bst
 *
	void SplitLinkedListList(struct LNode *head, struct LNode **first, struct LNode **second, int *n1, int *data)
	{
	    struct LNode *runner = head;
	    struct LNode *slower = head;
	    struct LNode *prev = NULL;
	    
	    if (head == NULL || head->next == NULL) {
	        *first = NULL;
	        *second = NULL;
	        *data = head->data;
	        return;
	    }
	    
	    while (runner != NULL) {
	        runner = runner->next;
	        runner = (runner) ? runner->next : NULL;
	        if (runner == NULL)
	            break;
	        prev = slower;
	        slower = slower->next;
	        *n1 = *n1 + 1;
	    }
	    
	    *first = head;
	    *data = slower->data;
	    *second = slower->next;
	    prev->next = NULL;
	    
	}

	 The main function that constructs balanced BST and returns root of it.
		head_ref --> Pointer to pointer to head node of linked list
		n --> No. of nodes in Linked List 
	struct TNode* sortedListToBSTRecur(struct LNode **head_ref, int n)
	{
		
		if (n <= 0)
		    return NULL;
		int n1 = 0;
		int data = 0;
		 
		struct LNode *first = NULL, *second = NULL;
		SplitLinkedList(*head_ref, &first, &second, &n1, &data);
		struct TNode *root = newNode(data);
		root->left = sortedListToBSTRecur(&first, n1);
		root->right = sortedListToBSTRecur(&second, n-n1-1);
		
		return root;
	}
*/
	
/*
 * 12. floor and ceil value in BST
int floor(struct node *root, int input)
{
	// Base case
	if( root == NULL )
		return 65535;

	// We found equal key
	if( root->key == input )
		return root->key;

	// If root's key is smaller, ceil must be in right subtree
	if( root->key > input )
		return floor(root->left, input);

	// Else, either left subtree or root has the ceil value
	int floor = floor(root->right, input);
	return (floor <= input) ? floor : root->key;
}

int Ceil(node *root, int input)
{
    // Base case
    if( root == NULL )
        return -1;
 
    // We found equal key
    if( root->key == input )
        return root->key;
 
    // If root's key is smaller, ceil must be in right subtree
    if( root->key < input )
        return Ceil(root->right, input);
 
    // Else, either left subtree or root has the ceil value
    int ceil = Ceil(root->left, input);
    return (ceil >= input) ? ceil : root->key;
}
*/
 
/*
 * 13. Construct BST from given preorder traversal
// A recursive function to construct Full from pre[]. preIndex is used
// to keep track of index in pre[].
struct node* constructTreeUtil (int pre[], int* preIndex,
                                int low, int high, int size)
{
    // Base case
    if (*preIndex >= size || low > high)
        return NULL;
 
    // The first node in preorder traversal is root. So take the node at
    // preIndex from pre[] and make it root, and increment preIndex
    struct node* root = newNode ( pre[*preIndex] );
    *preIndex = *preIndex + 1;
 
    // If the current subarry has only one element, no need to recur
    if (low == high)
        return root;
 
    // Search for the first element greater than root
    int i;
    for ( i = low; i <= high; ++i )
        if ( pre[ i ] > root->data )
            break;
 
    // Use the index of element found in preorder to divide preorder array in
    // two parts. Left subtree and right subtree
    root->left = constructTreeUtil ( pre, preIndex, *preIndex, i - 1, size );
    root->right = constructTreeUtil ( pre, preIndex, i, high, size );
 
    return root;
}
*/
 
/*
 * 14. fix two swapped nodes of bst
void correctBSTUtil( struct node* root, struct node** first,
                     struct node** middle, struct node** last,
                     struct node** prev )
{
    if( root )
    {
        // Recur for the left subtree
        correctBSTUtil( root->left, first, middle, last, prev );
 
        // If this node is smaller than the previous node, it's violating
        // the BST rule.
        if (*prev && root->data < (*prev)->data)
        {
            // If this is first violation, mark these two nodes as
            // 'first' and 'middle'
            if ( !*first )
            {
                *first = *prev;
                *middle = root;
            }
 
            // If this is second violation, mark this node as last
            else
                *last = root;
        }
 
        // Mark this node as previous
        *prev = root;
 
        // Recur for the right subtree
        correctBSTUtil( root->right, first, middle, last, prev );
    }
}
 
// A function to fix a given BST where two nodes are swapped.  This
// function uses correctBSTUtil() to find out two nodes and swaps the
// nodes to fix the BST
void correctBST( struct node* root )
{
    // Initialize pointers needed for correctBSTUtil()
    struct node *first, *middle, *last, *prev;
    first = middle = last = prev = NULL;
 
    // Set the poiters to find out two nodes
    correctBSTUtil( root, &first, &middle, &last, &prev );
 
    // Fix (or correct) the tree
    if( first && last )
        swap( &(first->data), &(last->data) );
    else if( first && middle ) // Adjacent nodes swapped
        swap( &(first->data), &(middle->data) );
 
    // else nodes have not been swapped, passed tree is really BST.
}
 */
	
/*
 * 15. Merge two BST trees
/ The function to print data of two BSTs in sorted order
void  merge(struct node *root1, struct node *root2)
{
    // s1 is stack to hold nodes of first BST
    struct snode *s1 = NULL;
 
    // Current node of first BST
    struct node  *current1 = root1;
 
    // s2 is stack to hold nodes of second BST
    struct snode *s2 = NULL;
 
    // Current node of second BST
    struct node  *current2 = root2;
 
    // If first BST is empty, then output is inorder
    // traversal of second BST
    if (root1 == NULL)
    {
        inorder(root2);
        return;
    }
    // If second BST is empty, then output is inorder
    // traversal of first BST
    if (root2 == NULL)
    {
        inorder(root1);
        return ;
    }
 
    // Run the loop while there are nodes not yet printed.
    // The nodes may be in stack(explored, but not printed)
    // or may be not yet explored
    while (current1 != NULL || !isEmpty(s1) ||
          current2 != NULL || !isEmpty(s2))
    {
        // Following steps follow iterative Inorder Traversal
        if (current1 != NULL || current2 != NULL )
        {
            // Reach the leftmost node of both BSTs and push ancestors of
            // leftmost nodes to stack s1 and s2 respectively
            if (current1 != NULL)
            {
                push(&s1, current1);
                current1 = current1->left;
            }
            if (current2 != NULL)
            {
                push(&s2, current2);
                current2 = current2->left;
            }
 
        }
        else
        {
            // If we reach a NULL node and either of the stacks is empty,
            // then one tree is exhausted, ptint the other tree
            if (isEmpty(s1))
            {
                while (!isEmpty(s2))
                {
                    current2 = pop (&s2);
                    current2->left = NULL;
                    inorder(current2);
                }
                return ;
            }
            if (isEmpty(s2))
            {
                while (!isEmpty(s1))
                {
                    current1 = pop (&s1);
                    current1->left = NULL;
                    inorder(current1);
                }
                return ;
            }
 
            // Pop an element from both stacks and compare the
            // popped elements
            current1 = pop(&s1);
            current2 = pop(&s2);
 
            // If element of first tree is smaller, then print it
            // and push the right subtree. If the element is larger,
            // then we push it back to the corresponding stack.
            if (current1->data < current2->data)
            {
                printf("%d ", current1->data);
                current1 = current1->right;
                push(&s2, current2);
                current2 = NULL;
            }
            else
            {
                printf("%d ", current2->data);
                current2 = current2->right;
                push(&s1, current1);
                current1 = NULL;
            }
        }
    }
}
 */
/*
 * 16. BST to DLL
 */
/*	class BinaryTree 
	{
	    Node root;
	      
	    // head --> Pointer to head node of created doubly linked list
	    Node head;
	      
	    // Initialize previously visited node as NULL. This is
	    // static so that the same value is accessible in all recursive
	    // calls
	    static Node prev = null;
	  
	    // A simple recursive function to convert a given Binary tree 
	    // to Doubly Linked List
	    // root --> Root of Binary Tree
	    void BinaryTree2DoubleLinkedList(Node root) 
	    {
	        // Base case
	        if (root == null)
	            return;
	  
	        // Recursively convert left subtree
	        BinaryTree2DoubleLinkedList(root.left);
	  
	        // Now convert this node
	        if (prev == null) 
	            head = root;
	        else
	        {
	            root.left = prev;
	            prev.right = root;
	        }
	        prev = root;
	  
	        // Finally convert right subtree
	        BinaryTree2DoubleLinkedList(root.right);
	    }
	  
	    // Function to print nodes in a given doubly linked list 
	    void printList(Node node)
	    {
	        while (node != null) 
	        {
	            System.out.print(node.data + " ");
	            node = node.right;
	        }
	    }
	 */
	

	
}
