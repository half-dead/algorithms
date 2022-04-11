package p2500_;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 *
 * @author half-dead
 */
public class Puzzle2149 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int[] res = new int[nums.length];
            int i = 0, j = 1;
            for (int x : nums) {
                if (x > 0) {
                    res[i] = x;
                    i += 2;
                } else {
                    res[j] = x;
                    j += 2;
                }
            }
            return res;
        }
    }
}
