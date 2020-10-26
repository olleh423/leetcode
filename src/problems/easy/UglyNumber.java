package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class UglyNumber {

    public static void main(String[] args) {

        UglyNumber obj = new UglyNumber();
    }

    public boolean isUgly(int num) {

        if(num <= 0)
            return false;

        while(num > 1) {

            if(num % 5 == 0)
                num /= 5;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 2 == 0)
                num /= 2;
            else
                return false;
        }

        return true;
    }
}
