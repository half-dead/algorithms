package p2500_;

/**
 * https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
 *
 * @author half-dead
 */
public class Puzzle2207 {
    class Solution {
        public long maximumSubsequenceCount(String text, String pattern) {
            char a = pattern.charAt(0), b = pattern.charAt(1);
            int n = text.length(), ca = 0, cb = 0;
            char[] chars = text.toCharArray();
            for (char c : chars) {
                if (c == a) ca++;
                else if (c == b) cb++;
            }

            if (a == b) return (ca + 1) * (long) ca / 2;

            long sum1 = cb, sum2 = ca;
            for (int i = 0, cnt = 0; i < n; i++) {
                if (chars[i] == a) {
                    sum1 += cb;
                    cnt++;
                } else if (chars[i] == b) {
                    sum2 += cnt;
                    cb--;
                }

            }
            return Math.max(sum1, sum2);
        }
    }
}
