package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstras {	
	
	public void shortestPath(Graph graph, Vertex src) {
		
		src.distanceFromSource = 0;

		Map<Vertex, Vertex> routeMap = new HashMap<>();
		routeMap.put(src, null);
		
		while(! graph.verts.isEmpty()) {
			
			Vertex min = extracMin(graph.verts);
			List<Edge> outEdges = graph.outEdges.get(min);
			
			for(Edge e : outEdges) {
				
				int thisDist = e.src.distanceFromSource + e.weight;
				if(e.dest.distanceFromSource > thisDist) {
					e.dest.distanceFromSource = thisDist;
					routeMap.put(e.dest, e.src);
				}
			}
			
			graph.verts.remove(min);
		}
		
		System.out.println(routeMap);
	}
	
	public Vertex extracMin(Set<Vertex> verts) {
		
		Vertex min = null;
		for(Vertex v : verts) {
			if(min == null) min = v;
			else min = min.distanceFromSource > v.distanceFromSource ? v : min;
		}
		return min;
	}
	
	private static class Vertex {
		
		String name;
		int distanceFromSource;
		
		Vertex(String name) {
			this.name = name;
			this.distanceFromSource = Integer.MAX_VALUE;
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
		
		@Override
		public String toString() {
			
			return this.src + " -> " + this.dest;
		}
	}
	
	private static class Graph {
		
		Set<Vertex> verts;
		Set<Edge> edges;
		Map<Vertex, List<Edge>> outEdges;

		Graph() {
			this.verts = new HashSet<>();
			this.edges = new HashSet<>();
			this.outEdges = new HashMap<>();
		}
		
		void addEdge(Vertex src, Vertex dest, int weight) {
			
			verts.add(src);
			verts.add(dest);

			Edge e1 = new Edge(src, dest, weight);
			Edge e2 = new Edge(dest, src, weight);

			edges.add(e1);
			edges.add(e2);
			
			if(outEdges.containsKey(e1.src)) {
				outEdges.get(e1.src).add(e1);
			} else {
				List<Edge> edges = new ArrayList<>();
				edges.add(e1);
				outEdges.put(e1.src, edges);
			}
			
			if(outEdges.containsKey(e2.src)) {
				outEdges.get(e2.src).add(e2);
			} else {
				List<Edge> edges = new ArrayList<>();
				edges.add(e2);
				outEdges.put(e2.src, edges);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		
		graph.addEdge(A, B, 2);
		graph.addEdge(B, C, 5);
		graph.addEdge(A, D, 9);
		graph.addEdge(A, F, 2);
		graph.addEdge(E, D, 2);
		graph.addEdge(F, E, 3);
		graph.addEdge(C, D, 3);
				
		Dijkstras di = new Dijkstras();
		di.shortestPath(graph, A);
	}
}
