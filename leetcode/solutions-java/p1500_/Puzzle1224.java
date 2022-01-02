package p1500_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-equal-frequency/
 *
 * @author half-dead
 */
public class Puzzle1224 {

    public static void main(String[] args) {
        Solution s = new Puzzle1224().new Solution();
        System.out.println(s.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
    }

    class Solution0 {
        public int maxEqualFreq(int[] arr) {
            int n = arr.length;
            int[] freq = new int[100001], elemsWithFreq = new int[100001];
            for (int x : arr) {
                freq[x]++;
                elemsWithFreq[freq[x]]++;
            }

            for (int i = n - 1; i >= 0; i--) {
                int x = arr[i], f = freq[x];
                // try to retain arr[i]
                if (f * elemsWithFreq[f] == i) return i + 1;

                elemsWithFreq[freq[x]]--;
                freq[x]--;

                // i will never reach 0
                x = arr[i - 1];
                f = freq[x];
                // try to delete arr[i]
                if (f * elemsWithFreq[f] == i) return i + 1;
            }
            return 1;
        }
    }

    class Solution {
        public int maxEqualFreq(int[] nums) {
            Map<Integer, Integer> freqMap = new HashMap<>(), group = new HashMap<>();
            for (int v : nums) {
                int freq = freqMap.getOrDefault(v, 0) + 1;
                freqMap.put(v, freq);
                group.put(freq, group.getOrDefault(freq, 0) + 1);
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                int v = nums[i];

                // try retain v
                int freq = freqMap.get(v), size = group.get(freq);
                if (freq * size == i) return i + 1;

                // try remove v
                group.put(freq, group.get(freq) - 1);
                freqMap.put(v, --freq);

                freq = freqMap.get(nums[i - 1]);
                size = group.get(freq);
                if (freq * size == i) return i + 1;

            }
            return 0;
        }
    }
}
