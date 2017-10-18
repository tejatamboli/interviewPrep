package Collection;

public class findInfluencer {
	public static void main(String[] args) {
		int[][] m1 = {{0,1,1,0},{1,0,1,1},{0,0,0,0},{1,1,1,0}};
		System.out.println("influencer: " + findInfluencer(m1));
		System.out.println("influencer: " + getInfluencer(m1));
	}
	
	//o(n^2)
	public static int findInfluencer(int[][]m1) {
		int[] following = new int[m1.length];
		int[] followers = new int[m1.length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				following[i] = following[i] + m1[i][j];
				followers[j] = followers[j] + m1[i][j];
			}
		}
		for(int i = 0; i < m1.length; i++) {
			System.out.println("following: " + i + " " + following[i] + " " + followers[i]);
			if((followers[i] == m1.length-1) && (following[i] == 0))
				return i;
		}
		return -1;
	}
	
	public static int following(int[][] m1, int a, int b) {
		return m1[a][b];
	}
	//o(n)
	public static int getInfluencer(int[][]m1) {
		int a = 0;
		int b = m1.length - 1;
		
		while(a < b) {
			if(following(m1, a, b) == 1)
				a++;
			else
				b--;
		}
		for(int i = 0; i < m1.length; i++) {
			if ((a != i) && ((following(m1, a, i) == 1) || (following(m1, i, a) == 0)))
				return -1;
		}
		return a;
	}
}
