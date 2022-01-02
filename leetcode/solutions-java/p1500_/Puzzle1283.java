package p1500_;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 *
 * @author half-dead
 */
public class Puzzle1283 {

    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int lo = 1, hi = 1000000;
            while (lo < hi) {
                int mid = (lo + hi) / 2, sum = 0;
                for (int n : nums) sum += (n + mid - 1) / mid;
                if (sum > threshold) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }

    class Solution1 {
        public int smallestDivisor(int[] nums, int threshold) {
            int len = nums.length, max = 0;
            long sum = 0;
            for (int n : nums) {
                sum += n;
                max = Math.max(max, n);
            }
            if (len == threshold) return max;
            if (sum <= threshold) return 1;

            int lo = (int) (sum / threshold), hi = max;
            while (lo < hi) {
                int mid = (lo + hi) / 2, tmp = 0;
                for (int n : nums) {
                    tmp += n / mid;
                    if (n % mid != 0) tmp++;
                }

                if (tmp > threshold) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }
}
