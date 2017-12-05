package Collection;

import java.util.*;

/* Leetcode: https://leetcode.com/problems/pascals-triangle/discuss/
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
] 
 */

public class pascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            List<Integer> p = null;
            if(res.size() > 0) {
                p = res.get(res.size()-1);
                System.out.println("i: " + i + " p: " + p);
                for(int j = 0; j < p.size()-1; j++) {
                    l.add(p.get(j) + p.get(j+1));
                }
                l.add(1);
            }
            res.add(l);
        }
        return res;
    }
}
