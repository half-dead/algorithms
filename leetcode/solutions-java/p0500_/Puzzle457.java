package p0500_;

/**
 * https://leetcode.com/problems/circular-array-loop/
 *
 * @author half-dead
 */
public class Puzzle457 {

    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (Math.abs(nums[i]) % len == 0) nums[i] = 0;
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) continue;

                boolean positive = nums[i] > 0;
                int j = i;
                while (true) {
                    int step = nums[j];
                    nums[j] += 10000;
                    j = (j + step) % len;
                    if (j < 0) j += len;

                    if (nums[j] == 0) break;
                    if (nums[j] > 1000) return true;
                    if (positive ^ (nums[j] > 0)) break;
                }

                j = i;
                while (true) {
                    int step = nums[j] - 10000;
                    nums[j] = 0;
                    j = (j + step) % len;
                    if (j < 0) j += len;

                    if (nums[j] == 0) break;
                    if (positive ^ (nums[j] > 0)) break;
                }
            }
            return false;
        }
    }
}
