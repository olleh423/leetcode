package problems.hard;

public class BestTimeToBuyAndSellStock4 {

    public static void main(String[] args) {

        int[] arr = {3,2,6,5,0,3};
        int k = 3;

        BestTimeToBuyAndSellStock4 obj = new BestTimeToBuyAndSellStock4();
        System.out.println(obj.maxProfit(k, arr));
    }

    public int maxProfit(int k, int[] P) {

        if(k == 0 || P == null || P.length <= 1)
            return 0;

        int n = P.length;
        if(k > n/2) {
            int ans = 0;
            for(int i=0 ; i<n-1 ; i++) {
                ans += Math.max(0, P[i+1] - P[i]);
            }
            return ans;
        }

        int[] DP1 = new int[n];
        int[] DP2 = new int[n];

        for(int i=1 ; i<=k ; i++) {

            int maxSoFar = -P[0];
            for(int j=0 ; j<n ; j++) {

                DP2[j] = j == 0 ? 0 : Math.max(DP2[j-1], P[j] + maxSoFar);
                maxSoFar = Math.max(maxSoFar, DP1[j] - P[j]);
                DP1[j] = DP2[j];
            }
        }

        return DP2[n-1];
    }
}
