package graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrimMST {

	Node n0 = new Node(0);
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);
	Node n5 = new Node(5);
	Node n6 = new Node(6);
	Node n7 = new Node(7);
	Node n8 = new Node(8);

	//	Node[] vertices = new Node[]{n0,n1,n2,n3,n4,n5,n6,n7,n8};
	List<Node> vertices = new LinkedList<Node>();


	Edge n01 = new Edge(n1, n1, 4);
	Edge n07 = new Edge(n0, n7, 8);
	Edge n17 = new Edge(n1, n7, 4);
	Edge n12 = new Edge(n1, n2, 8);
	Edge n78 = new Edge(n7, n8, 7);
	Edge n86 = new Edge(n8, n6, 6);
	Edge n76 = new Edge(n7, n6, 1);
	Edge n28 = new Edge(n2, n8, 2);
	Edge n65 = new Edge(n6, n5, 2);
	Edge n25 = new Edge(n2, n5, 4);
	Edge n23 = new Edge(n2, n3, 7);
	Edge n35 = new Edge(n3, n5, 14);
	Edge n34 = new Edge(n3, n4, 9);
	Edge n54 = new Edge(n5, n4, 10);

	Map<String, Integer> weight = new HashMap<>();

	PrimMST(){
		n0.adjacentNodes.add(n1);
		n0.adjacentNodes.add(n7);

		n1.adjacentNodes.add(n0);
		n1.adjacentNodes.add(n1);
		n1.adjacentNodes.add(n2);

		n7.adjacentNodes.add(n0);
		n7.adjacentNodes.add(n1);
		n7.adjacentNodes.add(n8);
		n7.adjacentNodes.add(n6);

		n2.adjacentNodes.add(n1);
		n2.adjacentNodes.add(n8);
		n2.adjacentNodes.add(n5);
		n2.adjacentNodes.add(n3);

		n8.adjacentNodes.add(n7);
		n8.adjacentNodes.add(n2);
		n8.adjacentNodes.add(n6);

		n6.adjacentNodes.add(n8);
		n6.adjacentNodes.add(n7);
		n6.adjacentNodes.add(n5);

		n5.adjacentNodes.add(n6);
		n5.adjacentNodes.add(n2);
		n5.adjacentNodes.add(n3);
		n5.adjacentNodes.add(n4);

		n3.adjacentNodes.add(n2);
		n3.adjacentNodes.add(n5);
		n3.adjacentNodes.add(n4);

		n4.adjacentNodes.add(n3);
		n4.adjacentNodes.add(n5);

		vertices.add(n0);
		vertices.add(n1);
		vertices.add(n2);
		vertices.add(n3);
		vertices.add(n4);
		vertices.add(n5);
		vertices.add(n6);
		vertices.add(n7);
		vertices.add(n8);


		weight.put("01", Integer.valueOf(n01.weight));
		weight.put("10", Integer.valueOf(n01.weight));
		weight.put("07", Integer.valueOf(n07.weight));
		weight.put("70", Integer.valueOf(n07.weight));
		weight.put("17", Integer.valueOf(n17.weight));
		weight.put("71", Integer.valueOf(n17.weight));
		weight.put("12", Integer.valueOf(n12.weight));
		weight.put("21", Integer.valueOf(n12.weight));
		weight.put("78", Integer.valueOf(n78.weight));
		weight.put("87", Integer.valueOf(n78.weight));
		weight.put("86", Integer.valueOf(n86.weight));
		weight.put("68", Integer.valueOf(n86.weight));
		weight.put("76", Integer.valueOf(n76.weight));
		weight.put("67", Integer.valueOf(n76.weight));
		weight.put("28", Integer.valueOf(n28.weight));
		weight.put("82", Integer.valueOf(n28.weight));
		weight.put("65", Integer.valueOf(n65.weight));
		weight.put("56", Integer.valueOf(n65.weight));
		weight.put("25", Integer.valueOf(n25.weight));
		weight.put("52", Integer.valueOf(n25.weight));
		weight.put("23", Integer.valueOf(n23.weight));
		weight.put("32", Integer.valueOf(n23.weight));
		weight.put("35", Integer.valueOf(n35.weight));
		weight.put("53", Integer.valueOf(n35.weight));
		weight.put("34", Integer.valueOf(n34.weight));
		weight.put("43", Integer.valueOf(n34.weight));
		weight.put("54", Integer.valueOf(n54.weight));
		weight.put("45", Integer.valueOf(n54.weight));
	}

	void primMinimumSpanningTree(){
		n0.key = 0;
		n0.parent = null;
		int noOfVertices = vertices.size();

		sort(vertices);

		int countOfVerticesIncluded = 0;

		while(countOfVerticesIncluded < noOfVertices){
			Node vertex = vertices.get(0);
			vertices.remove(vertex);

			for(Node adjNode : vertex.adjacentNodes){
				int weightOfVertexToAdjNode = weight.get(String.valueOf(vertex.data) + String.valueOf(adjNode.data));
				if(weightOfVertexToAdjNode < adjNode.key){
					adjNode.parent = vertex;
					adjNode.key = weightOfVertexToAdjNode;
				}
			}
		}

	}


	void sort(List<Node> nodes){
		Collections.sort(nodes);

		// Bubble Sort
		//		for(int i = 0;i< nodes.length-1;i++){
		//			// last i nodes are already sorted
		//			for(int j = 0;j< nodes.length - i - 1;j++){
		//				// sorted based on key not data
		//				if(nodes[j].key > nodes[j+1].key){
		//					Node tmp  = nodes[j];
		//					nodes[j] = nodes[j+1];
		//					nodes[j+1] = tmp;
		//				}
		//			}
		//		}
	}

	public static void main(String[] args) {
		PrimMST prim = new PrimMST();

	}



	static class Edge{
		Node src, dest;
		int weight;
		Edge(Node src, Node dest, int weight){
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		/*
		 * For undirected graph - back and forth mean the same
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object o){
			Edge other = (Edge) o;
			if((other.src.equals(this.src) && other.dest.equals(other.dest))
					|| (other.dest.equals(this.src) && other.src.equals(this.dest))){
				return true;
			}else{
				return false;
			}
		}

	}
}



class Node implements Comparable<Node>{
	public int data;	
	public int key = 1000; // integer max
	public Node parent = null;
	public List<Node> adjacentNodes = new LinkedList<Node>();

	public Node(int data){
		this.data = data;
	}

	@Override
	public boolean equals(Object o){
		Node other = (Node) o;
		return this.data == other.data;
	}

	@Override
	public int compareTo(Node o) {
		if(this.key == o.key){
			return 0;
		}

		if(this.key > o.key){
			return 1;
		}

		if(this.key < o.key){
			return -1;
		}

		return -1;
	}
}