package graphs;

public class KruskalMST {
	public static void main(String[] args) {
		
	}
	
	static void kruskalMST(Node[] v, Edge[] edges){
		
	}
	
	static class Node{
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	static class Edge{
		Node srcNode, destNode;
		int wt;
		Edge(Node src, Node dest, int wt){
			this.srcNode = src;
			this.destNode = dest;
			this.wt = wt;
		}
	}
}
