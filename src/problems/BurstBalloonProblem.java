package problems;

public class BurstBalloonProblem {

	public int burstBalloon(int[] values) {

		int T[][] = new int[values.length][values.length];

		for (int len = 1; len <= values.length; len++) {
			
			for (int i = 0; i <= values.length - len; i++) {
				
				int j = i + len - 1;
				
				for (int k = i; k <= j; k++) {
					
					int leftValue = 1;
					int rightValue = 1;
					
					if (i != 0)
						leftValue = values[i - 1];
					
					if (j != values.length - 1)
						rightValue = values[j + 1];
					
					int before = 0;
					int after = 0;
					
					if (i != k)
						before = T[i][k - 1];
					
					if (j != k)
						after = T[k + 1][j];
					
					T[i][j] = Math.max(leftValue * values[k] * rightValue + before + after, T[i][j]);
				}
			}
		}

		return T[0][values.length - 1];
	}

	public static void main(String[] args) {

		int[] V = { 3, 1, 5, 8 };

		BurstBalloonProblem obj = new BurstBalloonProblem();

		System.out.println("Max profit is : " + obj.burstBalloon(V));
	}
}
