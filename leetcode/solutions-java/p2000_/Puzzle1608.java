package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * @author half-dead
 */
public class Puzzle1608 {

    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0, n = nums.length; i < n; i++) {
                int cnt = n - i;
                if (cnt <= nums[i] && (i == 0 || nums[i - 1] < cnt)) return cnt;
                if (cnt < nums[i]) break;
            }
            return -1;
        }
    }
}
