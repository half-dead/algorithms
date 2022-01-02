package p2500_;

/**
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 *
 * @author half-dead
 */
public class Puzzle2006 {

    class Solution {
        public int countKDifference(int[] nums, int k) {
            int[] cnt = new int[101];
            for (int v : nums) cnt[v]++;

            int res = 0;
            for (int i = 1; i <= 100; i++) {
                if (i + k > 100) break;
                res += cnt[i] * cnt[i + k];
            }
            return res;
        }
    }
}
