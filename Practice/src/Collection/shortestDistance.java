
package Collection;

/* Leetcode
 * https://leetcode.com/problems/shortest-word-distance/
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
 */

/*public class shortestDistance {

    /*public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1-p2));
        }
        return min;
        
    }
}*/

/* Leetcode
 * https://leetcode.com/problems/shortest-word-distance-ii/description/
Design a class which receives a list of words in the constructor, and implements a method that takes two words 
word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

class WordDistance {

private Map<String, List<Integer>> m;

public WordDistance(String[] words) {
    int i = 0;
    m = new HashMap<String, List<Integer>>();
    for(String w: words) {
        if(m.containsKey(w)) 
            m.get(w).add(i);
        else {
            List<Integer> l1 = new LinkedList<Integer>();
            l1.add(i);
            m.put(w, l1);
        }
        i++;
    }  
}

public int shortest(String word1, String word2) {
    List<Integer> l1 = m.get(word1);
    List<Integer> l2 = m.get(word2);
    int min = Integer.MAX_VALUE;
    
    for(int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
        if(l1.get(i) < l2.get(j)) {
            min = Math.min(min, l2.get(j) - l1.get(i));
            i++;
        } else {
            min = Math.min(min, l1.get(i) - l2.get(j));
            j++;
        }
    }   
    return min;
}
}
*/

/* Leetcode
 * https://leetcode.com/problems/shortest-word-distance-iii/description/
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

class Solution {
public int shortestWordDistance(String[] words, String word1, String word2) {
    
    int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    boolean same = word1.equals(word2);
    
    for(int i = 0; i < words.length; i++) {
        if(words[i].equals(word1)) {
            if(same) {
                p1 = p2;
                p2 = i;
            } else
                p1 = i;
        } else if(words[i].equals(word2))
            p2 = i;
        if(p1!= -1 && p2 != -1)
            min = Math.min(min, Math.abs(p1-p2));
    }
    return min;
    }
 }
*/