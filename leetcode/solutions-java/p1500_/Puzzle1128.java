package p1500_;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 *
 * @author half-dead
 */
public class Puzzle1128 {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] map = new int[100];
            for (int[] d : dominoes) map[Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1])]++;

            int res = 0;
            for (int cnt : map) if (cnt > 1) res += cnt * (cnt - 1) / 2;
            return res;
        }
    }
}
