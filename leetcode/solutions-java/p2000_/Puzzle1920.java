package p2000_;

/**
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * @author half-dead
 */
public class Puzzle1920 {

    class Solution {
        public int[] buildArray(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = nums[nums[i]];
            return res;
        }
    }
}
