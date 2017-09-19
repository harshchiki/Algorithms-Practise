package backtracking;

/**
 * http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * 
 * Cells marked with 1 can't be reached
 * 
 * @author harshchiki
 *
 */
public class RatInAMaze {
	final int N;
	int[][] maze;
	public RatInAMaze(int n) {
		this.N = n;
		maze = new int[N][N];
	}
	
	boolean solveMaze() {
		if(maze == null || maze.length == 0 || maze[0].length == 0) {
			return true;
		}
		
		if(maze[0][0] == 1) {
			// if source is marked 1, the rat will never be able to step into the maze (matrix)
			return false;
		}
		
		if(maze[maze.length-1][maze[0].length-1] == 1) {
			// if destination is marked 1, it is never possible to reach
			return false;
		}
		
		int[][] sol = new int[maze.length][maze[0].length];
		if(solveMazeUtil(maze, 0,0, sol)) {
			printSol(sol);
			return true;
		}else {
			return false;
		}
	}
	
	boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		int n = maze.length;
		int ny = maze[0].length;
		if(x == (n-1) && y == (ny-1)) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x,y)) {
			sol[x][y] = 1;
			
			if(solveMazeUtil(maze, x+1, y, sol)) {
				return true;
			}
			
			if(solveMazeUtil(maze, x, y+1, sol)){
				return true;
			}
			
			sol[x][y] = 0; // backtracking
			return false;
		}
		
		return false;
	}
	
	boolean isSafe(int[][] maze, int x, int y) {
		int n = maze.length;
		int ny = maze[0].length;
		
		if(x<n && x>=0 && y<ny && y>=0 // whether inside the maze matrix or not
				&&maze[x][y] == 1) { // whether this cell can be reached or not.
			return true;
		}else {
			return false;
		}
	}
	
	void printSol(int[][] sol) {
		for(int i = 0;i<sol.length;i++) {
			for(int j = 0;j<maze[0].length;j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
