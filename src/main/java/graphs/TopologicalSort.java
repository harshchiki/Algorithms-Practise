package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * Time complexity: O(V+E)
 */
public class TopologicalSort {
	
	public static void main(String[] args) {
		TopologicalSort topSort = new TopologicalSort();
		
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n5.adjacentNodes.add(n2);
		n5.adjacentNodes.add(n0);
		
		n4.adjacentNodes.add(n0);
		n4.adjacentNodes.add(n1);
		
		n2.adjacentNodes.add(n3);
		
		n3.adjacentNodes.add(n1);
		
		topSort.topologicalSort(new Node[]{n0, n1, n2, n3, n4, n5});
		
	}

	void topologicalSort(Node[] nodes){
		/* this stack contains nodes in the order of topological sort */
		Stack<Node> stack = new Stack<>();
		
		/* set to remember which nodes have been visited already*/
		Set<Node> visited = new HashSet<Node>();
		
		
		for(int i = 0;i<nodes.length;i++){
			if(!visited.contains(nodes[i])){
				topSortUtil(nodes[i], stack, visited);
			}
		}
		
		/*printing the topological sort order*/
		while(!stack.isEmpty()){
			System.out.print(stack.pop().data+", ");
		}
		
	}
	
	void topSortUtil(Node node, Stack<Node> stack, Set<Node> visited){
		visited.add(node);
		
		List<Node> adjacentNodes = node.adjacentNodes;
		
		for(Node n : adjacentNodes){
			if(!visited.contains(n)){
				topSortUtil(n, stack, visited);
			}
		}
		
		stack.push(node);
		
	}
	
	static class Node{
		int data;
		List<Node> adjacentNodes = new LinkedList<Node>();
		Node(int data){
			this.data = data;
		}
		
		@Override
		public boolean equals(Object o){
			Node other = (Node) o;
			return this.data == other.data;
		}
	}
}
