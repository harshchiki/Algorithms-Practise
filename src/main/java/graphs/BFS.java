package graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		BFS bfs = new BFS();
		GraphNode start= bfs.getGraph();
		bfs.printBFS(start);System.out.println("# DONE #");
	}
	
	public GraphNode getGraph(){
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		GraphNode n9 = new GraphNode(9);
		GraphNode n10 = new GraphNode(10);
		
		n1.adjNodes.add(n2);
		n1.adjNodes.add(n3);
		n1.adjNodes.add(n4);
		
		n2.adjNodes.add(n5);
		n2.adjNodes.add(n6);
		
		n3.adjNodes.add(n7);
		n3.adjNodes.add(n8);
		
		
		n4.adjNodes.add(n9);
		n4.adjNodes.add(n10);
		
		return n1;
	}
	
	public void printBFS(GraphNode start){
		Queue<GraphNode> q = new LinkedList();
		
		start.color = Color.GRAY;
		start.distanceFromStart = 0;
		start.parent = null;
		
		q.add(start);
		
		while(!q.isEmpty()){
			GraphNode removedNode = q.poll();
			
			removedNode.adjNodes
				.stream()
				.forEach((node) -> {
					if(node.color == Color.WHITE){
						node.color = Color.GRAY;
						node.distanceFromStart = removedNode.distanceFromStart+1;
						node.parent = removedNode;
						q.add(node);
					}
				});
			
			removedNode.color = Color.BLACK;
			System.out.println(removedNode);
		}
	}
}

class GraphNode{
	int data;
	Color color = Color.WHITE;
	int distanceFromStart = Integer.MIN_VALUE;
	GraphNode parent;
	List<GraphNode> adjNodes = new ArrayList<GraphNode>();
	
	GraphNode(int data){
		this.data = data;
	}
	
	@Override
	public String toString(){
		return "Data = "+this.data+" distanceFromStart = " +distanceFromStart+" parent = "+parent;
	}
}

enum Color{
	WHITE, GRAY, BLACK;
}
