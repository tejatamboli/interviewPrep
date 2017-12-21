package Collection;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/4sum-ii/description/
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers 
are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */

public class FourSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int s = A[i] + B[j];
                int val = 0;
                if(map.containsKey(s))
                    val = map.get(s);
                map.put(s, val + 1);
            }
        }
        int count = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int s = -1 * (C[i] + D[j]);
                if(map.containsKey(s))
                    count += map.get(s);  
            }
        }
        return count;
    }
}
