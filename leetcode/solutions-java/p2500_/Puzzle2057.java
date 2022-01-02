package p2500_;

/**
 * https://leetcode.com/problems/smallest-index-with-equal-value/
 *
 * @author half-dead
 */
public class Puzzle2057 {

    class Solution {
        public int smallestEqual(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 10 == nums[i]) return i;
            }
            return -1;
        }
    }
}
