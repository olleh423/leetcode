package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class AllElementsInTwoBinarySearchTrees {

    public static void main(String[] args) {

        AllElementsInTwoBinarySearchTrees obj = new AllElementsInTwoBinarySearchTrees();
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        inOrder(root1, one);
        inOrder(root2, two);
        merge(one, two, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private void merge(List<Integer> one, List<Integer> two, List<Integer> result) {
        int i=0, j=0;
        while(i < one.size() || j < two.size()) {
            if(j == two.size()) {
                result.add(one.get(i++));
            }
            else if(i == one.size()) {
                result.add(two.get(j++));
            }
            else if(one.get(i) < two.get(j)) {
                result.add(one.get(i++));
            }
            else {
                result.add(two.get(j++));
            }
        }
    }
}
