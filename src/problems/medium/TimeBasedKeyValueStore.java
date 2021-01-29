package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 29-01-2021
 */
public class TimeBasedKeyValueStore {

    public static void main(String[] args) {

        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
    }

    private static class TimeMap {

        private static class Pair {
            int time;
            String value;
            Pair(int time, String value) {
                this.time = time;
                this.value = value;
            }
        }

        private Map<String, List<Pair>> timeMap;

        /** Initialize your data structure here. */
        public TimeMap() {

            this.timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            if(!timeMap.containsKey(key)) {
                timeMap.put(key, new ArrayList<Pair>());
            }
            timeMap.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {

            if(!timeMap.containsKey(key))
                return "";

            List<Pair> pairs = timeMap.get(key);
            int desiredTimeIndex = getLargestTimeStampIndex(pairs, timestamp);
            if(desiredTimeIndex == -1)
                return "";

            return pairs.get(desiredTimeIndex).value;
        }

        private int getLargestTimeStampIndex(List<Pair> data, int threshold) {

            int index = -1;
            int low = 0, high = data.size()-1;
            while(low <= high) {

                int mid = (low + high) / 2;
                if(data.get(mid).time <= threshold) {
                    index = mid;
                }

                if(data.get(mid).time < threshold) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return index;
        }
    }
}
