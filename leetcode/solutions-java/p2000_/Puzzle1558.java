package p2000_;

/**
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 *
 * @author half-dead
 */
public class Puzzle1558 {

    public static void main(String[] args) {

    }

    class Solution {
        public int minOperations(int[] nums) {
            int max = 0, res = 0;
            for (int n : nums) {
                max = Math.max(max, n);
                res += Integer.bitCount(n);
            }
            return res + Integer.toBinaryString(max).length() - 1;
        }
    }
}
