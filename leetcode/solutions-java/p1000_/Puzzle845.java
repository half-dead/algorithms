package p1000_;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * @author half-dead
 */
public class Puzzle845 {
    class Solution {
        public int longestMountain(int[] a) {
            int n = a.length, i = 0, max = 0;
            while (i < n) {
                boolean incr = false, decr = false;

                int start = i;
                while (i + 1 < n && a[i] < a[i + 1]) i++;
                if (i > start) incr = true;

                int hi = i;
                while (i + 1 < n && a[i] > a[i + 1]) i++;
                if (i > hi) decr = true;

                if (incr && decr) {
                    max = Math.max(max, i - start + 1);
                } else if (!incr && !decr) {
                    i++;
                }
            }
            return max;

        }
    }

    class Solution0 {
        public int longestMountain(int[] A) {
            int res = 0, up = 0, down = 0;
            for (int i = 1; i < A.length; ++i) {
                if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
                if (A[i - 1] < A[i]) up++;
                if (A[i - 1] > A[i]) down++;
                if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
            }
            return res;
        }
    }
}
