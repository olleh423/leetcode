package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 20-10-2020
 */
public class GenerateParentheses {

    public static void main(String[] args) {

        GenerateParentheses obj = new GenerateParentheses();
        int n = 3;
        System.out.println(obj.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {

        List<String> data = new ArrayList<>();
        generate(n, n, "", data);
        return data;
    }

    private void generate(int n, int m, String data, List<String> result) {

        if(n == 0 && m == 0) {
            result.add(data);
            return;
        }

        if(n > 0) generate(n-1, m, data + '(', result);
        if(m > n) generate(n, m-1, data + ')', result);
    }
}
