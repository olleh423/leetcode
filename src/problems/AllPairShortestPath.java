package problems;

public class AllPairShortestPath {
	
	private int n;
	private int[][] adj;
	private boolean isDirected;
	
	private int INF = 999999;
	
	public AllPairShortestPath(int totalVertices, boolean isDirected) {
		
		this.n = totalVertices;
		this.adj = new int[n][n];
		this.isDirected = isDirected;
		
		for(int i=0 ; i < adj.length ; i++)
			for(int j=0 ; j < adj[i].length ; j++)
				adj[i][j] = i == j ? 0 : INF;
	}
	
	public void addEdge(int src, int dest, int weight) {
		
		adj[src-1][dest-1] = weight;
		if(!isDirected)
			adj[dest-1][src-1] = weight;
	}
	
	public void getAllPairShortestPath() {
		
		for(int k=0 ; k<n ; k++) {
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ; j<n ; j++) {
					adj[i][j] = adj[i][j] > adj[i][k] + adj[k][j] ? adj[i][k] + adj[k][j] : adj[i][j];
				}
			}
		}
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				System.out.print((adj[i][j] == INF ? "INF" : adj[i][j]) + "\t");;
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int totalVertices = 7;
		
		AllPairShortestPath obj = new AllPairShortestPath(totalVertices, false);
		
		obj.addEdge(1, 2, 1);
		obj.addEdge(1, 3, 1);
		obj.addEdge(1, 4, 1);
		obj.addEdge(1, 5, 1);
		obj.addEdge(1, 6, 1);
		obj.addEdge(1, 7, 1);
		
		obj.getAllPairShortestPath();
	}
}
