package Collection;
import java.util.*;

/* Leetcode: https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class fractionToDecimal {
	public String fractionToDecimalI(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0)
            return "0";
        Boolean neg = false;
        if(numerator < 0 && denominator < 0) {
            neg = false;
            numerator = numerator * -1;
            denominator = denominator * -1;
        } else if(numerator < 0) {
            neg = true;
            numerator = numerator * -1;
        } else if(denominator < 0) {
            neg = true;
            denominator = denominator * -1;
        }
                  
        StringBuilder res = new StringBuilder();
        if(neg == true)
            res.append("-");
        int ans = numerator/denominator;
        res.append(ans);
        ans = numerator % denominator;
        if(ans == 0)
            return res.toString();
        
        res.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(Long.valueOf(ans), res.length());
        
        while(ans != 0) {
            ans = ans * 10;
            res.append(Math.abs(ans/denominator));
            ans = ans % denominator;
            if(map.containsKey(Long.valueOf(ans))) {
                System.out.println("duplicate: " + ans);
                int index = map.get(Long.valueOf(ans));
                res.insert(index, "(");
                res.append(")");
                break;
            }
            System.out.println("adding in map: " + ans);
            map.put(Long.valueOf(ans), res.length());
        }
        return res.toString();
    }

}
