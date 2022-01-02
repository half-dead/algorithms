package p2000_;

/**
 * https://leetcode.com/problems/longest-nice-substring/
 *
 * @author half-dead
 */
public class Puzzle1763 {
    class Solution {
        public String longestNiceSubstring(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            char[] chars = s.toCharArray();

            int[] cnt = new int[128];
            for (char c : chars) {
                cnt[c]++;
            }

            boolean[] flag = new boolean[128];
            for (int i = 'A'; i <= 'Z'; i++) {
                if (cnt[i] * cnt[i + 32] == 0) {
                    flag[i] = flag[i + 32] = true;
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (flag[chars[i]]) {
                    String s1 = longestNiceSubstring(s.substring(0, i));
                    String s2 = longestNiceSubstring(s.substring(i + 1));
                    if (s2.length() > s1.length()) {
                        return s2;
                    } else {
                        return s1;
                    }
                }
            }
            return s;
        }
    }
}
