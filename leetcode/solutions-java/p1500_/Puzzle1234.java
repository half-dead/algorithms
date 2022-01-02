package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 *
 * @author half-dead
 */
public class Puzzle1234 {
    public static void main(String[] args) {
        Solution s = new Puzzle1234().new Solution();
        System.out.println(s.balancedString("WQWRQQQW"));
    }

    class Solution {
        public int balancedString(String s) {
            char[] chars = s.toCharArray();
            int[] cnt = new int[128];
            for (char c : chars) cnt[c]++;

            int avg = chars.length >> 2;
            // calculate the minimum number of every letter that we need to find inside the sliding window
            int nq = Math.max(cnt['Q'] - avg, 0), nw = Math.max(cnt['W'] - avg, 0);
            int ne = Math.max(cnt['E'] - avg, 0), nr = Math.max(cnt['R'] - avg, 0);
            if (nq + nw + ne + nr == 0) return 0;

            Arrays.fill(cnt, 0);
            int start = 0, end = 0, ans = chars.length;
            while (end < chars.length) {
                cnt[chars[end]]++;
                while (cnt['Q'] >= nq && cnt['W'] >= nw && cnt['E'] >= ne && cnt['R'] >= nr) {
                    ans = Math.min(ans, end - start + 1);
                    cnt[chars[start++]]--;
                }
                end++;
            }
            return ans;
        }
    }
}
