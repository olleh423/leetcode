package problems;

import java.util.LinkedList;
import java.util.Queue;

/*
	Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
	0: Empty cell
	1: Cells have fresh oranges
	2: Cells have rotten oranges 
	Determine what is the minimum time required so that all the oranges become rotten. 
	A rotten orange at index [i,j] can rot other fresh orange at 
	indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
	If it is impossible to rot every orange then simply return -1.
*/

public class RottonOranges {

	private class Orange {
		int x, y, dist;
		Orange(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	private boolean isValid(int rows, int cols, int i, int j) {

		return !(i < 0 || i >= rows || j < 0 || j >= cols);
	}
	
	public int getMinTimeToRotAllOranges(int[][] grid, int m, int n) {
		
		if(grid == null)
			return -1;
		
		Queue<Orange> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Orange(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		int result = 0;
		while(!queue.isEmpty()) {
			
			Orange or = queue.poll();
			result = Math.max(result, or.dist);
			
			if(isValid(m, n, or.x - 1, or.y) && !visited[or.x - 1][or.y] && grid[or.x - 1][or.y] == 1) {
				queue.add(new Orange(or.x - 1, or.y, or.dist + 1));
				visited[or.x - 1][or.y] = true;
			}
			
			if(isValid(m, n, or.x + 1, or.y) && !visited[or.x + 1][or.y] && grid[or.x + 1][or.y] == 1) {
				queue.add(new Orange(or.x + 1, or.y, or.dist + 1));
				visited[or.x + 1][or.y] = true;
			}
			
			if(isValid(m, n, or.x, or.y - 1) && !visited[or.x][or.y - 1] && grid[or.x][or.y - 1] == 1) {
				queue.add(new Orange(or.x, or.y - 1, or.dist + 1));
				visited[or.x][or.y - 1] = true;
			}
			
			if(isValid(m, n, or.x, or.y + 1) && !visited[or.x][or.y + 1] && grid[or.x][or.y + 1] == 1) {
				queue.add(new Orange(or.x, or.y + 1, or.dist + 1));
				visited[or.x][or.y + 1] = true;
			}
		}
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(grid[i][j] == 1 && !visited[i][j])
					return -1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] grid = {{2, 1},// 1},
						{0, 1}};//, 0},
						//{0, 1, 1}};
		int m = 2;
		int n = 2;
		
		RottonOranges ro = new RottonOranges();
		
		int result = ro.getMinTimeToRotAllOranges(grid, m, n);
		
		System.out.println(result);
	}
}
