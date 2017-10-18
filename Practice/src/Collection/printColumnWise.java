package Collection;

public class printColumnWise {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7}; 
		int rows = 0;
		int numCols = 3;
		rows = arr.length / numCols; 
		int fullRow = arr.length % numCols;
		boolean notDone = false;
		if(fullRow > 0)
			rows++;
		int[][]a = new int[rows][numCols];
		int k = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < numCols; j++) {
				if(!notDone && i >= fullRow) {
					numCols--; 
					notDone = true;
				}
				a[j][i] = arr[k++];
				if(k >= arr.length)
					break;
			}
		}
		for(int i = 0; i < rows; i++) {
			System.out.println();
			for(int j = 0; j < numCols+1; j++) {
				System.out.print(" " + a[i][j]);
			}
		}
	}
}
