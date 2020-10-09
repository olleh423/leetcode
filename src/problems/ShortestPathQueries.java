package problems;

public class ShortestPathQueries {

	public static int getShortest(int[][] arr, int n, int src, int dest, int[] DP) {
		
		if(arr[src][dest] == 1)
			return 1;
		
		if(DP[src] != -1)
			return DP[src];
		
		int min = Integer.MAX_VALUE, nuOfPaths = 0;
		for(int i=0 ; i<n ; i++) {
			
			if(arr[src][i] == 1) {
				
				int path = 1 + getShortest(arr, n, i, dest, DP);
				if(path < min) {
					min = path;
					nuOfPaths = 1;
				} 
				else if(path == min)
					nuOfPaths++;
			}
		}
		
		DP[src] = nuOfPaths;
		return nuOfPaths;
	}
	
	public static int getShortest(int[][] arr, int n, int src, int dest) {
		
		if(arr[src][dest] == 1)
			return 1;
		
		int min = Integer.MAX_VALUE, nuOfPaths = 0;
		for(int i=0 ; i<n ; i++) {
			
			if(arr[src][i] == 1) {
				
				int path = 1 + getShortest(arr, n, i, dest);
				if(path < min) {
					min = path;
					nuOfPaths = 1;
				} 
				else if(path == min)
					nuOfPaths++;
			}
		}
		
		return nuOfPaths;
	}

	public static int getMinPaths(int[][] adj, int n, int src, int dest) {
		
		int[] DP = new int[n];
		for(int i=0 ; i<DP.length ; i++)
			DP[i] = -1;
		
		
		int paths = getShortest(adj, n, src, dest, DP);
		return paths;
	}
	
	public static void main(String[] args) {
		
		int[][] arr = {	{0, 1, 1, 1, 0},
						{1, 0, 0, 0, 1},
						{1, 0, 0, 0, 1},
						{1, 0, 0, 0, 1},
						{0, 1, 1, 1, 0}};
		
		System.out.println(getMinPaths(arr, 5, 0, 4));
		System.out.println(getMinPaths(arr, 5, 2, 3));
	}
}
