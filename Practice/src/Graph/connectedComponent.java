package Graph;

/* Count the number of connected components
 * Connected components are 
 * 1 1 1 <- starts from this one and then goes in the left side
 * 1 1 1
 * 1 1 1
 */


public class connectedComponent {
	
	static int[] rComb = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] cComb = {1, 0, -1, -1, -1, 0, 1, 1};
	
	public static void main(String[] args) {
		boolean G[][] = {{true,true,false,false,false}, {false,true,false,false,true}, {true,false,false,true,true}, {false,false,false,false,false}, {true,false,true,false,true}};
		System.out.println("Connected Components: " + countComp(G));
	}
	
	public static int countComp(boolean[][]G) {
		int count = 0;
		boolean[][] visited = new boolean[G.length][G[0].length];
		
		for(int i = 0; i < G.length; i++) {
			for(int j = 0; j < G[0].length; j++) {
				if(G[i][j] && !visited[i][j]) {
					count++;
					DFS(G, i, j, visited);
			    }
			}
		}
		return count;
	}
	
	public static void DFS(boolean[][]G, int r, int c, boolean[][]visited) {
		visited[r][c] = true;
		for(int k = 0; k < 8; k++) {
			if(isSafe(G, r+rComb[k], c+cComb[k], visited)) {
				DFS(G, r+rComb[k], c+cComb[k],visited);
			}
		}
	}    
	
	public static boolean isSafe(boolean[][]G, int r, int c, boolean[][]visited) {
		if (r>=0 && r < G.length && c>=0 && c < G[0].length && !visited[r][c] && G[r][c])
			return true;
		else
			return false;
	}
}


//Time complexity: O(ROW x COL)
/*
0 0 0
0 0 0 
0 0 0
*/
/*
1--------2
|\		/
| \	  /
|   \ 5
| /
3/-------4

*/
