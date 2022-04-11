package p2500_;

/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2176 {
    // brute force
    class Solution {
        public int countPairs(int[] nums, int k) {
            int n = nums.length, res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j] && (i * j) % k == 0) res++;
                }
            }
            return res;
        }
    }
}
