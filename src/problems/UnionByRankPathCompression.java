package problems;

import java.util.HashMap;
import java.util.Map;

class DisjointSet {

	static class Node {
		int data;
		int rank;
		Node parent;
	}
	
	private Map<Integer, Node> map;
	
	public DisjointSet() {
		
		map = new HashMap<>();
	}
	
	/*
	 * make set for only single element
	 */
	public void makeSet(int data) {
		
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}
	
	/*
	 * union of two different sets
	 */
	public void union(int a, int b) {
		
		if(map.get(a) == null || map.get(b) == null)
			return;
		
		Node parentOne = map.get(findSet(a));
		Node parentTwo = map.get(findSet(b));
		
		if(parentOne == parentTwo) 
			return;
		
		if(parentOne.rank >= parentTwo.rank) {
			parentOne.rank = parentOne.rank == parentTwo.rank ? parentOne.rank + 1 : parentOne.rank;
			parentTwo.parent = parentOne;
		} else {
			parentOne.parent = parentTwo;
		}
	}
	
	public int findSet(int data) {
	
		return findSet(map.get(data)).data;
	}
	
	/*
	 * finding set with compressing the path to parent
	 */
	private Node findSet(Node node) {
		
		if(node.parent == node) 
			return node;
		
		node.parent = findSet(node.parent);
		return node.parent;
	}
}

public class UnionByRankPathCompression {

	public static void main(String[] args) {
		
		DisjointSet ds = new DisjointSet();
		
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);
		
		ds.union(1, 2);
		ds.union(3, 4);
		ds.union(5, 6);
		ds.union(5, 7);
		ds.union(2, 4);
		ds.union(6, 3);
		
		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));
	}
}
