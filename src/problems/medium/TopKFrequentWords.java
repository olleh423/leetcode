package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class TopKFrequentWords {

    public static void main(String[] args) {

        TopKFrequentWords obj = new TopKFrequentWords();
    }

    private static class Pair {
        String word;
        int freq;
        Pair(String word) {
            this.word = word;
            this.freq = 1;
        }
        void incrementFreq() {
            this.freq++;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        if(words == null)
            return result;

        int n = words.length;
        Map<String, Pair> freqMap = new HashMap<>();

        for(String word : words) {

            if(!freqMap.containsKey(word))
                freqMap.put(word, new Pair(word));
            else
                freqMap.get(word).incrementFreq();
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.freq != b.freq ? a.freq - b.freq : b.word.compareTo(a.word));

        for(String key : freqMap.keySet()) {

            Pair p = freqMap.get(key);
            if(minHeap.size() < k) {
                minHeap.add(p);
            }
            else {
                minHeap.add(p);
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll().word);
        }

        Collections.reverse(result);
        return result;
    }
}
