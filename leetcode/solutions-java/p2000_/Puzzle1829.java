package p2000_;

/**
 * https://leetcode.com/problems/maximum-xor-for-each-query/
 *
 * @author half-dead
 */
public class Puzzle1829 {

    class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int xor = 0, len = nums.length, i = 0, comp = (1 << maximumBit) - 1;
            for (int n : nums) xor ^= n;

            int[] res = new int[len];
            while (i < len) {
                res[i] = comp & (~xor);
                xor ^= nums[len - ++i];
            }
            return res;
        }
    }
}
