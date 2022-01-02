package p1000_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *
 * @author half-dead
 */
public class Puzzle768 {

    // greedy, two pass, prefix max + suffix min, O(N) time & space
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length, res = 0;

            int[] prefixMax = new int[n];
            prefixMax[0] = arr[0];
            for (int i = 1; i < n; i++) prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);

            for (int i = n - 2, suffixMin = arr[n - 1]; i >= 0; i--) {
                if (prefixMax[i] <= suffixMin) res++;
                suffixMin = Math.min(suffixMin, arr[i]);
            }
            return res + 1;
        }
    }

    // sort + greedy + prefixsum, O(NlogN) time, O(N) space
    // since arr is a permutation of sorted, so when their prefix sum are equal
    // so the prefix of arr must be a permutation of the prefix of sorted
    class Solution0 {
        public int maxChunksToSorted(int[] arr) {
            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            int res = 0, sum1 = 0, sum2 = 0;
            for (int i = 0; i < arr.length; i++) {
                sum1 += arr[i];
                sum2 += sorted[i];
                if (sum1 == sum2) res++;
            }
            return res;
        }
    }

    // sort + greedy + freqmap, O(NlogN) time, O(N) space
    class Solution1 {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length, res = 0;

            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = arr[i], b = sorted[i];
                if (a == b) {
                    res += map.size() == 0 ? 1 : 0;
                    continue;
                }

                map.put(a, map.getOrDefault(a, 0) + 1);
                map.put(b, map.getOrDefault(b, 0) - 1);
                if (map.get(a) == 0) map.remove(a);
                if (map.get(b) == 0) map.remove(b);

                if (map.size() == 0) res++;
            }
            return res;
        }
    }
}
