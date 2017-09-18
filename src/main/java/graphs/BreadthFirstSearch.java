package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		bfs(getGraph(), 2);
	}
	
	// total number of nodes is passed to have it in the loop condition
	// to handle cycles
	static void bfs(GraphNode start, int totalNumberOfNodes){
		if(start == null){
			return;
		}
		
		Set<GraphNode> visitedSet = new HashSet<GraphNode>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		
		queue.add(start);
		
		// check on size of visited set to be less than total number of nodes
		// is required if the graph is cyclic.
		while(!queue.isEmpty() && visitedSet.size()<totalNumberOfNodes){
			GraphNode removedNode = queue.poll();
			
			// print the node only if it is not visited yet
			if(!visitedSet.contains(removedNode)){
				System.out.print(removedNode.data + " ");
				visitedSet.add(removedNode);
			}
			
			// add the adjacent nodes of the 'removed' node to the queue
			for(GraphNode gNode : removedNode.adjNodes){
				queue.add(gNode);
			}
		}
		
	}
	
	static GraphNode getGraph(){
//		GraphNode n1 = new GraphNode(1);
//		GraphNode n2 = new GraphNode(2);
//		GraphNode n3 = new GraphNode(3);
//		GraphNode n4 = new GraphNode(4);
//		GraphNode n5 = new GraphNode(5);
//		GraphNode n6 = new GraphNode(6);
//		GraphNode n7 = new GraphNode(7);
//		GraphNode n8 = new GraphNode(8);
//		GraphNode n9 = new GraphNode(9);
//		GraphNode n10 = new GraphNode(10);
//		
//		n1.adjNodes.add(n2);
//		n1.adjNodes.add(n3);
//		n1.adjNodes.add(n4);
//		
//		n2.adjNodes.add(n5);
//		n2.adjNodes.add(n6);
//		
//		n3.adjNodes.add(n7);
//		n3.adjNodes.add(n8);
//		
//		
//		n4.adjNodes.add(n9);
//		n4.adjNodes.add(n10);
		
		// following setup is for a cyclic graph
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		
		n1.adjNodes.add(n2);
		n2.adjNodes.add(n1);
		
		return n1;
	}
}
