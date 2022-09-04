package util;

/**
 * @author half-dead
 */
class TwoDArraySum {
    int[][] sum;
    int m, n;

    // nums index starts from 0
    public TwoDArraySum(final int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }
    }

    // [(x1, y1), (x2, y2)], index starts from 0
    // x1 <= x2 and y1 <= y2
    public int getSum(int x1, int y1, int x2, int y2) {
        if (!(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && x2 >= 0 && x2 < m && y2 >= 0 && y2 < n) || x1 > x2 || y1 > y2)
            return 0;
        return sum[x2 + 1][y2 + 1] - sum[x2 + 1][y1] - sum[x1][y2 + 1] + sum[x1][y1];
    }
}
