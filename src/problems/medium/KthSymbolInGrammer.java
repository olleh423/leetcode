package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-01-2021
 */
public class KthSymbolInGrammer {

    public static void main(String[] args) {

        KthSymbolInGrammer obj = new KthSymbolInGrammer();
        int n = 6;
        int k = 7;
        System.out.println(obj.kthGrammar(n, k));
    }

    public int kthGrammar(int N, int K) {
        return solve(N, K, 0);
    }

    private int solve(int n, int k, int root) {

        if(n == 1) return root;
        int elementsInNthRow = (int) Math.pow(2, n-1);
        if(elementsInNthRow / 2 >= k) return solve(n-1, k, root);
        else return solve(n-1, k - elementsInNthRow/2, root == 0 ? 1 : 0);
    }
}
