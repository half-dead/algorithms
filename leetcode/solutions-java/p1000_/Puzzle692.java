package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * @author half-dead
 */
public class Puzzle692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>(k);
            for (String word : words) map.put(word, map.computeIfAbsent(word, key -> 0) + 1);

            PriorityQueue<Pair> pq = new PriorityQueue<>(map.size(), (p1, p2) -> {
                if (p1.freq == p2.freq) return p1.word.compareTo(p2.word);
                return p2.freq - p1.freq;
            });
            for (String word : map.keySet()) pq.offer(new Pair(word, map.get(word)));

            List<String> result = new ArrayList<>();
            while (k-- > 0) result.add(pq.poll().word);
            return result;
        }

        class Pair {
            String word;
            int freq;

            public Pair(String word, int freq) {
                this.word = word;
                this.freq = freq;
            }
        }
    }
}
