package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
 *
 * @author half-dead
 */
public class Puzzle1781 {

    class Solution {
        public int beautySum(String s) {
            int len = s.length();
            int[][] ps = new int[len + 1][26];
            char[] cs = s.toCharArray();
            for (int i = 0; i < len; i++) {
                ps[i + 1] = Arrays.copyOf(ps[i], 26);
                ps[i + 1][cs[i] - 'a']++;
            }

            int res = 0;
            for (int i = 1; i <= len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    res += beauty(ps[i - 1], ps[j]);
                }
            }
            return res;
        }

        int beauty(int[] a, int[] b) {
            int max = 0, min = 5000;
            for (int i = 0; i < 26; i++) {
                int f = b[i] - a[i];
                if (f > 0) {
                    max = Math.max(max, f);
                    min = Math.min(min, f);
                }
            }
            return max - min;
        }
    }
}
