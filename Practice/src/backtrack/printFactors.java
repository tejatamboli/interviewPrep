package backtrack;

import java.util.*;

public class printFactors {
	public static void main(String[] args) {
		int num = 60;
		printFactor("", num, num);
	}
	
	public static void printFactor(String currExp, int num, int prevFactor) {
		for (int i = num - 1; i >= 2; i--) {
			if ((num % i == 0) && (i <= prevFactor)) {
				int nextFactor = num / i;
				int factor = i;
				if (nextFactor <= factor)
					System.out.println(currExp + factor + " * " + nextFactor);
				printFactor(currExp + factor + " * ", nextFactor, factor);
			}	
		}
	}
}

/*6 * 2
4 * 3
3 * 2 * 2
nextFactor = 2
factor = 6
nextFactor = 3
factor = 4
nextFactor = 4
factor = 3*/
/*
 * Leetcode
 * https://leetcode.com/problems/factor-combinations/discuss/
 
 class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
       for(int i = start; i <= Math.sqrt(n); i++){
           if(n % i == 0 && n/i >= i){  // The previous factor is no bigger than the next
               path.add(i);
               path.add(n/i);
               ret.add(new LinkedList<Integer>(path));
               path.remove(path.size() - 1);
               getFactors(i, n/i, path, ret);
               path.remove(path.size() - 1);
           }
       }
    }
}
*/

