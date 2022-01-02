package p1500_;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * @author half-dead
 */
public class Puzzle1358 {

    class Solution {
        public int numberOfSubstrings(String s) {
            char[] cs = s.toCharArray();
            int len = cs.length;
            int ca = 0, cb = 0, cc = 0;
            int left = 0, right = 0;
            int res = 0;
            while (right < len) {
                if (cs[right] == 'a') ca++;
                else if (cs[right] == 'b') cb++;
                else cc++;

                if (ca >= 1 && cb >= 1 && cc >= 1) {
                    res += len - right;
                }
                while (ca > 0 && cb > 0 && cc > 0) {
                    char remove = cs[left++];
                    if (remove == 'a') ca--;
                    else if (remove == 'b') cb--;
                    else cc--;
                    if (ca >= 1 && cb >= 1 && cc >= 1) res += len - right;
                }
                right++;
            }
            return res;
        }

        // another sliding window solution
        public int numberOfSubstrings2(String s) {
            int[] count = {0, 0, 0};
            int res = 0, n = s.length(), i = 0;
            for (int j = 0; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                    count[s.charAt(i++) - 'a']++;
                res += i;
            }
            return res;
        }

        public int numberOfSubstrings3(String s) {
            int[] last = {-1, -1, -1};
            int res = 0, n = s.length();
            for (int i = 0; i < n; ++i) {
                last[s.charAt(i) - 'a'] = i;
                res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
            }
            return res;
        }
    }
}
