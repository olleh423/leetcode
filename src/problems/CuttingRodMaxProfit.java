package problems;

public class CuttingRodMaxProfit {

	//w = weight, v = values to the corresponding weight, n = length of rod
	public int calculateMaxProfit(int[] w, int[] v, int n) {
		
		int[][] results = new int[w.length][n+1];
		
		for(int i=0 ; i<w.length && i<v.length ; i++) {
			
			for(int j=0 ; j<=n ; j++) {

				if(j == 0) results[i][j] = 0;
				
				if(i == 0) 
					results[i][j] = v[i] * (j / w[i]);
				
				else if(j < w[i]) 
					results[i][j] = results[i-1][j];
				
				else {
					int profit = (v[i] * (j / w[i])) + results[i-1][j % w[i]];
					results[i][j] = profit > results[i-1][j] ? profit : results[i-1][j];
				}
			}
		}
		
		return results[w.length-1][n];
	}
	
	public static void main(String... args) {
		
		int n = 8;
		int[] w = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] v = {1, 5, 8, 9, 10, 17, 17, 20};
		
		CuttingRodMaxProfit cutRod = new CuttingRodMaxProfit();
		System.out.println("Maximum profit is : " + cutRod.calculateMaxProfit(w, v, n));
	}
}
