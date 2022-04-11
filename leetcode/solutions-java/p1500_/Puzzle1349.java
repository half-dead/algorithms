package p1500_;

/**
 * https://leetcode.com/problems/maximum-students-taking-exam/
 *
 * @author half-dead
 */
public class Puzzle1349 {

    public static void main(String[] args) {

        Solution s = new Puzzle1349().new Solution();
        System.out.println(s.maxStudents(new char[][]{
                "#.##.#".toCharArray(),
                ".####.".toCharArray(),
                "#.##.#".toCharArray()
        }));
    }

    // dp, bit masking
    class Solution {
        public int maxStudents(char[][] seats) {
            int m = seats.length, n = seats[0].length, max = 1 << n, res = 0;

            int[] brokenlist = new int[m];
            for (int i = 0; i < m; i++) {
                int state = 0;
                for (int j = 0; j < n; j++) {
                    if (seats[i][j] == '#')
                        state |= (1 << j);
                }
                brokenlist[i] = state;
            }

            int[][] dp = new int[m + 1][max];
            for (int r = 1; r <= m; r++) {
                for (int curr = 0; curr < max; curr++) {
                    if ((curr & brokenlist[r - 1]) != 0) continue;

                    int bits = Integer.bitCount(curr);
                    for (int prev = 0; prev < max; prev++) {
                        if (check(prev, curr)) {
                            dp[r][curr] = Math.max(dp[r][curr], dp[r - 1][prev] + bits);
                        }
                    }
                }
            }

            for (int x : dp[m]) res = Math.max(res, x);
            return res;
        }

        boolean check(int prev, int curr) {
            int v = curr;
            while (v > 0) {
                if ((v & 3) == 3) return false;
                v >>= 1;
            }

            int mask = 1;
            while (mask <= curr) {
                if ((curr & mask) == mask) {
                    if ((prev & (mask << 1)) != 0 || (prev & (mask >> 1)) != 0)
                        return false;
                }
                mask <<= 1;
            }
            return true;
        }
    }
}
