package problems;

public class GraphHamiltonianCycle {
	
	public void hamiltonian(int[][] AM, int[] verts, int[] res, int current) {
		
		if(current == verts.length) return;
		
		addVertexToCycle(AM, verts, res, current);
		
		if(res[current] == -1) 
			return;
		
		if(res[current] != 0 && current == verts.length-1) {
			printCycle(res);
			res[current] = 0;
		}
		
		hamiltonian(AM, verts, res, ++current);
	}
	
	public void addVertexToCycle(int[][] AM, int[] verts, int[] res, int current) {
		
		for(int i=0 ; i<verts.length ; i++) {
			
			boolean isVExists = false;
			
			for(int j=0 ; j<current ; j++) {
				if(verts[i] == res[j]) {
					isVExists = true;
					break;
				}
			}
			
			if(!isVExists && AM[i-1][i] == 1) {
				
				res[current] = verts[i];
				
				if(i == verts.length-1 && AM[verts.length-1][0] != 1) 
					res[current] = -1;
				
				break;
			}
		}
	}
	
	private void printCycle(int[] res) {
		
		for(int n : res)
			System.out.print(n + " -> ");
		System.out.println(res[0]);
	}
	
	public static void main(String[] args) {
		
		int[][] AM	= {{0, 1, 1, 0, 1}, 
					   {1, 0, 1, 0, 1}, 
					   {1, 1, 0, 1, 0}, 
					   {0, 0, 1, 0, 1}, 
					   {1, 1, 0, 1, 0}};
		
		int[] verts = {0, 1, 2, 3, 4};
		int[] res = {0, -1, -1, -1, -1};
		int current = 1;
		
		GraphHamiltonianCycle hc = new GraphHamiltonianCycle();
		hc.hamiltonian(AM, verts, res, current);
	}
}
