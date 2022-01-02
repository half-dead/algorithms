package p2500_;

/**
 * https://leetcode.com/problems/rings-and-rods/submissions/
 *
 * @author half-dead
 */
public class Puzzle2103 {
    class Solution {
        public int countPoints(String rings) {
            int n = rings.length(), res = 0;
            int[][] cnt = new int[10][26];
            for (int i = 0; i < n; i += 2) {
                int color = rings.charAt(i) - 'A';
                int rod = rings.charAt(i + 1) - '0';
                cnt[rod][color]++;
            }

            for (int i = 0; i < 10; i++) {
                if (cnt[i]['R' - 'A'] > 0 && cnt[i]['G' - 'A'] > 0 && cnt[i]['B' - 'A'] > 0) res++;
            }
            return res;
        }
    }
}
