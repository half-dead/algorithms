package p2000_;

/**
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 *
 * @author half-dead
 */
public class Puzzle1802 {

    public static void main(String[] args) {
        Solution s = new Puzzle1802().new Solution();
        System.out.println(s.maxValue(4, 2, 6));
        System.out.println(s.maxValue(6, 1, 10));
        System.out.println(s.maxValue(4, 0, 4));
    }

    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            long lo = 1, hi = maxSum;
            while (lo < hi) {
                long mid = (lo + hi + 1) >> 1;
                long minRight = Math.max(1, mid - (n - 1 - index));
                long minLeft = Math.max(1, mid - index);
                long sumLeft = mid * (mid + 1) / 2 - minLeft * (minLeft - 1) / 2 + (index - (mid - minLeft));
                long sumRight = mid * (mid + 1) / 2 - minRight * (minRight - 1) / 2 + (n - 1 - index - (mid - minRight));
                if (sumLeft + sumRight - mid > maxSum) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            return (int) lo;
        }
    }
}
