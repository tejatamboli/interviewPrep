package Collection;

public class misc {
	
	/* 1. Find Duplicates
	 * void printRepeating( int arr[], int n)
{
    // First check all the values that are
    // present in an array then go to that
    // values as indexes and increment by
    // the size of array
    for (int i = 0; i < n; i++)
    {
        int index = arr[i] % n;
        arr[index] += n;
    }
 
    // Now check which value exists more
    // than once by dividing with the size
    // of array
    for (int i = 0; i < n; i++)
    {
        if ((arr[i]/n) > 1)
            cout << i << " ";
    }
 }
    
     Shuffle a given array such that each position is equally likely.
     for ( i=0; i < A.length -1 ; i++ )
     {
         	j = randInt(A, i, A.length -1);
 			swap(A, i, j)
 	 }
 	 
 	 Lockers: 
public static void Locker(int n)
{
     for (var i = 1; i <= Math.Sqrt(n); i++) Console.WriteLine(i*i);
}


7. A server receives requests from different clients...each client send a Runnable job and time on which 
this job should be run. Write a java program that would accept these jobs and run each job at the required
 time. Hint: the solution should have a job priority queue to hold the jobs and it should be multithreaded. 
 One thread should accept the tasks, the other one should run the jobs. Also conditions and signalling 
 will be used
 
 56. You have two arrays of integers, where the integers do not repeat and the two arrays have no common integers. 

Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the smallest difference between any of the integers in the two arrays. 

Assumptions: Assume both arrays are sorted in ascending order.
int i(0), j(0);
while (i < a.size() && j < b.size()) {
   if (a[i] <= b[j]) {  ans = min(ans, b[j]-a[i]); i++; } 
   else { ans = min(ans, a[i]-b[j]); j++; }
}
return ans; 

59. Implement the integral part logn base 2 with bit manipulations
int log2(int x)
{
    int res = 0;
    while (x >>= 1)
        res++;
    return res;
}

60.How do you design a column database

61.Write a function that would return the 5th element from the tail (or end) of a singly linked list of 
integers, in one pass, and then provide a set of test cases against that
 function (please do not use any list manipulation functions that you do not implement yourself).
 
 67. Dramatic - You need to find if a given sentence (a line of text) is available in a given magazine. You can not reuse letters. Think like, you are asking for some ransom, putting someone at gun point.You grab a magazine (weekly) and start tearing/cutting letters to form the sentence "I want blah blah money". Write a function that tells the given magazine has all the letters/alphabets sufficiently to form the sentence.
Option 1: 
-> take an array of a[26], count the occurrences of all characters in the text you need and the total number of letters. 
-> now while parsing the magazine just access a[character] and reduce it by 1 only if a[character] > 0 and --totalNumOfLetters. when totalNumLetters == 0 you got the answer 

70. You have n infinitely large sorted streams, and you have to get an output stream which returns the combined stream.. 
Assuming the arrays are sorted in ascending order. 

1. Create a Min Heap of size n. 
2. Insert every 1st element of the arrays into heap. 
3. Get the top element out of the heap and pop it out (print/store it). 
4. Keep a track of the array from which the popped element came from and insert the next element from that array only. 
4. reheap/heapfy the heap. 
5. repeat 2-4 untill the element count in heap becomes zero.

72. In a very complicated Java back-end system, since the load is too big, the garbage collector can not handle the memory and start having memory leaks. How to detect it and solve it?
https://www.ibm.com/developerworks/library/j-leaks/index.html

75. Given a large document and a short pattern consisting of a few words (eg. W1 W2 W3), find the shortest string that has all the words in any order (for eg. W2 foo bar dog W1 cat W3 -- is a valid pattern)
https://careercup.com/question?id=12179920

76. Find all the repeating sub-string sequence of specified length in a large string sequence. The sequences returned i.e. the output must be sorted alphabetically. 

For e.g. 

Input String: "ABCACBABC" 
repeated sub-string length: 3 

Output: ABC 

Input String: "ABCABCA" 
repeated sub-string length: 2 

Output: AB, BC, CA

https://careercup.com/question?id=6495932900179968

 78.  In "the 100 game," two players take turns adding, to a running 
total, any integer from 1..10. The player who first causes the running 
total to reach or exceed 100 wins. 
What if we change the game so that players cannot re-use integers? 
For example, if two players might take turns drawing from a common pool of numbers 
of 1..15 without replacement until they reach a total >= 100. This problem is 
to write a program that determines which player would win with ideal play. 

Write a procedure, "Boolean canIWin(int maxChoosableInteger, int desiredTotal)", 
which returns true if the first player to move can force a win with optimal play. 

Your priority should be programmer efficiency; don't focus on minimizing 
either space or time complexity. 
 

Boolean canIWin(int maxChoosableInteger, int desiredTotal) { 
// Implementation here. Write yours 

}
https://careercup.com/question?id=5116481574535168 

2.
// Recursive C++ program to find key closest to k
// in given Binary Search Tree.
#include<bits/stdc++.h>
using namespace std;
 
/* A binary tree node has key, pointer to left child
and a pointer to right child 
struct Node
{
    int key;
    struct Node* left, *right;
};
 
 Utility that allocates a new node with the
  given key and NULL left and right pointers. 
struct Node* newnode(int key)
{
    struct Node* node = new (struct Node);
    node->key = key;
    node->left = node->right  = NULL;
    return (node);
}
 
// Function to find node with minimum absolute
// difference with given K
// min_diff   --> minimum difference till now
// min_diff_key  --> node having minimum absolute
//                   difference with K
void maxDiffUtil(struct Node *ptr, int k, int &min_diff,
                                      int &min_diff_key)
{
    if (ptr == NULL)
        return ;
 
    // If k itself is present
    if (ptr->key == k)
    {
        min_diff_key = k;
        return;
    }
 
    // update min_diff and min_diff_key by checking
    // current node value
    if (min_diff > abs(ptr->key - k))
    {
        min_diff = abs(ptr->key - k);
        min_diff_key = ptr->key;
    }
 
    // if k is less than ptr->key then move in
    // left subtree else in right subtree
    if (k < ptr->key)
        maxDiffUtil(ptr->left, k, min_diff, min_diff_key);
    else
        maxDiffUtil(ptr->right, k, min_diff, min_diff_key);
}
 
// Wrapper over maxDiffUtil()
int maxDiff(Node *root, int k)
{
    // Initialize minimum difference
    int min_diff = INT_MAX, min_diff_key = -1;
 
    // Find value of min_diff_key (Closest key
    // in tree with k)
    maxDiffUtil(root, k, min_diff, min_diff_key);
 
    return min_diff_key;
}
 
// Driver program to run the case
int main()
{
    struct Node *root = newnode(9);
    root->left    = newnode(4);
    root->right   = newnode(17);
    root->left->left = newnode(3);
    root->left->right = newnode(6);
    root->left->right->left = newnode(5);
    root->left->right->right = newnode(7);
    root->right->right = newnode(22);
    root->right->right->left = newnode(20);
    int k = 18;
    cout << maxDiff(root, k);
    return 0;
}

Find random number
int findCeil(int arr[], int r, int l, int h)
{
    int mid;
    while (l < h)
    {
         mid = l + ((h - l) >> 1);  // Same as mid = (l+h)/2
        (r > arr[mid]) ? (l = mid + 1) : (h = mid);
    }
    return (arr[l] >= r) ? l : -1;
}
 
// The main function that returns a random number from arr[] according to
// distribution array defined by freq[]. n is size of arrays.
int myRand(int arr[], int freq[], int n)
{
    // Create and fill prefix array
    int prefix[n], i;
    prefix[0] = freq[0];
    for (i = 1; i < n; ++i)
        prefix[i] = prefix[i - 1] + freq[i];
 
    // prefix[n-1] is sum of all frequencies. Generate a random number
    // with value from 1 to this sum
    int r = (rand() % prefix[n - 1]) + 1;
 
    // Find index of ceiling of r in prefix arrat
    int indexc = findCeil(prefix, r, 0, n - 1);
    return arr[indexc];
}
 
// Driver program to test above functions
int main()
{
    int arr[]  = {1, 2, 3, 4};
    int freq[] = {10, 5, 20, 100};
    int i, n = sizeof(arr) / sizeof(arr[0]);
 
    // Use a different seed value for every run.
    srand(time(NULL));
 
    // Let us generate 10 random numbers accroding to
    // given distribution
    for (i = 0; i < 5; i++)
      printf("%d\n", myRand(arr, freq, n));
 
    return 0;
}
http://www.geeksforgeeks.org/random-number-generator-in-arbitrary-probability-distribution-fashion/

13.Showed me wwww.amazon.com page and asked me how to design the backend database so that it supports 
functions like displaying entire information about a product , its average rating and number of
customers who gave each rating etc.

15.There are "n" ticket windows in the railway station. ith window has ai tickets available. 
Price of a ticket is equal to the number of tickets remaining in that window at that time. When "m" 
tickets have been sold, what's the maximum amount of money the railway station can earn? 
exa. n=2, m=4 in 2 window available tickets are : 2 , 5 2nd window sold 4 tickets so 5+4+3+2=14. 3. 
There is a particular sequence only uses the numbers 1, 2, 3, 4 and no two adjacent numbers are the same. 

17. A design problem of the sorts : You need to present a ppt to say N users who are viewing it live 
in their browsers. What you have is a web page where the ppt is opened and has say two buttons : 
next and previous. You need to design basically what will happen / how will pressing of the buttons 
reflect a change across all the users.( He wanted something as to how the DNS on processing the next 
request would change the URL and convey it to all connected users)

_24. Given a number print all the combination in which no. can be printed.
for eg. Input: 3
Output: 2 1, 1 2, 1 1 1

2. Top trending posts in last 5m, 1H, 1Day? 
	1. extract terms (hashtags, phrases, words etc)
    2. remove spammy, trashy, offensive terms
    3. compare the current frequency of those terms to the historical frequency (we're looking for novelty, not popularity) (I don't know what we use, but you could use something like TF/IDF or even simpler)
    4. sort them by novelty
    
4. OS reads 4KB of data, the file can be 1KB but OS stores in 4K. It has this function: int read4K(buffer). 
Can you write function int read(buffer, int) that uses read4K(buffer) so apps can call it?"
It took me almost until the end, through writing out my approach step-by-step and repeatedly asking if 
that was what he meant, to realize he wanted me to write an input stream by reading in 4K at a time into 
the buffer, and keeping track of how many bytes have actually been read (since OS can store buffer 
sizes smaller than 4K into the 4K space).
    
6. Design an elevator system in tallest skyscraper of SF.

*/

}
