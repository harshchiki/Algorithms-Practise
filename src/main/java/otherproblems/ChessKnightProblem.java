package otherproblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * Problem: Given a chess board (9X9)
 * 
 * Find the minimum number of steps it would take
 * for the knight to reach the point (if at all it can)
 * 
 * Strategy: BFS from knight's position to find the destination.
 * Validation of points should be done.
 * 
 */
public class ChessKnightProblem {
	public static void main(String[] args) {
		Point knightPosition = new Point(1,1);
		Point finalPosition = new Point(6,5);
		findFinal(knightPosition, finalPosition);
	}
	
	static void findFinal(Point src, Point dest){
		if(src == null || dest == null){
			throw new RuntimeException("Null points");
		}
		
		if(!(Point.isPointValid(src) || Point.isPointValid(dest))){
			throw new RuntimeException("Illegal Points");
		}
		
		Set<Point> visitedSet = new HashSet<Point>();
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(src);
		
		while(!queue.isEmpty()){
			Point polledPoint = queue.poll();

			if(polledPoint.equals(dest)){
				System.out.println("Distance from Source = "+polledPoint.distFromStart);
				
				Point p = polledPoint;
				Stack<Point> stack = new Stack<Point>();
				while(null != p){
					stack.push(p);
					p = p.parent;
				}
				
				while(!stack.isEmpty()){
					System.out.println(stack.pop());
				}
				
				return;
			}
			
			if(!visitedSet.contains(polledPoint)){
				visitedSet.add(polledPoint);
				for(Point p : getAdjacentNodes(polledPoint)){
					p.distFromStart = polledPoint.distFromStart + 1;
					p.parent = polledPoint;
					queue.add(p);
				}
			}
		}
		System.out.println("No possible path between source and destination");
	}
	
	static List<Point> getAdjacentNodes(Point p){
		List<Point> list = new LinkedList<Point>();
		
		int x = p.x, y = p.y;
		
		Point point = new Point(x-2, y-1);
		addIfValid(list, point);
		
		point = new Point(x-2, y+1);
		addIfValid(list, point);
		
		point = new Point(x+2, y+1);
		addIfValid(list, point);
		
		point = new Point(x+2, y-1);
		addIfValid(list, point);
		
		/* */
		
		point = new Point(x+1, y+2);
		addIfValid(list, point);
		
		point = new Point(x-1, y+2);
		addIfValid(list, point);
		
		point = new Point(x+1, y-2);
		addIfValid(list, point);
		
		point = new Point(x-1, y-2);
		addIfValid(list, point);
		
		/* */
		
		point = new Point(x+1, y-2);
		addIfValid(list, point);
		
		point = new Point(x-1, y-2);
		addIfValid(list, point);
		
		point = new Point(x+1, y+2);
		addIfValid(list, point);
		
		point = new Point(x-1, y+2);
		addIfValid(list, point);
		
		
		return list;
	}

	static void addIfValid(List<Point> list, Point point) {
		if(Point.isPointValid(point)){
			list.add(point);
		}
	}
}

class Point{
	int x,y;
	int distFromStart = 0;
	Point parent = null;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	static boolean isPointValid(Point p) {
		int x = p.x, y = p.y;
		return !(x <0 || y < 0
				|| x > 8 || y > 8);
			
		}
	
	@Override
	public boolean equals(Object o){
		Point p = (Point)o;
		return this.x == p.x && this.y == p.y;
	}
	
	@Override
	public String toString(){
		return this.x+", "+this.y;
	}
}
