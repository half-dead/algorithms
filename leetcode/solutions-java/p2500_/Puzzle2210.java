package p2500_;

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 *
 * @author half-dead
 */
public class Puzzle2210 {
    class Solution {
        public int countHillValley(int[] nums) {
            int n = nums.length, res = 0;
            for (int i = 1, left = 0, mid = nums[0]; i < n; i++) {
                if (nums[i] == mid) continue;
                if (left > 0 && (left > mid) != (mid > nums[i])) res++;
                left = mid;
                mid = nums[i];
            }
            return res;
        }
    }
}
