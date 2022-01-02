package p1500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 *
 * @author half-dead
 */
public class Puzzle1481 {

    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);

            int[] cnt = new int[map.size()];
            int i = 0, uniq = cnt.length;
            for (int v : map.values()) cnt[i++] = v;
            Arrays.sort(cnt);

            for (int v : cnt) {
                if ((k -= v) < 0) break;
                else uniq--;
            }
            return uniq;
        }
    }
}
