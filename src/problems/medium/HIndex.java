package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class HIndex {

    public static void main(String[] args) {

        HIndex obj = new HIndex();

        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(obj.hIndex(citations));
    }

    public int hIndex(int[] citations) {

        if(citations == null)
            return 0;

        int n = citations.length;
        int[] res = new int[n+1];
        for(int i=0 ; i<n ; i++) {
            if(citations[i] >= n)
                res[n] += 1;
            else
                res[citations[i]] += 1;
        }

        int hIndex = 0;
        for(int i=n ; i>=0 ; i--) {
            if(res[i] >= i) {
                hIndex = i;
                break;
            }
            else if(i > 0) {
                res[i-1] += res[i];
            }
        }
        return hIndex;
    }
}
