package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 *
 * @author half-dead
 */
public class Puzzle2160 {

    class Solution {
        public int minimumSum(int num) {
            char[] cs = String.valueOf(num).toCharArray();
            Arrays.sort(cs);
            return (cs[0] - '0' + cs[1] - '0') * 10 + (cs[2] - '0' + cs[3] - '0');
        }
    }
}
