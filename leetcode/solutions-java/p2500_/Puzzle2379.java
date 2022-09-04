package p2500_;

/**
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 *
 * @author half-dead
 */
public class Puzzle2379 {
    // sliding window
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int res = k, cnt = 0;
            char[] cs = blocks.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (i >= k && cs[i - k] == 'W') {
                    cnt--;
                }
                if (cs[i] == 'W') cnt++;
                if (i >= k - 1) res = Math.min(res, cnt);
            }
            return res;
        }
    }
}
