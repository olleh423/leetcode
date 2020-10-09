package problems;
import java.util.*;

/*
 * Leetcode : 380
 */

public class InsertDeleteGetRandomInO1 {

    public static void main(String[] args) {

        RandomizedSet rs = new RandomizedSet();

        // todo
    }

    private static class RandomizedSet {

        private Map<Integer, Integer> indexMap;
        private List<Integer> data;
        private int size;

        /** Initialize your data structure here. */
        public RandomizedSet() {

            this.indexMap = new HashMap<>();
            this.data = new ArrayList<>();
            this.size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            if(indexMap.containsKey(val)) return false;

            data.add(val);
            indexMap.put(val, data.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            int index = indexMap.getOrDefault(val, -1);
            if(index == -1)
                return false;
            Collections.swap(data, index, data.size()-1);
            int newElement = data.get(index);
            indexMap.put(newElement, index);
            data.remove(data.size()-1);
            indexMap.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {

            int min = 0;
            int max = data.size();
            int random = (int) ((Math.random() * (max - min)) + min);
            return data.get(random);
        }
    }
}
