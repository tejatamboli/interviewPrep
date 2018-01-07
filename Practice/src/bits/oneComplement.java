package bits;

public class oneComplement {
	    public int findComplement(int num) {
	        int res = 0;
	        while(res < num) {
	            res = (res << 1) | 1;
	        }
	        return res-num;
	    }
}
