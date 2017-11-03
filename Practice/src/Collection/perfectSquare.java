package Collection;

import java.util.*;

public class perfectSquare {
	
	public static void main(String[] args) {
		int num = 2147483647;
		//int num = 16;
		System.out.println("isSquare " + num + " : " + isSquare(num));
	}
	
	public static boolean isSquare(int num) {
		long sum = 0;
        int i = 1;
        while(sum < num) {
            sum = sum + i;
            System.out.println("i: " + i + " sum: " + sum);
            if(sum == num)
                return true;
            i = i + 2;
        }
        return false;   
	}
	
}
