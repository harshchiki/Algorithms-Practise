package graphs;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
	final GraphNode start;
	private final Set<GraphNode> visitedNodes = new HashSet<>();
	
	DepthFirstSearch(final GraphNode node){
		this.start = node;
	}
	
	
	public void printDepthFirstSearch() {
		dfsUtil(this.start);
	}
	
	private void dfsUtil(GraphNode node) {
		if(node == null) return;
		
		if(!visitedNodes.contains(node)) {
			visitedNodes.add(node);
			System.out.println(node.data);
			node.adjNodes.stream().forEach(n -> dfsUtil(n));
		}
	}
	
	public static void main(String[] args) {
		GraphNode start = GraphUtils.getAcyclicGraph();
		DepthFirstSearch dfs = new DepthFirstSearch(start);
		dfs.printDepthFirstSearch();
	}
}
