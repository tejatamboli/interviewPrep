package Collection;

//check if the number is sum of the square of numbers 

public class sumSquareNumbers {
	public static void main(String[] args) {
		System.out.println("It is possible: " +  judgeSquareSum(7));
	}
	
	public static boolean judgeSquareSum(int c) {
        if(c < 0)
            return false;
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right) {
            int temp = left * left + right * right;
            if(temp < c)
                left++;
            else if(temp > c)
                right--;
            else
                return true;
        }
        return false;
    }

}
