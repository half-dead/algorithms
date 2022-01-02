package p2000_;

/**
 * https://leetcode.com/problems/count-special-quadruplets/
 *
 * @author half-dead
 */
public class Puzzle1995 {
    class Solution {
        public int countQuadruplets(int[] nums) {
            int n = nums.length, res = 0;
            int[] map = new int[301];
            map[nums[n - 1]] = 1;
            for (int i = n - 2; i >= 2; i--) {
                for (int j = i - 1; j >= 1; j--)
                    for (int k = j - 1; k >= 0; k--)
                        res += map[nums[i] + nums[j] + nums[k]];
                map[nums[i]]++;
            }
            return res;
        }
    }
}
