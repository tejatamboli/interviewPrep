package bits;

/* LEetcode: https://leetcode.com/problems/number-of-1-bits/discuss/
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

public class numOneBits {
	public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt += (n & 1);
            n = n >>> 1; //We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
        }
        return cnt;
    }
}
