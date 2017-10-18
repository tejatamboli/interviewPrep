package Collection;

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

