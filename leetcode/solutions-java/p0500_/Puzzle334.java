package p0500_;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * @author half-dead
 */
public class Puzzle334 {

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int min = 0, mid = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    if (min < mid && mid < nums[i + 1])
                        return true;
                    else {
                        min = nums[i];
                        mid = nums[i + 1];
                    }
                } else if (nums[i] > nums[i + 1]) {
                    if (min < nums[i + 1] && nums[i + 1] < mid) mid = nums[i + 1];
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n <= min) min = n;
                else if (n <= mid) mid = n;
                else return true;
            }
            return false;
        }
    }
}
