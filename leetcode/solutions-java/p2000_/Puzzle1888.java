package p2000_;

/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 *
 * @author half-dead
 */
public class Puzzle1888 {

    // sliding window
    // try 10101.... and 01010....
    class Solution {
        public int minFlips(String s) {
            int n = s.length();
            String ss = s + s;

            // starts with '0'
            int cnt = 0, res = n;
            for (int i = 0; i < n + n; i++) {
                char c = ss.charAt(i);
                if ((c == '0') != (i % 2 == 0)) cnt++;
                if (i >= n) {
                    int j = i - n;
                    char cj = ss.charAt(j);
                    if ((cj == '0') != (j % 2 == 0)) cnt--;
                    res = Math.min(res, cnt);
                }
            }

            // starts with '1'
            cnt = 0;
            for (int i = 0; i < n + n; i++) {
                char c = ss.charAt(i);
                if ((c == '0') == (i % 2 == 0)) cnt++;
                if (i >= n) {
                    int j = i - n;
                    char cj = ss.charAt(j);
                    if ((cj == '0') == (j % 2 == 0)) cnt--;
                    res = Math.min(res, cnt);
                }
            }
            return res;
        }
    }
}
