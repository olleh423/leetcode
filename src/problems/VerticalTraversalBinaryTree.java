package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalBinaryTree {

	private static class Pair {
		TreeNode node;
		int index;
		Pair(TreeNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}
	
	private static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
	    
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        while(!queue.isEmpty()) {
            
            Pair pair = queue.poll();
            if(!map.containsKey(pair.index)) {
                map.put(pair.index, new ArrayList<Integer>());
            }
            map.get(pair.index).add(pair.node.val);

            if(pair.node.left != null)
                queue.add(new Pair(pair.node.left, pair.index - 1));
            if(pair.node.right != null)
                queue.add(new Pair(pair.node.right, pair.index + 1));
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        	Collections.sort(entry.getValue());
            result.add(entry.getValue());
        }
        
        return result;
    }
	
	private static TreeNode createTree() {
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		root.left.left.left.right = new TreeNode(7);
		root.left.left.right.left = new TreeNode(6);
		root.left.left.left.right.left = new TreeNode(10);
		root.left.left.left.right.right = new TreeNode(8);
		root.left.left.right.left.left = new TreeNode(11);
		root.left.left.right.left.right = new TreeNode(9);
		
		return root;
	}
	
	/*
	 * level order is maintained
	 */
	public static List<List<Integer>> verticalTraversalSorted(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        
        List<Point> points = new ArrayList<>();
        populate(root, 0, 0, points);
        Collections.sort(points, (a, b) -> a.x == b.x ? a.y == b.y ? a.val - b.val : b.y - a.y : a.x - b.x);
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(Point p : points) {
            if(!map.containsKey(p.x))
                map.put(p.x, new ArrayList<Integer>());
            map.get(p.x).add(p.val);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> row : map.values())
            result.add(row);
        
        return result;
    }
    
    private static void populate(TreeNode root, int x, int y, List<Point> points) {
        if(root == null)
            return;
        points.add(new Point(x, y, root.val));
        populate(root.left, x-1, y-1, points);
        populate(root.right, x+1, y-1, points);
    }
    
    private static class Point {
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
	
	public static void main(String[] args) {
		
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		
		System.out.println(verticalTraversal(createTree()));
		System.out.println(verticalTraversalSorted(createTree()));
	}
}
