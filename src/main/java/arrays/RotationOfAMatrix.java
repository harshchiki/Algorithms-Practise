package arrays;

public class RotationOfAMatrix {
	
	public static void main(String[] args) {
		int[][] a = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		RotationOfAMatrix r = new RotationOfAMatrix();
		r.rotateAntiClockwiseBy90Degrees(r.rotateClockwiseBy90Degrees(a));
		
	}
	
	
	// by default clockwise by 90 degrees
	int[][] rotateClockwiseBy90Degrees(int[][] a){
		
		if(a == null || a.length == 0) return null;
		
		int rows = a.length; // m
		int cols = a[0].length; // n for m X n matrix
		
		int[][] sol = new int[cols][rows]; // for square matrix, rows = cols
		
		for(int i = 0;i<rows;i++) { 
			for(int j = 0;j<cols;j++){
				sol[i][j] = a[rows-j-1][i];
			}
		}
		
		System.out.println("Original array");
		printSol(a);
		System.out.println();
		System.out.println("Rotated clockwise by 90 degrees array");
		printSol(sol);
		
		return sol;
		
	}
	
	// by default anti clockwise by 90 degrees
		int[][] rotateAntiClockwiseBy90Degrees(int[][] a){
			
			if(a == null || a.length == 0) return null;
			
			int rows = a.length; // m
			int cols = a[0].length; // n for m X n matrix
			
			int[][] sol = new int[cols][rows]; // for square matrix, rows = cols
			
			for(int i = 0;i<rows;i++) { 
				for(int j = 0;j<cols;j++){
					sol[i][j] = a[j][cols-1-i];
				}
			}
			
			System.out.println("Original array");
			printSol(a);
			System.out.println();
			System.out.println("Rotated anticlockwise by 90 degrees array");
			printSol(sol);
			
			return sol;
		}
	
	void printSol(int[][] a){
		for(int i = 0;i<a.length;i++){
			for(int j = 0;j<a[0].length;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
