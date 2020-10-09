package problems;

public class PaintersPartitionProblem {
	
	//DP
	public static int part(int[] a, int n, int k, int res[][]) {
        
        if(k == 1) return sum(a, 0, n);
        
        if(res[k-1][n-1] != 0) return res[k-1][n-1];
        
        int min = Integer.MAX_VALUE;
        for(int i = n-1 ; i > 0 ; i--) {
            min = Integer.min(min, Integer.max(sum(a, i, n), part(a, i, k-1, res)));
        }
        res[k-1][n-1] = min;
        return min;
    }

	//Brute force
	public static int part(int[] a, int n, int k) {
        
        if(k == 1) return sum(a, 0, n);
        
        int min = Integer.MAX_VALUE;
        for(int i = n-1 ; i >= 0 ; i--) {
            min = Integer.min(min, Integer.max(sum(a, i, n), part(a, i, k-1)));
        }
        return min;
    }
    
    public static int sum(int[] a, int start, int end) {
        
        int total = 0;
        for(int i = start ; i < end ; i++)
            total += a[i];
        return total;
    }
	
	public static int minimumTimeToPaint(int[] walls, int nuOfPainters) {
		
		return part(walls, walls.length, nuOfPainters, new int[nuOfPainters][walls.length]);
		//return part(walls, walls.length, nuOfPainters);
	}
	
	public static void main(String[] args) {
		
		int[] walls = {5, 4, 11, 6, 9, 3, 12};
		int nuOfPainters = 3;
		System.out.println(minimumTimeToPaint(walls, nuOfPainters));
	}
}
