package Collection;


public class nestedList_reverse_depth_weighted_sum {
	/*public static void main(String[] args) {
		   ArrayList l = new ArrayList();
        	   int level = 0;
		   System.out.println(recurse(l, level));
		}*/

		/*public static int recurse(List list, int level){
		   int sum = 1;
		   for(int i = 0; i < list.size(); i++){
		        if( list.get(i).isInteger()){
		             int val = list.get(i) * level;
		             sum = sum + val;
		        }else{
		             // recurse and increment depth level
		             sum = sum + recurse(l.get(i), level+1);
		        }
		   }
		   return sum;
		}*/

}
/*
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */

/* Leetcode:
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 *

public int depthSum(List<NestedInteger> nestedList) {
    return evaluate(nestedList, 1);   
}

public int evaluate(List<NestedInteger>nestedList, int level) {
    int sum = 0;
    for(int i = 0; i < nestedList.size(); i++) {
        if(nestedList.get(i).isInteger()) {
            sum += level * nestedList.get(i).getInteger();
        } else
            sum += evaluate(nestedList.get(i).getList(), level+1);
    }
    return sum;
} 

*/