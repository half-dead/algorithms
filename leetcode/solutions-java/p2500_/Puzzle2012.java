package p2500_;

/**
 * https://leetcode.com/problems/sum-of-beauty-in-the-array/
 *
 * @author half-dead
 */
public class Puzzle2012 {

    class Solution {
        public int sumOfBeauties(int[] nums) {
            int n = nums.length, res = 0, rightMin = nums[n - 1];

            int[] leftMax = new int[n];
            for (int i = 1; i < n - 1; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            }

            for (int i = n - 2; i > 0; i--) {
                if (leftMax[i] < nums[i] && nums[i] < rightMin) res += 2;
                else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) res += 1;
                rightMin = Math.min(rightMin, nums[i]);
            }
            return res;
        }
    }

}
