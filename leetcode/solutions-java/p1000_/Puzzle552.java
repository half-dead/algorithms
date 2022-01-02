package p1000_;

/**
 * https://leetcode.com/problems/student-attendance-record-ii/
 *
 * @author half-dead
 */
public class Puzzle552 {

    class Solution {
        public int checkRecord(int n) {
            int mod = (int) 1e9 + 7;
            long nap = 1, nal = 1, nall = 0;
            long aap = 1, al = 0, all = 0;

            for (int i = 1; i < n; i++) {
                long _nap = nap + nal + nall, _nal = nap, _nall = nal;
                long _aap = nap + nal + nall + aap + al + all, _al = aap, _all = al;

                nap = _nap % mod;
                nal = _nal;
                nall = _nall;
                aap = _aap % mod;
                al = _al;
                all = _all;
            }
            return (int) ((nap + nal + nall + aap + al + all) % mod);
        }
    }

    // 看不懂
    class Solution1 {
        final int mod = (int) 1e9 + 7;

        public int checkRecord(int n) {
            // help[0][0] = 1, 和 dp[0][0] 含义一致
            // 这里将 dp 二维，进行了降维处理
            long[][] help = new long[][]{{1}, {0}, {0}, {0}, {0}, {0}};

            // [0, 5] 状态转化， e.g. stat[0][0, 1, 2] -> 「0」,
            // 简单点说就是 [0, 1, 2] 可以转换为 「0」
            long[][] stat = new long[][]{
                    {1, 1, 1, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1},
                    {0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 0}
            };

            while (n != 0) {
                if ((n & 1) != 0) help = mul(stat, help);

                stat = mul(stat, stat);
                n >>= 1;
            }

            long res = 0L;
            for (int i = 0; i < 6; i++) res += help[i][0];
            return (int) (res % mod);
        }

        private long[][] mul(long[][] a, long[][] b) {
            int aRows = a.length, bRows = b.length, bCols = b[0].length;
            long[][] ans = new long[aRows][bCols];
            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < bCols; j++) {
                    for (int k = 0; k < bRows; k++) {
                        ans[i][j] += a[i][k] * b[k][j];
                        ans[i][j] %= mod;
                    }
                }
            }
            return ans;
        }
    }
}
