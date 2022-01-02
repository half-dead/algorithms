package p2000_;

/**
 * https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
 *
 * @author half-dead
 */
public class Puzzle1839 {

    class Solution {
        public int longestBeautifulSubstring(String word) {
            char[] chars = word.toCharArray();
            int[] order = new int[128];
            order['a'] = 1;
            order['e'] = 2;
            order['i'] = 3;
            order['o'] = 4;
            order['u'] = 5;

            char prev = 'a';
            int cnt = 0, res = 0;
            for (int i = 0, len = chars.length; i < len; i++) {
                char c = chars[i];
                if (c == prev || (order[c] - order[prev] == 1 && cnt > 0)) {
                    cnt++;
                    prev = c;
                    if (c == 'u') {
                        res = Math.max(res, cnt);
                    }
                } else {
                    prev = 'a';
                    cnt = 0;
                    if (c == 'a') {
                        i--;
                    }
                }
            }
            return res;
        }
    }
}
