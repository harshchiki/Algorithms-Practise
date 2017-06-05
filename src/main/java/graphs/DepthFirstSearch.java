package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DepthFirstSearch {
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		
		n1.adjNodes.add(n2);
		n1.adjNodes.add(n3);
		
		n2.adjNodes.add(n4);
		
		n3.adjNodes.add(n5);
		
		new DepthFirstSearch().dfs(n1, new HashSet<GraphNode>());
		
	}
	
	public void dfs(GraphNode node, Set<GraphNode> visited){
		if(null == node){
			return;
		}
		
		if(!visited.contains(node)){
			System.out.print(node.data+" ");
			for(GraphNode n : node.adjNodes){
				dfs(n,visited);
			}
		}
	}
}
