package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class FirstBadVersion {

    public static void main(String[] args) {

        FirstBadVersion obj = new FirstBadVersion();
    }

    private boolean isBadVersion(int n) {
        // Dummy method
        return true;
    }

    public int firstBadVersion(int n) {

        int badVersion = -1;
        int s=1, e=n;
        while(s <= e) {

            int mid = s + (e - s) / 2;
            if(isBadVersion(mid)) {
                badVersion = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        return badVersion;
    }
}
