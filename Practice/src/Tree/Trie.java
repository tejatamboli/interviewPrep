package Tree;

/* Leetcode: https://leetcode.com/problems/implement-trie-prefix-tree/discuss/
 * Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd; 
    public TrieNode() {
        isEnd = false;
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class Trie {
	    /** Initialize your data structure here. */
	    static TrieNode root = null;
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode crawl = root;
	        for(int i = 0; i < word.length(); i++) {
	            int index = word.charAt(i)-'a';
	            if(crawl.children[index] == null) {
	                crawl.children[index] = new TrieNode();
	            }
	            crawl = crawl.children[index];           
	        }
	        crawl.isEnd = true;       
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TrieNode crawl = root;
	        for(int i = 0; i < word.length(); i++) {
	            int index = word.charAt(i)-'a';
	            if(crawl.children[index] == null)
	                return false;
	            crawl = crawl.children[index];
	        }
	        return crawl.isEnd;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode crawl = root;
	        for(int i = 0; i < prefix.length(); i++) {
	            int index = prefix.charAt(i)-'a';
	            if(crawl.children[index] == null)
	                return false;
	            crawl = crawl.children[index];
	        }
	        return true;
	    }
	
}
