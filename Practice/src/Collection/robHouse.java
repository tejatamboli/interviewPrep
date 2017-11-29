package Collection;

//https://leetcode.com/problems/house-robber/description/

public class robHouse {

	
	    public static int rob(int[] nums) {
	        
	        int noRob = 0;
	        int rob = 0;
	        for(int n : nums) {
	            int curRob = noRob + n;
	            noRob = Math.max(noRob, rob);
	            rob = curRob;
	        }
	        return Math.max(noRob, rob);      
	    }
	
	    public static void main(String[] args) {
	    		int[] arr = {};
	    		System.out.println("Earned from robbery: "+ rob(arr));
	    		
	    }
}
