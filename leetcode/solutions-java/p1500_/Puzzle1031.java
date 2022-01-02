package p1500_;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 *
 * @author half-dead
 */
public class Puzzle1031 {
    public static void main(String[] args) {
        Solution s = new Puzzle1031().new Solution();
        System.out.println(s.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }

    // two pass, O(2*N) time, O(N) space, 0ms
    class Solution {
        public int maxSumTwoNoOverlap(int[] a, int m, int n) {
            int len = a.length;
            int[] sum = new int[len + 1];
            for (int i = 0; i < len; i++) sum[i + 1] = sum[i] + a[i];
            int max = max(sum, m, n);
            if (m != n) max = Math.max(max, max(sum, n, m));
            return max;
        }

        int max(int[] sum, int m, int n) {
            int len = sum.length, max = 0, maxm = 0;
            for (int i = m; i < len - n; i++) {
                maxm = Math.max(maxm, sum[i] - sum[i - m]);
                max = Math.max(max, maxm + sum[i + n] - sum[i]);
            }
            return max;
        }
    }

    // brute force with prefix sum, O(N^2) time, O(N) space, 3ms
    class BruteForceSolution {
        public int maxSumTwoNoOverlap(int[] a, int m, int n) {
            int len = a.length;
            int[] sum = new int[len + 1];
            for (int i = 0; i < len; i++) sum[i + 1] = sum[i] + a[i];
            int max = getMax(sum, m, n);
            return m == n ? max : Math.max(max, getMax(sum, n, m));
        }

        int getMax(int[] sum, int m, int n) {
            int len = sum.length, max = 0;
            for (int i = m; i < len - n; i++) {
                int sum1 = sum[i] - sum[i - m];
                for (int j = i + n; j < len; j++)
                    max = Math.max(max, sum1 + sum[j] - sum[j - n]);
            }
            return max;
        }
    }
}
