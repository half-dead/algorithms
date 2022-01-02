package p2000_;

/**
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * @author half-dead
 */
public class Puzzle1887 {

    // count sort
    class Solution {
        public int reductionOperations(int[] nums) {
            int len = nums.length, ans = 0, group = 0;

            int[] cnt = new int[50001];
            for (int n : nums) cnt[n]++;

            for (int i = 50000; i > 0; i--) {
                if (cnt[i] > 0) {
                    group += cnt[i];
                    if (group == len) break;
                    ans += group;
                }
            }
            return ans;
        }
    }
}
