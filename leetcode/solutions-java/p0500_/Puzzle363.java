package p0500_;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 * @author half-dead
 */
public class Puzzle363 {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Solution s = new Puzzle363().new Solution();
        int[][] t1 = generateMatrix(10, 100000), t2 = generateMatrix(10000, 100), t3 = generateMatrix(1000, 1000);
        int k = 1058;
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) s.maxSumSubmatrix(t1, k);
        long a2 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) s.maxSumSubmatrix(t2, k);
        long a3 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) s.maxSumSubmatrix(t3, k);
        long a4 = System.currentTimeMillis();
        System.out.println(Arrays.toString(new long[]{a2 - a1, a3 - a2, a4 - a3}));
    }

    static int[][] generateMatrix(int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = random.nextInt(201) - 100;
            }
        }
        return mat;
    }

    // Kadane's algorithm, O(NlogN * M^2) time, O(N) space, N=max(m,n), M=min(m,n)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length, ans = Integer.MIN_VALUE;
            if (m > n) {
                // make sure m < n too get more efficiency and cpu affinity
                matrix = rotate(matrix);
                m = matrix.length;
                n = matrix[0].length;
            }

            int[] dp = new int[n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp, 0);
                for (int j = i; j < m; j++) {
                    int[] row = matrix[j];
                    for (int c = 0; c < n; c++) {
                        dp[c] += row[c];
                    }

                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);
                    int sum = 0;
                    for (int c = 0; c < n; c++) {
                        sum += dp[c];
                        Integer ceil = set.ceiling(sum - k);
                        if (ceil != null) {
                            ans = Math.max(ans, sum - ceil);
                            if (ans == k) return k;
                        }
                        set.add(sum);
                    }
                }
            }
            return ans;
        }

        private int[][] rotate(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][m - i - 1] = mat[i][j];
                }
            }
            return res;
        }
    }

    // prefix-sum, brute-force, O((MN)^2) time, O(MN) space
    class BruteForceSolution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length, ans = Integer.MIN_VALUE;
            int[][] ps = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j] + matrix[i][j];

                    for (int r = 0; r <= i; r++) {
                        for (int c = 0; c <= j; c++) {
                            int sum = ps[i + 1][j + 1] - ps[r][j + 1] - ps[i + 1][c] + ps[r][c];
                            if (sum <= k) ans = Math.max(ans, sum);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
