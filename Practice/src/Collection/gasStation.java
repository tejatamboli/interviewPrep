package Collection;

/* Leetcode: https://leetcode.com/problems/gas-station/discuss/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */

public class gasStation {
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int start = 0; 
	        int total = 0;
	        int tank = 0;
	        for(int i = 0; i < gas.length; i++) {
	            tank = tank + gas[i] - cost[i];
	            if(tank < 0) {
	                start = i+1;
	                total += tank;
	                tank = 0;
	            }
	        }
	        if(total + tank < 0)
	            return -1;
	        else
	            return start;      
	    }
}
