package dp;

/* Leetcode: https://leetcode.com/problems/count-primes/discuss/
 * Description: Count the number of prime numbers less than a non-negative number, n.
 */

public class countPrimes {
	
	    public int countPrime(int n) {
	        boolean[] np = new boolean[n];
	        int cnt = 0;
	        for(int i = 2; i < n; i++) {
	            if(np[i] == false) {
	                cnt++;
	                for(int j = 2; i * j < n; j++)
	                    np[i*j] = true;
	            }
	        }
	        return cnt;       
	    }
}
