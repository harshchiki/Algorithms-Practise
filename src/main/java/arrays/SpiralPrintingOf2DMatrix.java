package arrays;

public class SpiralPrintingOf2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = getMatrix();
		printSpiral(matrix);
	}
	
	static void printSpiral(int[][] m){
		if(m.length != m[0].length){
			System.out.println("Not a square matrix");
			return;
		}
		
		int steps = m[0].length;
		int i = 0,j = 0;
		
		int count = 0;
		while(steps>0){
			count++;
			/* move right*/
			for(int p = 0;p<steps;p++){
				System.out.print(m[i+p][j]+", ");
			}
			i += steps - 1;
			
			
			/* move down*/
			for(int p = 1;p<steps;p++){
				System.out.print(m[i][j+p]+", ");
			}
			j += steps -1;
			
			/* move left */
			for(int p = 1;p<steps;p++){
				System.out.print(m[i-p][j]+", ");
			}
			i -= steps-1;
			
			/* move up */
			for(int p=1;p<steps-1;p++){
				System.out.print(m[i][j-p]+", ");
			}
			j -= steps-1;
			
			steps -= 2;
			i++;
			j++;
		}
	}
	
	static int[][] getMatrix(){
		int[][] m = new int[5][5];
		
		m[0][0] = 1;
		m[0][1] = 2;
		m[0][2] = 3;
		m[0][3] = 4;
		m[0][4] = 5;
		
		m[1][0] = 6;
		m[1][1] = 7;
		m[1][2] = 8;
		m[1][3] = 9;
		m[1][4] = 10;
		
		m[2][0] = 11;
		m[2][1] = 12;
		m[2][2] = 13;
		m[2][3] = 14;
		m[2][4] = 15;
		
		m[3][0] = 16;
		m[3][1] = 17;
		m[3][2] = 18;
		m[3][3] = 19;
		m[3][4] = 20;
		
		m[4][0] = 21;
		m[4][1] = 22;
		m[4][2] = 23;
		m[4][3] = 24;
		m[4][4] = 25;
		
		return m;
	}
}
