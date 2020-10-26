package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class PowerOfTwo {

    public static void main(String[] args) {

        PowerOfTwo obj = new PowerOfTwo();
    }

    public boolean isPowerOfTwo(int n) {

        if(n <= 0) return false;

        return (n & (n-1)) == 0;
    }
}
