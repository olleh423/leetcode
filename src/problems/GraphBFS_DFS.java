package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphBFS_DFS {
	
	private static class GraphNode {
		
		int data;
		List<GraphNode> neighbours;
		GraphNode(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();
		}
		@Override
		public int hashCode() {
			return new Integer(this.data).hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof GraphNode))
				return false;
			return this.hashCode() == obj.hashCode();
		}
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public static void BFS(GraphNode start) {
		
		Set<GraphNode> visiting = new HashSet<>();
		Set<GraphNode> visited = new HashSet<>();
		
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(start);
		
		while(! queue.isEmpty()) {
			
			GraphNode current = queue.remove();
			for(GraphNode n : current.neighbours) {
				if(!visiting.contains(n) && !visited.contains(n)) {
					queue.add(n);
					visiting.add(n);
				}
			}
			System.out.print(current + " ");
			visiting.remove(current);
			visited.add(current);
		}
	}
	
	public static void DFS(GraphNode node) {
		
		Set<GraphNode> visited = new HashSet<>();
		exploreDFS(node, visited);
	}
	
	private static void exploreDFS(GraphNode node, Set<GraphNode> visited) {
		
		visited.add(node);
		for(GraphNode n : node.neighbours) {
			if(!visited.contains(n))
				exploreDFS(n, visited);
		}
		
		System.out.print(node + " ");
	}

	public static void main(String[] args) {
		
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		
		one.neighbours.add(two);
		one.neighbours.add(four);
		one.neighbours.add(five);
		two.neighbours.add(one);
		two.neighbours.add(three);
		three.neighbours.add(two);
		three.neighbours.add(four);
		three.neighbours.add(five);
		four.neighbours.add(one);
		four.neighbours.add(three);
		four.neighbours.add(five);
		five.neighbours.add(one);
		five.neighbours.add(three);
		
		System.out.print("BFS : ");
		BFS(one);
		System.out.println();
		System.out.print("DFS : ");
		DFS(one);
	}
}
