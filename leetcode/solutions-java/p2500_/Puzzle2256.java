package p2500_;

/**
 * https://leetcode.com/problems/minimum-average-difference/
 *
 * @author half-dead
 */
public class Puzzle2256 {

    class Solution {
        public int minimumAverageDifference(int[] nums) {
            long sum = 0L;
            for (int x : nums) sum += x;

            int i = 0, n = nums.length, min = (int) (sum / n), res = n - 1;
            long left = 0L, right = sum;
            while (i < n - 1) {
                left += nums[i];
                right -= nums[i];
                int diff = (int) Math.abs(left / (i + 1) - right / (n - i - 1));
                if (diff < min || (diff == min && i < res)) {
                    min = diff;
                    res = i;
                }
                i++;
            }
            return res;
        }
    }
}
