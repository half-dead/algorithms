package p2500_;

/**
 * https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
 *
 * @author half-dead
 */
public class Puzzle2275 {

    class Solution {
        public int largestCombination(int[] candidates) {
            int[] cnt = new int[32];
            for (int v : candidates) {
                int x = v, i = 0;
                while (x > 0) {
                    cnt[i++] += (x % 2);
                    x >>= 1;
                }
            }
            int res = 0;
            for (int v : cnt) {
                res = Math.max(res, v);
            }
            return res;
        }
    }
}
