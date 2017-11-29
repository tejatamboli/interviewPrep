package Collection;

//you can plant flower [set 1] only if they are not adjacent.

public class canPlaceFlower {
	public static void main(String[] args) {
		int flowerBed[] = {1,0,0,0,0,0,1,0,0};
		int n = 4;
		boolean test = checkFlower(flowerBed, n);
		System.out.println("canPlaceFlower: " + test);
	}
	
	public static boolean checkFlower(int fb[], int n) {
		int count = 0;
		for(int i = 0; i < fb.length; i++) {
			if(fb[i] == 0) {
				if(((i == 0) || (fb[i-1] == 0)) && ((i == fb.length-1) || (fb[i+1] == 0))) {
					fb[i] = 1;
					count++;
				}
			}
		}
		if(count >= n) 
			return true;
		else
			return false;
	}
}
