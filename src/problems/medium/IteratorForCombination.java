package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class IteratorForCombination {

    public static void main(String[] args) {

        IteratorForCombination obj = new IteratorForCombination();

        String chars = "abc";
        int k = 2;
        CombinationIterator iterator = new CombinationIterator(chars, k);
        iterator.next(); // returns "ab"
        iterator.hasNext(); // returns true
        iterator.next(); // returns "ac"
        iterator.hasNext(); // returns true
        iterator.next(); // returns "bc"
        iterator.hasNext(); // returns false
    }

    private static class CombinationIterator {

        private List<String> combinations;
        private int hasNext;

        public CombinationIterator(String characters, int combinationLength) {

            combinations = new ArrayList<>();
            hasNext = 0;
            permute(characters, combinationLength, 0, new StringBuilder());
        }

        public String next() {

            if(hasNext())
                return combinations.get(hasNext++);

            return null;
        }

        public boolean hasNext() {

            return hasNext < combinations.size();
        }

        private void permute(String str, int k, int cIndex, StringBuilder running) {

            if(k == 0) {
                combinations.add(running.toString());
                return;
            }

            for(int i=cIndex ; i <= str.length()-k ; i++) {
                running.append(str.charAt(i));
                permute(str, k-1, i+1, running);
                running.deleteCharAt(running.length()-1);
            }
        }
    }
}
