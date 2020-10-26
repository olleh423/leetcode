package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class PlusOne {

    public static void main(String[] args) {

        PlusOne obj = new PlusOne();

        int[] digits = {4, 3, 2, 1};
        System.out.println(obj.plusOne(digits));
    }

    public int[] plusOne(int[] digits) {

        int[] result = new int[digits.length];
        int carry = 1;

        for(int i=digits.length - 1 ; i>=0 ; i--) {

            if(digits[i] + carry <= 9) {
                result[i] = digits[i] + carry;
                carry = 0;
            }
            else {
                result[i] = 0;
                carry = 1;
            }
        }
        if(carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }

        return result;
    }
}
