package graphs;

import java.util.ArrayList;
import java.util.List;

class GraphNode{
	int data;
	GraphNodeColor color = GraphNodeColor.WHITE;
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
	
//	@Override
//	public boolean equals(Object o){
//		return this.data == ((GraphNode) o).data;
//	}
	
	@Override
	public int hashCode(){
		return (Integer.valueOf(this.data)).hashCode();
	}
}