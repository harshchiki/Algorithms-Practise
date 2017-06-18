package backtracking;

/*
 * Time complexity: Exponential
 * Space complexity: O(n)
 */
public class NQueenProblem {
	public static void main(String[] args) {		NQueenProblem p = new NQueenProblem();
		Position[] pos = p.solve(4);
		
		if(pos != null){
			for(Position po : pos){
				System.out.println(po);
			}
		}
	}
	/*
	 * Initially called with n = n, row = 0, positions array allocated n places
	 */
	boolean placeNQueens(int n, int row, Position[] positions){
		// actually the final condition (since we make a call "placeNQueens(n, row+1, positions)")
		if(n == row){
			return true;
		}
		int col;
		/*
		 * Each row will have a queen
		 */
		for(col = 0;col<n;col++){
			// assume we can place
			boolean foundSafe = true;
			
			// check for queens placed so far - queen<row (not queen<n)
			for(int queen = 0;queen<row	;queen++){
				Position qPos = positions[queen]; 
				/* since row and queen will have a 1:1 correspondence 
				(1 queen will be placed in each row)*/
				
				if(qPos.col == col || // if already existing
					(qPos.row-qPos.col) == (row-col) || // diagonal 2nd quadrant to 4th quadrant
					(qPos.row + qPos.col) == (row+col) // diagonal 1st quadrant to 3rd quadrant
						){
					foundSafe = false;
					break;
				}
			}
			if(foundSafe){
				/* can safely place -> so marking the positions as good as saying 
				queen[row] placed in position[row][this column -> col]*/
				positions[row] = new Position(row, col);
				
				/* once this queen is placed - go to the other set of queens (blindly)
				- we have the terminating condition in the beginning of this method */
				if(placeNQueens(n, row+1, positions)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	Position[] solve(int n){
		Position[] positions = new Position[n];
		boolean isSolvable = placeNQueens(n, 0, positions);
		if(isSolvable){
			return positions;
		}else{
			return null;
		}
	}
	
	class Position{
		int row, col;
		Position(int x, int y){
			this.row = x;
			this.col = y;
		}
		
		@Override
		public String toString(){
			return this.row+", "+col;
		}
	}
}
