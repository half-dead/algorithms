package p2000_;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 *
 * @author half-dead
 */
public class Puzzle1525 {

    class Solution {
        public int numSplits(String s) {
            int[] cr = new int[128], cl = new int[128];
            int nr = 0, nl = 0, ans = 0;

            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (cr[c]++ == 0) {
                    nr++;
                }
            }

            for (char c : cs) {
                if (--cr[c] == 0) {
                    nr--;
                }
                if (cl[c]++ == 0) {
                    nl++;
                }
                if (nl == nr) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
