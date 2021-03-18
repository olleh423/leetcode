package problems.medium;/*
 * Author : Vijay Sharma 14-03-2021
 */

public class FindTheCelebrity {

    public static void main(String[] args) {

        FindTheCelebrity obj = new FindTheCelebrity();
        int n = 4;
        System.out.println(obj.findCelebrity(n));
    }

    //helper method
    private boolean knows(int i, int j) {
        return false;
    }

    public int findCelebrity(int n) {

        int candidate = 0;
        for(int i=1 ; i<n ; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }

        for(int i=0 ; i<n ; i++) {
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate)))
                return -1;
        }

        return candidate;
    }
}
