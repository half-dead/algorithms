package p2500_;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 *
 * @author half-dead
 */
public class Puzzle2033 {

    class Solution {
        public int minOperations(int[][] grid, int x) {
            int min = Integer.MAX_VALUE, max = 0, ans = 0;
            for (int[] row : grid) {
                for (int v : row) {
                    min = Math.min(min, v);
                    max = Math.max(max, v);
                }
            }

            int[] cnt = new int[max + 1];
            for (int[] row : grid) {
                for (int v : row) {
                    if ((v - min) % x != 0) return -1;

                    cnt[v]++;
                }
            }

            while (min < max) {
                if (cnt[min] <= cnt[max]) {
                    ans += cnt[min];
                    cnt[min + x] += cnt[min];
                    min += x;
                } else {
                    ans += cnt[max];
                    cnt[max - x] += cnt[max];
                    max -= x;
                }
            }
            return ans;
        }
    }
}
