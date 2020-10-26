package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ReverseInteger {

    public static void main(String[] args) {

        ReverseInteger obj = new ReverseInteger();

        int a = 123;
        int b = -123;
        System.out.println(obj.reverse(a));
        System.out.println(obj.reverse(b));
    }

    public int reverse(int num) {

        boolean isNeg = num < 0 ? true : false;
        num = isNeg ? num*-1 : num;
        long result=0;

        while(num > 0) {

            int digit = num % 10;
            num /= 10;
            result = 10 * result + digit;
        }
        result = isNeg ? result*-1 : result;

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int) result;
    }
}
