package p2500_;

/**
 * https://leetcode.com/problems/removing-minimum-number-of-magic-beans/
 *
 * @author half-dead
 */
public class Puzzle2171 {
    class Solution {
        public long minimumRemoval(int[] beans) {
            long sum = 0L, res = Long.MAX_VALUE;
            int[] cnts = new int[100001];
            for (int b : beans) {
                sum += b;
                cnts[b]++;
            }

            int n = beans.length, cnt = 0;
            for (int i = 1; i < cnts.length; i++) {
                if (cnts[i] == 0) continue;
                res = Math.min(res, sum - (n - cnt) * (long) i);
                cnt += cnts[i];
            }
            return res;
        }
    }
}
