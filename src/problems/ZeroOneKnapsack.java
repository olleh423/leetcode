package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ZeroOneKnapsack {

	static class Item {
		int weight;
		int value;
		Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	private ArrayList<ArrayList<Integer>> solveDynamicIterative(int[][] items, int k) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if(items == null || items.length == 0 || items[0].length == 0)
			return result;
		
		int[][] DP = new int[items.length + 1][k + 1];
		for(int i=0 ; i<DP.length ; i++) {
			for(int j=0 ; j<DP[i].length ; j++) {
				if(i == 0 || j == 0) {
					DP[i][j] = 0;
				} else if(items[i-1][1] > j) {
					DP[i][j] = DP[i-1][j];
				} else {
					DP[i][j] = Math.max(DP[i-1][j], items[i-1][0] + DP[i-1][j - items[i-1][1]]);
				}
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int i = items.length, j = k;
		while(i > 0 && j > 0 && DP[i][j] != 0) {
			if(DP[i][j] != DP[i-1][j]) {
				stack.push(i-1);
				i--;
				j = j - items[i][1];
			} else {
				i--;
			}
		}
		
		ArrayList<Integer> totalValue = new ArrayList<>();
		totalValue.add(DP[items.length][k]);
		
		ArrayList<Integer> selectedItems = new ArrayList<>();
		while(!stack.isEmpty()) {
			selectedItems.add(stack.pop());
		}
		
		result.add(totalValue);
		result.add(selectedItems);
		
		return result;
	}
	
	/*
	 * recursive DP
	 */
	private int solveDynamicRecursive(Item[] items, int cap, int i, int[][] DP) {
		
		if(i == items.length || cap == 0)
			return 0;
		
		if(DP[cap][i] != -1)
			return DP[cap][i];
		
		if(items[i].weight > cap)
			DP[cap][i] = solveDynamicRecursive(items, cap, i+1, DP);
		else
			DP[cap][i] = Math.max(items[i].value + solveDynamicRecursive(items, cap - items[i].weight, i+1, DP), solveDynamicRecursive(items, cap, i+1, DP));
		
		return DP[cap][i];
	}
	
	/*
	 * recursive brute forces
	 */
	private int solve(Item[] items, int cap, int i) {
		
		if(i == items.length || cap == 0) 
			return 0;
		
		if(items[i].weight > cap)
			return solve(items, cap, i+1);
		
		return Math.max(items[i].value + solve(items, cap - items[i].weight, i+1), solve(items, cap, i+1));
	}
	
	public int knapSack(Item[] items, int capacity) {
		
		int[][] DP = new int[capacity + 1][items.length];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//int result = solve(items, capacity, 0);
		int result = solveDynamicRecursive(items, capacity, 0, DP);

		return result;
	}
	
	public static void main(String[] args) {
		
		int capacity = 25;
		Item[] items = new Item[12];
		
		items[0] = new Item(5, 14);
		items[1] = new Item(1, 10);
		items[2] = new Item(3, 12);
		items[3] = new Item(2, 16);
		items[4] = new Item(4, 20);
		items[5] = new Item(2, 24);
		items[6] = new Item(3, 18);
		items[7] = new Item(1, 10);
		items[8] = new Item(2, 17);
		items[9] = new Item(4, 25);
		items[10] = new Item(4, 45);
		items[11] = new Item(6, 28);
		
		/*
		int capacity = 4;
		Item[] items = new Item[4];
		
		items[0] = new Item(3, 100);
		items[1] = new Item(2, 20);
		items[2] = new Item(4, 60);
		items[3] = new Item(1, 40);
		*/
		
		ZeroOneKnapsack obj = new ZeroOneKnapsack();
		System.out.println("Maximum possible value : " + obj.knapSack(items, capacity));
		
		
		int[][] input= new int[4][2];
		input[0] = new int[]{1, 2};
		input[1] = new int[]{4, 3};
		input[2] = new int[]{5, 6};
		input[3] = new int[]{6, 7};
		
		int k = 10;
		System.out.println("Max possible : " + obj.solveDynamicIterative(input, k));
	}
}
