package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphColoring {
	
	public boolean colorGraph(Graph graph, int m) {
		
		for(Vertex v : graph.verts) {
			
			for(int i = 1 ; i <= m ; i++) {
				
				if(fillVertex(graph, v, i)) {
					v.color = i;
					break;
				}
			}
		}

		for(Vertex v : graph.verts) {
			if(v.color == 0) return false;
		}
		
		return true;
	}
	
	private boolean fillVertex(Graph graph, Vertex v, int color) {
		
		for(Edge e : graph.outEdges.get(v)) {
			if(e.dest.color == color) return false;
		}
		return true;
	}

	private static class Vertex {
		
		int data;
		int color;
		
		Vertex(int data) {
			this.data = data;
			this.color = 0;
		}
		
		@Override
		public String toString() {
			return this.data + " - " + this.color;
		}
	}
	
	private static class Edge {
		
		Vertex src, dest;
		
		Edge(Vertex src, Vertex dest) {
			this.src = src;
			this.dest = dest;
		}
		
		@Override
		public String toString() {
			return this.src + " --> " + this.dest;
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
		
		void addEdge(Vertex src, Vertex dest) {
			
			verts.add(src);
			verts.add(dest);
			
			Edge e1 = new Edge(src, dest);
			Edge e2 = new Edge(dest, src);
			
			edges.add(e1);
			edges.add(e2);
			
			if(outEdges.containsKey(src)) {
				outEdges.get(src).add(e1);
			} else {
				List<Edge> srcList = new ArrayList<>();
				srcList.add(e1);
				outEdges.put(src, srcList);
			}
			
			if(outEdges.containsKey(dest)) {
				outEdges.get(dest).add(e2);
			} else {
				List<Edge> destList = new ArrayList<>();
				destList.add(e2);
				outEdges.put(dest, destList);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		int m = 3;
		
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		
		graph.addEdge(one, two);
		graph.addEdge(two, three);
		graph.addEdge(three, four);
		graph.addEdge(four, five);
		graph.addEdge(five, one);
		graph.addEdge(one, three);
		graph.addEdge(one, four);
		
		GraphColoring gc = new GraphColoring();
		boolean isPossible = gc.colorGraph(graph, m);
		
		if(isPossible) {
			for(Vertex v : graph.verts) {
				System.out.println("Vertex = " + v.data + " --> Color = " + v.color);
			}
		} else {
			System.out.println("Coloring not possible, more colors required.");
		}
	}
}
