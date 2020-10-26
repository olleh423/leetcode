package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ArrangingCoins {

    public static void main(String[] args) {

        ArrangingCoins obj = new ArrangingCoins();
    }

    public int arrangeCoins(int n) {

        long total = 0;
        int i=1;
        while(true) {
            total += i;
            if(total > n)
                break;
            i++;
        }
        return i-1;
    }
}
