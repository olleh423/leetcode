package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BellmenFord {
	
	public void shortestPath(Graph graph, Vertex src) {
		
		Map<Vertex, Vertex> parent = new HashMap<>();
		
		src.distFromSource = 0;
		parent.put(src, null);
		
		for(int i=0 ; i<graph.verts.size() - 1 ; i++) {
			
			for(Edge edge : graph.edges) {
				
				relexEdge(edge, parent);
			}
		}
		
		System.out.println(parent);
	}
	
	public void relexEdge(Edge edge, Map<Vertex, Vertex> parent) {
		
		if(edge.src.distFromSource != Integer.MAX_VALUE && edge.src.distFromSource + edge.weight < edge.dest.distFromSource) {
			edge.dest.distFromSource = edge.src.distFromSource + edge.weight;
			parent.put(edge.dest, edge.src);
		}
	}

	private static class Vertex {
		
		String name;
		int distFromSource;
		
		Vertex(String name) {
			this.name = name;
			distFromSource = Integer.MAX_VALUE;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null || !(obj instanceof Vertex)) 
				return false;
			
			return this.hashCode() == obj.hashCode();
		}
	}
	
	private static class Edge {
		
		Vertex src, dest;
		int weight;
		
		Edge(Vertex src, Vertex dest, int weight) {
			
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	private static class Graph {
		
		Set<Vertex> verts;
		List<Edge> edges;
		
		Graph() {
			this.verts = new HashSet<>();
			this.edges = new ArrayList<>();
		}
		
		void addEdge(Edge e) {
			
			verts.add(e.src);
			verts.add(e.dest);
			edges.add(e);
		}
	}
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		
		graph.addEdge(new Edge(A, B, 8));
		graph.addEdge(new Edge(B, C, 2));
		graph.addEdge(new Edge(C, B, 1));
		graph.addEdge(new Edge(A, D, 5));
		graph.addEdge(new Edge(E, D, -3));
		graph.addEdge(new Edge(A, E, 4));
		graph.addEdge(new Edge(D, C, 4));
		
		BellmenFord bf = new BellmenFord();
		bf.shortestPath(graph, A);
	}
}
