package p2500_;

/**
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 *
 * @author half-dead
 */
public class Puzzle2091 {

    class Solution {
        public int minimumDeletions(int[] nums) {
            int n = nums.length;
            if (n < 3) return n;

            int minIndex = 0, maxIndex = 0;
            for (int i = 0, min = nums[0], max = nums[0]; i < n; i++) {
                if (nums[i] < min) min = nums[minIndex = i];
                if (nums[i] > max) max = nums[maxIndex = i];
            }

            int left = Math.min(minIndex, maxIndex), right = Math.max(minIndex, maxIndex);
            return Math.min(left + 1 + n - right, Math.min(right + 1, n - left));
        }
    }
}
