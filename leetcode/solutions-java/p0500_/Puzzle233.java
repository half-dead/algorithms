package p0500_;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 *
 * @author half-dead
 */
public class Puzzle233 {

    // recursion
    class Solution {
        String zeros = "00000000000";
        int[] nums = new int[]{0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        public int countDigitOne(int n) {
            if (n == 0) return 0;

            String s = n + "";
            char first = s.charAt(0);
            int len = s.length(), next = n - Integer.parseInt((first + zeros).substring(0, len));
            return (first == '1' ? (next + 1) : nums[len])
                    + countDigitOne(next)
                    + (first - '0') * countDigitOne(nums[len] - 1);
        }
    }
}
