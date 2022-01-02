package p0500_;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author half-dead
 */
public class Puzzle347_TopKFrequentElements {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            PriorityQueue<Integer> q = new PriorityQueue<>(k);
            for (int count : map.values()) {
                if (q.size() < k) {
                    q.add(count);
                } else {
                    if (count > q.peek()) {
                        q.poll();
                        q.add(count);
                    }
                }
            }
            Set<Integer> set = new HashSet<>(q);
            List<Integer> result = new ArrayList<>();
            for (int n : map.keySet()) {
                if (set.contains(map.get(n))) {
                    result.add(n);
                }
            }
            return result;
        }
    }

    class Solution1 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
            for (int n : map.keySet()) {
                heap.add(n);
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            List<Integer> result = new LinkedList<>();
            while (!heap.isEmpty()) {
                result.add(heap.poll());
            }
            Collections.reverse(result);
            return result;
        }
    }

    class Solution2 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int n : nums) {
                frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            }

            List<Integer>[] bucket = new List[nums.length + 1];

            for (int key : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(key);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(key);
            }

            List<Integer> res = new ArrayList<>();
            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]);
                }
            }
            return res;
        }
    }
}
