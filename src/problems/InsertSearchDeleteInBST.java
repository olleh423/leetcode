package problems;

import java.util.ArrayList;
import java.util.List;

public class InsertSearchDeleteInBST {

	private static class BST {
		
		private int value;
		private BST left, right;
		
		BST(int rootValue) {
			this.value = rootValue;
		}
		
		BST insert(int key) {
			
			if(value > key)
				left = left == null ? new BST(key) : left.insert(key);
			else
				right = right == null ? new BST(key) : right.insert(key);
			
			return this;
		}
		
		boolean search(int key) {
			
			if(value == key)
				return true;
			
			if(value > key)
				return left == null ? false : left.search(key);
			
			return right == null ? false : right.search(key);
		}
		
		BST remove(int key) {
			
			if(value == key) {
				
				if(left == null && right == null)
					return null;
				if(left == null)
					return right;
				if(right == null)
					return left;
				
				BST min = getMinimum(right);
				value = min.value;
				right = right.remove(min.value);
				return this;
			}
			
			if(value > key && left != null)
				left = left.remove(key);
			else if(value < key && right != null)
				right = right.remove(key);
			
			return this;
		}
		
		private BST getMinimum(BST root) {
			while(root.left != null)
				root = root.left;
			return root;
		}
		
		private void inOrderTraverse(BST tree, List<Integer> array) {
			
			if (tree.left != null)
				this.inOrderTraverse(tree.left, array);
			array.add(tree.value);
			if (tree.right != null)
				this.inOrderTraverse(tree.right, array);
		}
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST(10);
		bst = bst.insert(15).insert(11).insert(22).remove(10);
		
		List<Integer> array = new ArrayList<>();
		bst.inOrderTraverse(bst, array);
		System.out.println(array);
		
		/*
		BST bst = new BST(10);
		bst = bst.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14);
		
		System.out.println("Inorder : ");
		inOrder(bst);
		System.out.println("\n\nInorder after inserting 12 : ");
		bst = bst.insert(12);
		inOrder(bst);
		System.out.println("\n\nSearch 5 : " + bst.search(5));
		System.out.println("\n\nSearch 35 : " + bst.search(35));
		System.out.println("\n\nInorder after removing 12 : ");
		bst = bst.delete(12);
		inOrder(bst);
		System.out.println("\n\nInorder after removing 10 : ");
		bst = bst.delete(10);
		inOrder(bst);
		*/
	}
}
