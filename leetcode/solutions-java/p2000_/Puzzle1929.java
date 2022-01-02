package p2000_;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * @author half-dead
 */
public class Puzzle1929 {

    class Solution {
        public int[] getConcatenation(int[] nums) {
            int n = nums.length;
            int[] res = new int[n << 1];
            System.arraycopy(nums, 0, res, 0, n);
            System.arraycopy(nums, 0, res, n, n);
            return res;
        }
    }
}
