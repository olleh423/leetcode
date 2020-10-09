package problems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MinCostMultiStageGraph {

	private static class Vertex {
		
		String name;
		int minDistFromSrc;
		
		Vertex(String name) {
			this.name = name;
			this.minDistFromSrc = 0;
		}
		
		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Vertex)) return false;
			return this.hashCode() == obj.hashCode();
		}
		
		@Override
		public String toString() {
			return this.name;// + ", " + minDistFromSrc;
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
	
	private static class MultiStageGraph {
		
		Vertex[] vertices;
		List<Edge> edges;
		
		Map<Vertex, List<Edge>> indegreeMap;
		
		MultiStageGraph(Vertex[] vertices) {
			this.vertices = vertices;
			this.edges = new ArrayList<>();
			this.indegreeMap = new HashMap<>();
		}
		
		void addEdge(Vertex v1, Vertex v2, int weight) {
			
			Edge edge = new Edge(v1, v2, weight);
			edges.add(edge);

			if(indegreeMap.containsKey(v2)) {
				indegreeMap.get(v2).add(edge);
			} else {
				List<Edge> edgeList = new ArrayList<>();
				edgeList.add(edge);
				indegreeMap.put(v2, edgeList);
			}
		}
	}
	
	
	public static void calculateMinFromSourceToDist(MultiStageGraph graph, Vertex src, Vertex dest) {
		
		Map<Vertex, Vertex> routeTable = new HashMap<>();
		
		for(int i=0 ; i<graph.vertices.length ; i++) {
			
			Vertex v = graph.vertices[i];
			
			if(graph.indegreeMap.containsKey(v)) {
				
				List<Edge> inEdges = graph.indegreeMap.get(v);

				Edge minEdge = inEdges.get(getMinEdgeIndex(inEdges));
				minEdge.dest.minDistFromSrc = minEdge.src.minDistFromSrc + minEdge.weight;
				
				System.out.println(minEdge.dest + " ---- " + minEdge.src);
				
				routeTable.put(minEdge.dest, minEdge.src);
				
			} else {
				
				routeTable.put(v, null);				
			}
		}
				
		Vertex start = dest;
		while(start != null) {
			
			System.out.print(start.name + " <-- ");
			start = routeTable.get(start);
		}
		
		
		System.out.println("Minimum distance From " + src + " to " + dest + " is : " + dest.minDistFromSrc);
	}
	
	public static int getMinEdgeIndex(List<Edge> edges) {
		
		int minIndex = 0;
		int total = edges.get(0).src.minDistFromSrc + edges.get(0).weight;
		
		for(int i=0 ; i<edges.size() ; i++) {
			
			Edge e = edges.get(i);
			int eTotal = e.src.minDistFromSrc + e.weight;
		
			if(eTotal < total) {
				total = eTotal;
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public static void main(String[] args) {
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		Vertex G = new Vertex("G");
		Vertex H = new Vertex("H");
		Vertex I = new Vertex("I");
		Vertex J = new Vertex("J");
		Vertex K = new Vertex("K");
		Vertex L = new Vertex("L");
		
		Vertex[] vArr = {A, B, C, D, E, F, G, H, I, J, K, L};
		
		MultiStageGraph mGraph = new MultiStageGraph(vArr);
		
		mGraph.addEdge(A, B, 9);
		mGraph.addEdge(A, C, 7);
		mGraph.addEdge(A, D, 3);
		mGraph.addEdge(A, E, 2);
		mGraph.addEdge(B, F, 4);
		mGraph.addEdge(B, G, 2);
		mGraph.addEdge(B, H, 1);
		mGraph.addEdge(C, F, 2);
		mGraph.addEdge(C, G, 7);
		mGraph.addEdge(D, H, 11);
		mGraph.addEdge(E, G, 11);
		mGraph.addEdge(E, H, 8);
		mGraph.addEdge(F, I, 6);
		mGraph.addEdge(F, J, 5);
		mGraph.addEdge(G, I, 4);
		mGraph.addEdge(G, J, 3);
		mGraph.addEdge(H, J, 5);
		mGraph.addEdge(H, K, 6);
		mGraph.addEdge(I, L, 4);
		mGraph.addEdge(J, L, 2);
		mGraph.addEdge(K, L, 5);
		
		calculateMinFromSourceToDist(mGraph, A, L);
	}
}
