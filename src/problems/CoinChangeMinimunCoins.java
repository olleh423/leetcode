package problems;

public class CoinChangeMinimunCoins {

	public void showMinCoins(int[] coins, int total) {
		
		int[] arr = new int[total+1];
		int[] res = new int[total+1];
		
		for(int i=0 ; i<=total ; i++) {
			arr[i] = i == 0 ? 0 : Integer.MAX_VALUE - 1;
			res[i] = -1;
		}
		
		for(int i=0 ; i<coins.length ; i++) {
			
			for(int j=1 ; j <= total ; j++) {
				
				if(j >= coins[i]) {
					int prev = arr[j];
					arr[j] = Integer.min(arr[j], 1 + arr[j - coins[i]]);
					if(arr[j] != prev) res[j] = i;
				}
			}
		}
				
		while(total > 0) {
			if(res[total] != -1) {
				System.out.print(coins[res[total]] + " ");
				total -= coins[res[total]];
			} else {
				System.out.println("Unable to form amount with given coins");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*int[] coins = {100, 500, 2000, 5, 10, 20, 50, 1};
		int total = 32505;*/
		
		int[] coins = {1, 2, 3};
		int total = 40;
		
		CoinChangeMinimunCoins obj = new CoinChangeMinimunCoins();
		obj.showMinCoins(coins, total);
	}
}
