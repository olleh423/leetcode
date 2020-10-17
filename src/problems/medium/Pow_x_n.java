package problems.medium;

/*
 * Auther : Vijay Sharma
 */
public class Pow_x_n {

    public static void main(String[] args) {

        Pow_x_n obj = new Pow_x_n();
        System.out.println(obj.myPow(2.1, 3));
    }

    public double myPow(double x, int n) {

        double pow = pow(x, Math.abs(n));
        return n < 0 ? ((double) 1 / pow) : pow;
    }

    private double pow(double x, int n) {

        if(n == 0) return 1;
        if(n == 1) return x;

        double pow = pow(x, n/2);
        return n % 2 == 0 ? ((double)pow*pow) : ((double)pow*pow*x);
    }
}
