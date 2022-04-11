package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
 *
 * @author half-dead
 */
public class Puzzle2165 {

    class Solution {
        public long smallestNumber(long num) {
            boolean pos = num >= 0;

            char[] cs = String.valueOf(Math.abs(num)).toCharArray();
            Arrays.sort(cs);
            if (!pos) {
                for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
                    char c = cs[i];
                    cs[i] = cs[j];
                    cs[j] = c;
                }
            } else if (cs[0] == '0' && num != 0) {
                int i = 0;
                while (cs[i] == '0') i++;
                cs[0] = cs[i];
                cs[i] = '0';
            }
            return Long.parseLong(new String(cs)) * (pos ? 1 : -1);
        }
    }
}
