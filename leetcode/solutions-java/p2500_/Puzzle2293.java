package p2500_;

/**
 * https://leetcode.com/problems/min-max-game/
 *
 * @author half-dead
 */
public class Puzzle2293 {

    class Solution {
        public int minMaxGame(int[] nums) {
            int n = nums.length;
            while (n > 1) {
                n = recur(nums, 0, n);
            }
            return nums[0];
        }

        int recur(int[] nums, int left, int right) {
            boolean min = true;
            int i = 0;
            while (left < right) {
                int a = Math.min(nums[left], nums[left + 1]);
                int b = Math.max(nums[left], nums[left + 1]);
                nums[i] = min ? a : b;
                i++;
                left += 2;
                min = !min;
            }
            return i;
        }
    }
}
