package p2000_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-building-height/
 *
 * @author half-dead
 */
public class Puzzle1840 {
    // two pass, greedy, O(NlogN) time
    class Solution {
        public int maxBuilding(int n, int[][] rest) {
            int len = rest.length;
            if (len == 0) return n - 1;

            Arrays.sort(rest, Comparator.comparingInt(a -> a[0]));

            int prev = 1, h = 0;
            for (int i = 0; i < len; i++) {
                int label = rest[i][0], limit = rest[i][1];
                int nexth = Math.min(limit, h + (label - prev));
                prev = label;
                h = rest[i][1] = nexth;
            }

            prev = rest[len - 1][0];
            h = rest[len - 1][1];
            int ans = h + n - prev;
            for (int i = len - 2; i >= 0; i--) {
                int label = rest[i][0], limit = rest[i][1];
                int nexth = Math.min(limit, h + (prev - label));
                ans = Math.max(ans, Math.max(h, nexth) + (prev - label - Math.abs(h - nexth)) / 2);
                prev = label;
                h = nexth;
            }
            return Math.max(ans, (prev - 1 - h) / 2);
        }
    }
}
