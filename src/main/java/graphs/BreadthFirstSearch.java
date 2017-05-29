package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		bfs(getGraph());
	}
	
	static void bfs(GraphNode start){
		if(start == null){
			return;
		}
		
		Set<GraphNode> visitedSet = new HashSet<GraphNode>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.add(start);
		
		while(!queue.isEmpty()){
			GraphNode removedNode = queue.poll();
			
			if(!visitedSet.contains(removedNode)){
				System.out.print(removedNode.data + " ");
				visitedSet.add(removedNode);
			}
			
			for(GraphNode gNode : removedNode.adjNodes){
				queue.add(gNode);
			}
		}
		
	}
	
	static GraphNode getGraph(){
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
}
