package p1500_;

/**
 * https://leetcode.com/problems/check-if-it-is-a-good-array/
 *
 * @author half-dead
 */
public class Puzzle1250 {

    class Solution {
        public boolean isGoodArray(int[] nums) {
            int x = nums[0];
            for (int n : nums) {
                if ((x = gcd(x, n)) == 1) return true;
            }
            return false;
        }

        int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
    }
}
