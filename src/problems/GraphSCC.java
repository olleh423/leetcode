package problems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GraphSCC {
	
	private static class Edge {
		
		String src, dest;
		boolean isDirected;
		
		Edge(String src, String dest, boolean isDirected) {
			
			this.src = src;
			this.dest = dest;
			this.isDirected = isDirected;
		}
		
		@Override
		public String toString() {
			return src + " --> " + dest;
		}
	}
	
	private static class Graph {
		
		Set<String> verts;
		Set<Edge> edges;
		Map<String, List<Edge>> outEdges;		
		boolean isDirected;
		
		Graph(boolean isDirected) {
			
			this.isDirected = isDirected;
			this.verts = new HashSet<>();
			this.edges = new HashSet<>();
			this.outEdges = new HashMap<String, List<Edge>>();
		}
		
		void addEdge(String src, String dest) {
			
			verts.add(src);
			verts.add(dest);
			
			Edge ed = new Edge(src, dest, isDirected);
			edges.add(ed);
		}
	}
	
	
	public static void findSSCs(Graph graph) {
		
		
	}
	
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(true);		
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "A");
		graph.addEdge("B", "D");
		graph.addEdge("D", "E");
		graph.addEdge("E", "F");
		graph.addEdge("F", "D");
		graph.addEdge("G", "F");
		graph.addEdge("G", "H");
		graph.addEdge("H", "I");
		graph.addEdge("I", "J");
		graph.addEdge("J", "K");
		graph.addEdge("J", "G");
		
		findSSCs(graph);
	}
}
