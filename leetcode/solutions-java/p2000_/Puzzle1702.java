package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-binary-string-after-change/
 *
 * @author half-dead
 */
public class Puzzle1702 {

    class Solution {
        public String maximumBinaryString(String binary) {
            char[] cs = binary.toCharArray();
            int c0 = 0, f0 = binary.indexOf('0');
            for (char c : cs) {
                if (c == '0') {
                    c0++;
                }
            }
            if (c0 == 0 || (c0 == 1 && f0 == 0))
                return binary;

            Arrays.fill(cs, '1');
            cs[f0 + c0 - 1] = '0';
            return new String(cs);
        }
    }
}
