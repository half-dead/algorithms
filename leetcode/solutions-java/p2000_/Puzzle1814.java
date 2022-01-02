package p2000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle1814 {
    class Solution {
        public int countNicePairs(int[] nums) {
            final int mod = 1000000007;
            Map<Integer, Integer> diffMap = new HashMap<>(), cntMap = new HashMap<>();
            for (int n : nums) {
                int diff = diffMap.computeIfAbsent(n, this::diff);
                cntMap.put(diff, cntMap.getOrDefault(diff, 0) + 1);
            }

            int max = 0;
            for (int n : cntMap.values()) {
                max = Math.max(max, n);
            }

            long[][] sum = new long[max + 1][2];
            for (int i = 1; i < sum.length; i++) {
                sum[i][0] = i;
                sum[i][1] = sum[i - 1][0] + sum[i - 1][1];
            }

            long res = 0L;
            for (int n : cntMap.values()) {
                res += sum[n][1];
            }
            return (int) (res % mod);
        }

        private int diff(int n) {
            char[] chars = (n + "").toCharArray();
            int d = 0;
            for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
                d = d * 10 + (chars[i] - chars[j]);
            }
            return d;
        }
    }
}
