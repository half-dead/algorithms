package p2500_;

/**
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 *
 * @author half-dead
 */
public class Puzzle2148 {

    class Solution {
        public int countElements(int[] nums) {
            int min = nums[0], max = nums[0], res = 0;
            for (int x : nums) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            for (int x : nums) {
                if (x != min && x != max) res++;
            }
            return res;
        }
    }
}
