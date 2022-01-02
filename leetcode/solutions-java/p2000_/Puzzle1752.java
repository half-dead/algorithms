package p2000_;

/**
 * @author half-dead
 */
public class Puzzle1752 {

    class Solution {
        public boolean check(int[] nums) {
            int n = nums.length, decr = 0;
            if (nums[n - 1] > nums[0]) decr++;
            for (int i = 1; i < n; i++)
                if (nums[i - 1] > nums[i] && decr++ > 0)
                    return false;
            return true;
        }
    }
}
