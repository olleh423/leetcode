package problems.easy;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class IsomorphicStrings {

    public static void main(String[] args) {

        IsomorphicStrings obj = new IsomorphicStrings();
        String s = "egg";
        String t = "add";
        System.out.println(obj.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {

        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] A = new int[256];
        int[] B = new int[256];

        for(int i=0 ; i<s.length() ; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(A[c1] != B[c2])
                return false;
            A[c1] = i+1;
            B[c2] = i+1;
        }

        return true;
    }
}
