package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/lfu-cache/
 *
 * @author half-dead
 */
public class Puzzle460 {

    // can be improved to O(1) get & put
    // by replacing treeMap with Doubly-LinkedList of customized object
    class LFUCache {

        int capacity;
        Map<Integer, Integer> freqMap, data;
        TreeMap<Integer, LinkedHashSet<Integer>> tree;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            freqMap = new HashMap<>(capacity);
            data = new HashMap<>(capacity);
            tree = new TreeMap<>();
        }

        public int get(int key) {
            Integer val = data.get(key);
            if (val == null) return -1;

            refresh(key);
            return val;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;

            if (data.size() == capacity && !data.containsKey(key)) {
                Integer lf = tree.firstKey();
                LinkedHashSet<Integer> lfu = tree.get(lf);
                Integer evictKey = lfu.iterator().next();
                data.remove(evictKey);
                freqMap.remove(evictKey);
                lfu.remove(evictKey);
                if (lfu.size() == 0) tree.remove(lf);
            }

            data.put(key, value);
            refresh(key);
        }

        private void refresh(int key) {
            int freq = freqMap.getOrDefault(key, 0);
            if (freq > 0) {
                LinkedHashSet<Integer> keys = tree.get(freq);
                keys.remove(key);
                if (keys.isEmpty()) tree.remove(freq);
            }
            freq++;
            tree.computeIfAbsent(freq, x -> new LinkedHashSet<>()).add(key);
            freqMap.put(key, freq);
        }
    }

}
