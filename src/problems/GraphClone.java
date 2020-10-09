package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphClone {

	private static class GraphNode {
		int data;
		List<GraphNode> neighbours;
		GraphNode(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();
		}
	}
	
	private static GraphNode clone(GraphNode old, GraphNode curr, Map<Integer, GraphNode> map) {
		
		for(GraphNode n : old.neighbours) {
			if(map.containsKey(n.data)) {
				curr.neighbours.add(map.get(n.data));
			} else {
				GraphNode node = new GraphNode(n.data);
				map.put(node.data, node);
				curr.neighbours.add(clone(n, node, map));
			}
		}
		return curr;
	}
	
	public static GraphNode clone(GraphNode node) {
		if(node == null) return null;
		GraphNode curr = new GraphNode(node.data);
		Map<Integer, GraphClone.GraphNode> map = new HashMap<>();
		map.put(curr.data, curr);
		return clone(node, curr, map);
	}
	
	private static void DFS(GraphNode node, Set<Integer> visited) {
		
		visited.add(node.data);
		for(GraphNode n : node.neighbours) {
			if(!visited.contains(n.data))
				DFS(n, visited);
		}
		System.out.print(node.data + " ");
	}
	
	public static void BFS(GraphNode node) {
		DFS(node, new HashSet<Integer>());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		
		one.neighbours.add(two);
		one.neighbours.add(three);
		two.neighbours.add(one);
		two.neighbours.add(three);
		three.neighbours.add(one);
		three.neighbours.add(two);
		three.neighbours.add(four);
		three.neighbours.add(five);
		four.neighbours.add(three);
		four.neighbours.add(five);
		five.neighbours.add(three);
		five.neighbours.add(four);
		
		GraphNode graph = clone(one);
		BFS(one);
		BFS(graph);
	}
}
