package Collection;

/*
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */

public class nestedListDepthSum {
	
	   /* Leetcode
	    * public int depthSumInverse(List<NestedInteger> nestedList) {
	        Queue<NestedInteger> q = new LinkedList<>();
	        for(NestedInteger ni: nestedList) 
	            q.add(ni);
	        int level = 1;
	        int total = 0;
	        int prev = 0;
	        
	        while(!q.isEmpty()) {
	            int size = q.size();
	            int levelSum = 0;
	            for(int j = 0; j < size; j++) {
	                NestedInteger i = q.poll();
	                if(i.isInteger()) {
	                    levelSum += level * i.getInteger();
	                } else {
	                    for(NestedInteger ni: i.getList())
	                        q.add(ni);
	                }
	            }
	            prev += levelSum;
	            total += prev;
	        }
	        return total;
	    }
	*/

}
