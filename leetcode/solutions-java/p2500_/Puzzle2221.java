package p2500_;

/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 * <p>
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/discuss/1907380/O(n)-time-O(1)-space-Python-189-ms-C%2B%2B-12-ms-Java-4-ms
 *
 * @author half-dead
 */
public class Puzzle2221 {

    // O(N^2) time, O(1) space, simulation

    class Solution {
        public int triangularSum(int[] nums) {
            for (int n = nums.length; n > 1; n--) {
                for (int i = 0; i < n - 1; i++) {
                    nums[i] = (nums[i] + nums[i + 1]) % 10;
                }
            }
            return nums[0];
        }
    }
}
