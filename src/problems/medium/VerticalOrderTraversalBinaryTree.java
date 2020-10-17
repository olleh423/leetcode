package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class VerticalOrderTraversalBinaryTree {

    public static void main(String[] args) {

        VerticalOrderTraversalBinaryTree obj = new VerticalOrderTraversalBinaryTree();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

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

    private void populate(TreeNode root, int x, int y, List<Point> points) {
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
}
