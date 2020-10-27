package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class FizzBuzz {

    public static void main(String[] args) {

        FizzBuzz obj = new FizzBuzz();
    }

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for(int i=1 ; i<=n ; i++) {

            StringBuilder builder = new StringBuilder();
            if(i % 3 == 0)
                builder.append("Fizz");
            if(i % 5 == 0)
                builder.append("Buzz");

            if(builder.length() == 0)
                builder.append(i);

            result.add(builder.toString());
        }

        return result;
    }
}
