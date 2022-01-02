package p2000_;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-queries/
 *
 * @author half-dead
 */
public class Puzzle1906 {

    class Solution {
        public int[] minDifference(int[] nums, int[][] queries) {
            int len = nums.length, j = 0;
            int[][] cnts = new int[len + 1][101];
            for (int i = 0; i < len; i++) {
                System.arraycopy(cnts[i], 1, cnts[i + 1], 1, 100);
                cnts[i + 1][nums[i]]++;
            }

            int[] ans = new int[queries.length];
            for (int[] q : queries) {
                int[] from = cnts[q[0]], to = cnts[q[1] + 1];

                int min = 100, prev = 0;
                for (int i = 1; i < 101; i++) {
                    if (to[i] > from[i]) {
                        if (prev > 0) min = Math.min(min, i - prev);
                        prev = i;
                    }
                }
                ans[j++] = min == 100 ? -1 : min;
            }
            return ans;
        }
    }
}
