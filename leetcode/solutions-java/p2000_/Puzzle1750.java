package p2000_;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 *
 * @author half-dead
 */
public class Puzzle1750 {

    class Solution {
        public int minimumLength(String s) {
            int len = s.length(), uniq = 0;
            char[] cs = s.toCharArray();

            int[] cnt = new int[3];
            for (char c : cs) if (cnt[c - 'a']++ == 0) uniq++;

            int left = 0, right = len - 1;
            while (uniq > 1) {
                char c = cs[left];
                int nl = left, nr = right;
                while (cs[nl] == c) nl++;
                while (cs[nr] == c) nr--;

                if (nl == left || nr == right) break;

                cnt[c - 'a'] -= (nl - left) + (right - nr);
                if (cnt[c - 'a'] == 0) uniq--;

                left = nl;
                right = nr;
            }
            if (uniq == 1 && cnt[cs[left] - 'a'] > 1) return 0;
            return right - left + 1;
        }
    }
}
