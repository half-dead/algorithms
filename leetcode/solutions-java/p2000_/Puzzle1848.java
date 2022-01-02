package p2000_;

/**
 * https://leetcode.com/problems/minimum-distance-to-the-target-element/
 *
 * @author half-dead
 */
public class Puzzle1848 {
    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    res = Math.min(res, Math.abs(i - start));
                }
                if (res == 0) break;
            }
            return res;
        }
    }
}
