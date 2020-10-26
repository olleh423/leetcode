package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class PowerOfFour {

    public static void main(String[] args) {

        PowerOfFour obj = new PowerOfFour();
    }

    public boolean isPowerOfFour(int n) {
        return n != 0 && ((n&(n-1)) == 0) && (n & 0xAAAAAAAA) == 0;
    }
}
