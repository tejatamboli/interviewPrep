package Collection;

import java.util.*;

public class generatePara {
	
	    public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<>();
	        getPara("", res, n, n);
	        return res;
	    }
	    
	    public void getPara(String ans, List<String>res, int left, int right) {
	        if(left > right)
	            return; 
	        
	        if(left == 0 && right == 0) {
	            res.add(ans);
	            return;
	        }
	        if(left > 0) {
	            getPara(ans+"(", res, left-1, right);
	        }
	        if(right > 0) {
	            getPara(ans+")", res, left, right-1);
	        }
	        
	    }
	

}
