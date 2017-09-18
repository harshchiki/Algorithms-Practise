package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DepthFirstSearchWithCycleDetection {
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		
		n1.adjNodes.add(n2);
		n1.adjNodes.add(n3);
		
		n2.adjNodes.add(n4);
		n2.adjNodes.add(n1);
		
		n3.adjNodes.add(n5);
		
		new DepthFirstSearchWithCycleDetection().dfs(n1, new HashSet<GraphNode>());
		
	}
	
	public void dfs(GraphNode node, Set<GraphNode> visited){
		if(null == node){
			return;
		}
		
		
		if(!visited.contains(node)){
			visited.add(node);
			System.out.print(node.data+" ");
			for(GraphNode n : node.adjNodes){
				dfs(n,visited);
			}
		}
	}
	
	public void dfsForCycleDetection(GraphNode node, Set<GraphNode> visited){
		if(null == node){
			return;
		}
		
		
		if(!visited.contains(node)){
			visited.add(node);
			System.out.print(node.data+" ");
			for(GraphNode n : node.adjNodes){
				dfs(n,visited);
			}
		}else{
			// the moment a visited node is visited again
			// it indicates a cycle
			System.out.println();
			System.out.println("Presence of cycle at "+node.data);
		}
	}
}
