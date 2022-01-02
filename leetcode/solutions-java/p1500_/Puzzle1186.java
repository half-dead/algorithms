package p1500_;

/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 *
 * @author half-dead
 */
public class Puzzle1186 {

    // two pass
    class Solution {
        public int maximumSum(int[] arr) {
            int n = arr.length, res = arr[0];

            int[] ends = new int[n];
            ends[0] = arr[0];
            for (int i = 1; i < n; i++) {
                ends[i] = Math.max(ends[i - 1] + arr[i], arr[i]);
                res = Math.max(res, ends[i]);
            }

            int[] starts = new int[n];
            starts[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                starts[i] = Math.max(starts[i + 1] + arr[i], arr[i]);
            }

            for (int i = 1; i < n - 1; i++)
                res = Math.max(res, ends[i - 1] + starts[i + 1]);

            return res;
        }
    }

    // dp, one pass
    class Solution1 {
        public int maximumSum(int[] arr) {
            int d = 0, nd = arr[0], res = nd;
            for (int i = 1, n = arr.length; i < n; i++) {
                d = Math.max(nd, d + arr[i]);
                nd = Math.max(0, nd) + arr[i];
                res = Math.max(res, Math.max(d, nd));
            }
            return res;
        }
    }
}
