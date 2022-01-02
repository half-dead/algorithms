package p2000_;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 *
 * @author half-dead
 */
public class Puzzle1991 {

    class Solution {
        public int findMiddleIndex(int[] nums) {
            int sum = 0, temp = 0;
            for (int n : nums) sum += n;
            for (int i = 0; i < nums.length; i++) {
                if (temp == sum - temp - nums[i]) return i;
                temp += nums[i];
            }
            return -1;
        }
    }
}
