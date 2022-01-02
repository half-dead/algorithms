package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 *
 * @author half-dead
 */
public class Puzzle1552 {

    class Solution {
        public int maxDistance(int[] p, int m) {
            int len = p.length;

            Arrays.sort(p);
            int min = Integer.MAX_VALUE, max = (p[len - 1] - p[0]) / (m - 1);
            for (int i = 1; i < len; i++) min = Math.min(p[i] - p[i - 1], min);

            if (m == 2) return max;
            if (m == p.length) return min;

            while (min <= max) {
                int mid = (min + max) >> 1, prev = p[0], cnt = 1;
                for (int i = 1; i < len; i++) {
                    if (p[i] - prev >= mid) {
                        if (++cnt == m) {
                            break;
                        }
                        prev = p[i];
                    }
                }
                if (cnt == m) min = mid + 1;
                else max = mid - 1;
            }
            return min - 1;
        }
    }

}
