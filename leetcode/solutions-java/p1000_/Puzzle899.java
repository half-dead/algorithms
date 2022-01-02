package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/orderly-queue/
 *
 * @author half-dead
 */
public class Puzzle899 {
    class Solution {
        public String orderlyQueue(String s, int k) {
            if (k > 1) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            } else {
                char[] chars = (s + s).toCharArray();
                for (int i = 1, len = s.length(); i < len; i++) {
                    String nexts = new String(chars, i, len);
                    if (nexts.compareTo(s) < 0) s = nexts;
                }
                return s;
            }
        }
    }

    class Solution2 {
        public String orderlyQueue(String s, int k) {
            char[] chs = s.toCharArray();
            if (k > 1) {
                Arrays.sort(chs);
                return new String(chs);
            }

            int min = 0;
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] < chs[min]) min = i;
            }

            char minCh = chs[min];
            for (int i = min + 1; i < chs.length; i++) {
                if (chs[i] == minCh && chs[i] != chs[i - 1]) {
                    if (compare(chs, min, i) > 0) {
                        min = i;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {
                sb.append(chs[(i + min) % chs.length]);
            }
            return sb.toString();
        }

        int compare(char[] chs, int i, int j) {
            for (int k = 0; k < chs.length; k++) {
                char a = chs[(i + k) % chs.length];
                char b = chs[(j + k) % chs.length];
                if (a < b) return -1;
                if (a > b) return 1;
            }
            return 0;
        }
    }
}
