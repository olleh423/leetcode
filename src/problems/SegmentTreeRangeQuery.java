package problems;

public class SegmentTreeRangeQuery {
	
	public static void main(String[] args) {
		
		int[] input = {7, 5, 8, 1, 2, 3, 4, 5, 6};
		int n = input.length;
		
		SegmentTree st = new SegmentTree(input, n);
		st.showTree();
		
		st.update(5, 3);
		st.showTree();
		st.update(0, 15);
		st.showTree();
		
		System.out.println("sum of index 0 to 3 : " + st.querySum(0, 3));
	}
}

class SegmentTree {
	
	private int[] tree;
	private int[] input;
	private int n;
	private int treeSize;
	
	SegmentTree(int[] input, int n) {
		
		this.input = input;
		this.n = n;
		this.treeSize = nextPowerOfTwo(n) * 2;
		this.tree = new int[treeSize];
		build(0, n-1, 1);
		
		for(int i=0 ; i<tree.length ; i++)
			System.out.print(tree[i] + " ");
		
		System.out.println("\n\n");
	}
	
	private int nextPowerOfTwo(int n) {
		
		if(n == 0)
			return 1;
		
		if((n & (n-1)) == 0)
			return n;
		
		while((n & (n-1)) > 0) {
			n = (n & (n-1));
		}
		
		return n << 1;
	}
	
	private void build(int start, int end, int treeIndex) {
		
		if(start == end) {
			tree[treeIndex] = input[start];
			return;
		}
		
		int mid = (start + end) / 2;
		build(start, mid, 2*treeIndex);
		build(mid+1, end, 2*treeIndex+1);
		
		tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
	}
	
	public void update(int i, int value) {
		
		if(i < 0 || i >= n) 
			return;
		update(0, n-1, i, value - input[i], 1);
	}
	
	private void update(int nodeStart, int nodeEnd, int targetIndex, int value, int treeIndex) {
		
		if(nodeStart == nodeEnd)
			input[targetIndex] += value;
		
		if(nodeStart == nodeEnd || targetIndex < nodeStart || targetIndex > nodeEnd) 
			return;
		
		tree[treeIndex] += value;
		int mid = (nodeStart + nodeEnd) / 2;
		if(targetIndex <= mid)
			update(nodeStart, mid, targetIndex, value, treeIndex * 2);
		else
			update(mid + 1, nodeEnd, targetIndex, value, treeIndex * 2 + 1);
	}
	
	public int querySum(int l, int r) {
		
		return querySum(0, n-1, l, r, 1);
	}
	
	private int querySum(int nodeStart, int nodeEnd, int qStart, int qEnd, int treeIndex) {
		
		if(nodeStart >= qStart && nodeEnd <= qEnd)
			return tree[treeIndex];
		if(qStart > nodeEnd || qEnd < nodeStart)
			return 0;
		
		int mid = (nodeStart + nodeEnd) / 2;
		return querySum(nodeStart, mid, qStart, qEnd, treeIndex * 2) + querySum(mid + 1, nodeEnd, qStart, qEnd, treeIndex * 2 + 1);
	}
	
	public void showTree() {
		for(int a : input)
			System.out.print(a + " ");
		System.out.println();
	}
}
