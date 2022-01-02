package p2500_;

/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 *
 * @author half-dead
 */
public class Puzzle2016 {

    class Solution {
        public int maximumDifference(int[] nums) {
            int min = Integer.MAX_VALUE, res = -1;
            for (int n : nums) {
                if (min < n) {
                    res = Math.max(res, n - min);
                }
                min = Math.min(min, n);
            }
            return res;
        }
    }
}
