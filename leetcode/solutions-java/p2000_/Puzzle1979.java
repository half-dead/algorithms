package p2000_;

/**
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 *
 * @author half-dead
 */
public class Puzzle1979 {

    class Solution {
        public int findGCD(int[] nums) {
            int min = nums[0], max = nums[0];
            for (int n : nums) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            return gcd(min, max);
        }

        int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
    }
}
