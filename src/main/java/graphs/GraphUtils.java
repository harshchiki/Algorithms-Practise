package graphs;

public class GraphUtils {
	public static GraphNode getGraph(){
		return getAcyclicGraph();
	}
	
	public static GraphNode getCyclicGraph() {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		
		n1.adjNodes.add(n2);
		n2.adjNodes.add(n1);
		
		return n1;
	}

	public static GraphNode getAcyclicGraph() {
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
