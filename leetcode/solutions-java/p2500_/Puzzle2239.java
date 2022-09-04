package p2500_;

/**
 * https://leetcode.com/problems/find-closest-number-to-zero/
 *
 * @author half-dead
 */
public class Puzzle2239 {
    class Solution {
        public int findClosestNumber(int[] nums) {
            int res = 1 << 30;
            for (int x : nums) {
                if (Math.abs(x) < Math.abs(res) || (Math.abs(x) == Math.abs(res) && x > res)) {
                    res = x;
                }
            }
            return res;
        }
    }
}
