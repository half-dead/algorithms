package p2000_;

/**
 * https://leetcode.com/problems/minimum-sideway-jumps/
 *
 * @author half-dead
 */
public class Puzzle1824 {

    public static void main(String[] args) {
        Solution s = new Puzzle1824().new Solution();
        System.out.println(s.minSideJumps(new int[]{0, 1, 2, 3, 0}));
        System.out.println(s.minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
        System.out.println(s.minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
        System.out.println(s.minSideJumps(new int[]{0, 0, 0, 0, 2, 1, 2, 0, 2, 2, 3, 3, 3, 0, 0, 1, 1, 3, 0, 0, 0, 1, 2, 2, 1, 2, 1, 3, 2, 2, 3, 1, 3, 0, 1, 1, 1, 3, 0, 0, 0, 2, 0, 2, 0, 3, 1, 2, 3, 3, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 2, 1, 2, 3, 1, 0, 3, 3, 2, 0, 1, 1, 0, 1, 0, 2, 2, 2, 1, 3, 0, 3, 0, 2, 1, 1, 3, 1, 0, 1, 2, 2, 0, 0}));
    }

    class Solution2 {
        public int minSideJumps(int[] o) {
            int len = o.length;
            int[] dp = new int[4];
            dp[1] = dp[3] = 1;

            for (int i = 1; i < len; i++) {
                int[] next = new int[4];
                next[1] = next[2] = next[3] = 11111111;

                for (int j = 1; j <= 3; j++) {
                    if (o[i] != j) {
                        if (o[i - 1] != j) {
                            next[j] = Math.min(next[j], dp[j]);
                        }
                        int n1 = j == 1 ? 3 : j - 1, n2 = j == 3 ? 1 : j + 1;
                        next[j] = Math.min(next[j], dp[n1] + (o[i] == n1 ? 2 : 1));
                        next[j] = Math.min(next[j], dp[n2] + (o[i] == n2 ? 2 : 1));
                    }
                }
                dp = next;
            }
            return Math.min(Math.min(dp[1], dp[2]), dp[3]);
        }
    }

    class Solution {
        public int minSideJumps(int[] o) {
            int len = o.length;
            int a = 1, b = 0, c = 1, d, e, f;

            for (int i = 1; i < len; i++) {
                d = e = f = 11111111;
                if (o[i] != 1) {
                    d = Math.min(a, Math.min(b + (o[i] == 2 ? 2 : 1), c + (o[i] == 3 ? 2 : 1)));
                }
                if (o[i] != 2) {
                    e = Math.min(b, Math.min(a + (o[i] == 1 ? 2 : 1), c + (o[i] == 3 ? 2 : 1)));
                }
                if (o[i] != 3) {
                    f = Math.min(c, Math.min(a + (o[i] == 1 ? 2 : 1), b + (o[i] == 2 ? 2 : 1)));
                }
                a = d;
                b = e;
                c = f;
            }
            return Math.min(Math.min(a, b), c);
        }
    }
}
