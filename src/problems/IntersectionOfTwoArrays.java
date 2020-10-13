package problems;
import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] A = {1, 2, 2, 1};
        int[] B = {2, 2};

        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(obj.intersect(A, B)));
    }

    private int[] intersect(int[] A, int[] B) {

        if(A == null || B == null) return null;

        if(A.length > B.length) return intersect(B, A);

        Map<Integer, Integer> fA = new HashMap<>();
        Map<Integer, Integer> fB = new HashMap<>();

        for(int i=0 ; i<A.length ; i++)
            fA.put(A[i], 1 + fA.getOrDefault(A[i], 0));

        for(int i=0 ; i<B.length ; i++)
            fB.put(B[i], 1 + fB.getOrDefault(B[i], 0));

        List<Integer> result = new ArrayList<>();
        for(int key : fA.keySet()) {
            if(fB.containsKey(key)) {
                for(int k=0 ; k<Math.min(fA.get(key), fB.get(key)) ; k++) {
                    result.add(key);
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i=0 ; i<res.length ; i++)
            res[i] = result.get(i);

        return res;
    }
}
