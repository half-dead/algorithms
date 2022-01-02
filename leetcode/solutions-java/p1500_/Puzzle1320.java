package p1500_;

/**
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
 *
 * @author half-dead
 */
public class Puzzle1320 {
    public static void main(String[] args) {
        Solution s = new Puzzle1320().new Solution();
        System.out.println(s.minimumDistance(""));
    }

    class Solution {
        int[][] map;

        {
            map = new int[26][2];
            int r = 0, c = 0;
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                map[ch - 'A'] = new int[]{r, c};
                c++;
                if (c == 6) {
                    r++;
                    c = 0;
                }
            }
        }

        // only use one finger | use two fingers
        // {count, pos,        | count, pos1, pos2, count, pos1, pos2}
        public int minimumDistance(String word) {
            char[] chars = word.toCharArray();
            int[] dp = new int[]{
                    0, chars[0],
                    0, chars[0], -1,
                    0, -1, chars[0]
            };

            for (int i = 1; i < chars.length; i++) {
                int p0 = dp[0], p1 = dp[1];
                int p2 = dp[2], p3 = dp[3], p4 = dp[4];
                int p5 = dp[5], p6 = dp[6], p7 = dp[7];

                int c0 = p0 + distance(p1, chars[i]);
                int c1 = chars[i];

            }
            return 0;
        }

        int distance(int from, int to) {
            int[] p1 = map[from - 'A'], p2 = map[to - 'A'];
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }
    }
}
