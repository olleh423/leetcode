package problems;

/*

	Ad-optimization team is moving to their new office Safina Towers :) . 
	But the problem is Safina towers don't have furniture, but you have wood-sheet. 
	You are given a wood-sheet of length L . Since everyone wants to create their desk in 
	their own style you have to give them some amount of wood. So, you are given N mark-down points 
	(since ad-optimization team have n members) from that points you have to cut the wood sheet. 
	But the problem is wood-cutter will cost (X * left) + (Y * right) for cutting the 
	wood (where left and right is the size of the remaining parts of the wood after cutting). 
	For example you want to cut a wood sheet of length 10 and X=3 and Y=4 and you want to cut 
	at point 7 then left segment size = (7-1) =6 and 
	right segment size = (10-7) = 3 then wood cutter will cost 3 * 6+4 * 3 = 30 .
	
	As Amazonian you have to follow frugality leadership principal, 
	you want to give wood cutter a minimum amount of money and want to cut 
	wood-sheet from every marking point between 1 to L (exclusive ) . 
	please note that in all the test case first mark point=1 and last mark point = size of sheet (L). 
	Please output minimum amount of money needed for every test case.
	
	Input Format: T: number of test cases (1<=T<=5) For each test case:
	first line contains X and Y.(X: multiplier for left segment ,Y : multiplier for right segment) 2<=X<=100 2<=Y<=100
	Second line Contains N: Number of marking points (2<=N<=100)
	Third line contains marking point : m(0),m(1) ..... , m(n-1) marking points on wood sheet ,
	where m(0)=1 and m(n-1) = L where 2<=L<=200000
	
	Output : For each test case : Minimum amount of money you have to pay to wood cutter. 
	Each test case answer must be printed on a new line
 
 */

public class WoodCuttingDP {
	
	public static void main(String[] args) {
		
		int x = 3, y = 4;
		int arr[] = {1, 3, 5, 9, 16, 22, 36, 55, 78, 98, 100};
		
		System.out.println(cut(x, y, arr));
	}
	
	public static int cut(int x, int y, int[] arr) {

		int[][] DP = new int[arr.length][arr.length];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//return cut(0, arr.length - 1, arr, x, y);
		return cutDP(0, arr.length - 1, arr, x, y, DP);
	}
	
	//Brute force
	private static int cut(int s, int e, int[] arr, int x, int y) {
		
		if(s + 1 >= e)
			return 0;
		
		int res = Integer.MAX_VALUE;
		for(int i = s+1 ; i < e ; i++) {
			
			int cost = x * (arr[i] - arr[s]) + y * (arr[e] - arr[i]) + cut(s, i, arr, x, y) + cut(i, e, arr, x, y);
			res = cost < res ? cost : res;
		}
		
		return res;
	}
	
	//DP
	private static int cutDP(int s, int e, int[] arr, int x, int y, int[][] DP) {
		
		if(s + 1 >= e)
			return 0;
		
		if(DP[s][e] != -1)
			return DP[s][e];
		
		int res = Integer.MAX_VALUE;
		for(int i = s+1 ; i < e ; i++) {
			
			int cost = x * (arr[i] - arr[s]) + y * (arr[e] - arr[i]) + cutDP(s, i, arr, x, y, DP) + cutDP(i, e, arr, x, y, DP);
			res = cost < res ? cost : res;
		}
		
		DP[s][e] = res;
		return res;
	}
}
