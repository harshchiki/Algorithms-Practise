package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 *  Shortest path from a source node to all nodes in a graph (of course which can be reachable)
 */
public class DijkstraShortesPathAlgorithm {

	List<Vertex> nodes;
	List<Edge> edges;
	Set<Vertex> settled = new HashSet<>();
	Set<Vertex> unsettled = new HashSet<>();
	Map<Vertex, Vertex> parents = new HashMap<>(); // to get parent of a vertex (to get shortest path, while it is traced back)
	Map<Vertex, Integer> distance = new HashMap<>(); // distance from the source configured.

	DijkstraShortesPathAlgorithm(List<Vertex> vertices, List<Edge> edges){
		this.nodes = vertices;
		this.edges = edges;
	}


	public void execute(Vertex source) {
		distance.put(source, Integer.valueOf(0));

		unsettled.add(source);

		while(unsettled.size() > 0) {
			// get the node with the minimum distance marked from the unsetlled nodes
			Vertex node = getMinimum(unsettled);

			// settle the fetched node
			settled.add(node);

			// remove the settled node from unsettled node
			unsettled.remove(node);

			// find minimal distances - update distance and parent values of adjacent nodes, and on change add to the unsettled nodes.
			// finally the unsettled nodes have to be empty (none)
			findMinimalDistances(node);
		}
	}

	// this node was the node which had the minimum distance amongst the unsettled nodes
	// so was picked, being 'GREEDY' (Dijkstra is a greedy algo)
	private void findMinimalDistances(Vertex node) {
		// get all adjacent nodes
		List<Vertex> adjacentNodes = getNeighbors(node);

		// for each adjacent node of the just settled node
		for (Vertex target : adjacentNodes) {

			// modify the distance values.
			// if the adjacent node is having distance value greater than
			// the sum of distance of this settled node and the distance between
			// this settled node the neighbour, update the distance, and update the parent
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {
				distance.put(target, getShortestDistance(node)
						+ getDistance(node, target));
				parents.put(target, node);
				// add the target to unsettled (who's parent and distance had just been updated)
				unsettled.add(target);
			}
		}
	}

	// look up for the edge iterating over edges with node as source and target as destination
	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.source.equals(node)
					&& edge.destination.equals(target)) {
				return edge.weight;
			}
		}
		throw new RuntimeException("Should not happen");
	}

	// iteratre through edges, and return the list of nodes which are destinations
	// in edges with node as source
	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.source.equals(node)
					&& !isSettled(edge.destination)) {
				neighbors.add(edge.destination);
			}
		}
		return neighbors;
	}

	// TODO: Ideally this should be improved, by using a min heap
	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Vertex vertex) {
		return settled.contains(vertex);
	}

	// distance map should be returning me the value of the distance
	// if not present in the distance map, it is assumed INTEGER.MAX_VALUE as per the Disjkstra's algorithm
	private int getShortestDistance(Vertex destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (parents.get(step) == null) {
			return null;
		}
		path.add(step);
		while (parents.get(step) != null) {
			step = parents.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}



	static class Vertex{
		String id, name;

		Vertex(String id, String name){
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	static class Edge{
		public Vertex source, destination;
		public int weight;
		Edge(Vertex source, Vertex dest, int wt){
			this.source = source;
			this.destination = dest;
			this.weight = wt;
		}
	}

	class Graph{
		public List<Vertex> vertices;
		public List<Edge> edges;
		public Graph(List<Vertex> vertices, List<Edge> edges) {
			super();
			this.vertices = vertices;
			this.edges = edges;
		}
		public List<Vertex> getVertices() {
			return vertices;
		}
		public List<Edge> getEdges() {
			return edges;
		}
	}
	public static void main(String[] args) {
		List<Vertex> nodes;
		List<Edge> edges;


		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		addLane("Edge_0", 0, 1, 85, nodes, edges);
		addLane("Edge_1", 0, 2, 217, nodes, edges);
		addLane("Edge_2", 0, 4, 173, nodes, edges);
		addLane("Edge_3", 2, 6, 186, nodes, edges);
		addLane("Edge_4", 2, 7, 103, nodes, edges);
		addLane("Edge_5", 3, 7, 183, nodes, edges);
		addLane("Edge_6", 5, 8, 250, nodes, edges);
		addLane("Edge_7", 8, 9, 84, nodes, edges);
		addLane("Edge_8", 7, 9, 167, nodes, edges);
		addLane("Edge_9", 4, 9, 502, nodes, edges);
		addLane("Edge_10", 9, 10, 40, nodes, edges);
		addLane("Edge_11", 1, 10, 600, nodes, edges);

		// Lets check from location Loc_1 to Loc_10
		DijkstraShortesPathAlgorithm dijkstra = new DijkstraShortesPathAlgorithm(nodes, edges);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));


		for (Vertex vertex : path) {
			System.out.println(vertex);
		}



	}


	static void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration, List<Vertex> nodes, List<Edge> edges) {
		Edge lane = new Edge(nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
		edges.add(lane);
	}
}
