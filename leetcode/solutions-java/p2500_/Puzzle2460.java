package p2500_;

/**
 * https://leetcode.com/problems/apply-operations-to-an-array/description/
 */
public class Puzzle2460 {

    class Solution {
        public int[] applyOperations(int[] nums) {
            for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }

            int[] res = new int[nums.length];
            int j = 0;
            for (int i = 0; i < res.length; i++) {
                if (nums[i] != 0) {
                    res[j++] = nums[i];
                }
            }
            return res;
        }
    }
}
