package p1500_;

/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author half-dead
 */
public class Puzzle1365 {
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] count = new int[101];
            for (int n : nums) count[n]++;

            int prev = count[0];
            count[0] = 0;
            for (int i = 1; i < 101; i++) {
                int curr = count[i - 1] + prev;
                prev = count[i];
                count[i] = curr;
            }

            for (int i = 0; i < nums.length; i++) nums[i] = count[nums[i]];
            return nums;
        }
    }
}
