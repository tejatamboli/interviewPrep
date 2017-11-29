package matrix;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/spiral-matrix/description/
 * 
 */

public class spiralMatrix {
	public List<Integer> spiralOrder(int[][] m1) {
        List<Integer>res = new ArrayList<>();
        if (m1.length == 0) {
            return res;
        }
        int k = 0;
        int l = m1.length-1;
        int m = 0;
        int n = m1[0].length-1;
        while(k <= l && m <= n) {
            for(int i = m; i <= n; i++)
                res.add(m1[k][i]);
            k++;
            for(int i = k; i <= l; i++)
                res.add(m1[i][n]);
            n--;
            if(k <= l) {
                for(int i = n; i >= m; i--) 
                    res.add(m1[l][i]);
                l--;
            }
            if(m <= n) {
                for(int i = l; i >= k; i--)
                    res.add(m1[i][m]);
                m++;
            }
        }
        return res;
    }

}
