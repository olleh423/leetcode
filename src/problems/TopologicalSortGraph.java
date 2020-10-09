package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSortGraph {

	//It should only be performed on Directed Acyclic Graph
	public void topologicalSort(Graph graph) {
		
		Set<String> marked = new HashSet<>();
		Stack<String> result = new Stack<>();
		
		for(String vertex : graph.verts) 
			exploreVertex(vertex, graph, marked, result);
		
		System.out.println("Topological Sorted Order : ");
		while(! result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}
	
	private void exploreVertex(String vertex, Graph graph, Set<String> marked, Stack<String> result) {
				
		List<Edge> outEdges = graph.outGoingEdges.get(vertex);
		
		if(outEdges == null || outEdges.size() == 0) { 			
			
			result.push(vertex);
			marked.add(vertex);
			return;
		}
		
		for(Edge e : outEdges) {
			
			if(!marked.contains(e.dest)) {
				exploreVertex(e.dest, graph, marked, result);
			}
		}
		
		result.push(vertex);
		marked.add(vertex);
	}
	
	private static class Edge {
		
		String src, dest;
		
		Edge(String src, String dest) {
			this.src = src;
			this.dest = dest;
		}
		
		@Override
		public String toString() {
			return this.src + " to " + this.dest;
		}
		
		@Override
		public int hashCode() {
			return "From".hashCode() + this.src.hashCode() + "To".hashCode() + this.dest.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null || !(obj instanceof Edge)) 
				return false;
			
			return this.hashCode() == obj.hashCode();
		}
	}
	
	private static class Graph {
		
		Set<String> verts;
		Set<Edge> edges;
		Map<String, List<Edge>> outGoingEdges;
		
		Graph() {
			this.verts = new HashSet<>();
			this.edges = new HashSet<>();
			outGoingEdges = new HashMap<>();
		}
		
		void addEdge(Edge edge) {
			
			verts.add(edge.src);
			verts.add(edge.dest);
			edges.add(edge);
			
			if(outGoingEdges.containsKey(edge.src)) {
				outGoingEdges.get(edge.src).add(edge);
			} else {
				List<Edge> edges = new ArrayList<>();
				edges.add(edge);
				outGoingEdges.put(edge.src, edges);
			}
		}
	}
	
	//Driver method
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		graph.addEdge(new Edge("0", "1"));
		graph.addEdge(new Edge("0", "2"));
		graph.addEdge(new Edge("1", "3"));
		graph.addEdge(new Edge("2", "3"));
		//graph.addEdge(new Edge("D", "E"));
		//graph.addEdge(new Edge("D", "B"));
		//graph.addEdge(new Edge("E", "G"));
		//graph.addEdge(new Edge("G", "H"));
				
		TopologicalSortGraph topSort = new TopologicalSortGraph();
		topSort.topologicalSort(graph);
	}
}
