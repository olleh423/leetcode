package problems;

public class SqrtDecomposition {

	/*
	 * Given n, m
	 * n elements of array
	 * m queries
	 * Update Sum
	 * UPDATE i, k
	 * SUM i to j
	 */
	
	private int[] input;
	private int[] blocks;
	private int sqrt;
	int size = 0;
	
	private void build(int[] data, int n) {
		
		size = n;
		sqrt = (int) Math.ceil(Math.sqrt(size));
		input = new int[sqrt * sqrt];
		blocks = new int[sqrt];
		
		int sum = 0;
		for(int i=0 ; i<input.length ; i++) {
			input[i] = i < data.length ? data[i] : 0;
			sum += input[i];
			if((i+1) % sqrt == 0) {
				blocks[((i+1)/sqrt)-1] = sum;
				sum = 0;
			}
		}
	}
	
	public void update(int i, int value) {
		
		if(i >= size) return;
		blocks[i/sqrt] = blocks[i/sqrt] - input[i] + value;
		input[i] = value;
	}
	
	public int querySum(int left, int right) {
		
		if(left >= size || left < 0 || right < 0 || right >= size) return 0;
		
		int startBlock = left / sqrt;
		int endBlock = right / sqrt;
		
		int sum = 0;
		for(int i = startBlock + 1 ; i < endBlock ; i++)
			sum += blocks[i];
		
		int leftIndex = left % sqrt;
		int rightIndex = right % sqrt;
		
		for(int i = leftIndex ; i < sqrt ; i++) 
			sum += input[sqrt * startBlock + i];
		
		for(int i = 0 ; i <= rightIndex ; i++)
			sum += input[sqrt * endBlock + i];
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		SqrtDecomposition sd = new SqrtDecomposition();
		
		int[] data = {5, 6, 9, 16, 2, 3, 1, 52, 13, 6, 9, 8, 7, 4, 1};
		sd.build(data, data.length);
		
		System.out.println(sd.querySum(3, 8));
		sd.update(7, 0);
		System.out.println(sd.querySum(3, 8));
	}
}
