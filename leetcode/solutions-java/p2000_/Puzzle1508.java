package p2000_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 *
 * @author half-dead
 */
public class Puzzle1508 {
    public static void main(String[] args) {
        Solution s = new Puzzle1508().new Solution();
        System.out.println(s.rangeSum(new int[]{1, 2, 3, 4}, 4, 0, 0));
    }

    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for (int i = 0; i < n; i++) {
                pq.offer(new int[]{nums[i], i + 1});
            }

            long res = 0L;
            for (int curr = 1; curr <= right; curr++) {
                int[] top = pq.poll();
                if (curr >= left) {
                    res += top[0];
                }
                if (top[1] < n) {
                    pq.offer(new int[]{top[0] + nums[top[1]], top[1] + 1});
                }
            }
            return (int) (res % 1000000007);
        }
    }

    // Brute Force
    class Solution1 {
        public int rangeSum(int[] nums, int n, int left, int right) {
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }

            int[] all = new int[n * (n + 1) / 2];
            for (int sz = 1, k = 0; sz <= n; sz++) {
                for (int i = 0; i + sz <= n; i++) {
                    all[k++] = sums[i + sz - 1] - (i > 0 ? sums[i - 1] : 0);
                }
            }
            Arrays.sort(all);

            long res = 0L;
            for (int i = left - 1; i < right; i++) {
                res += all[i];
            }
            return (int) (res % 1000000007);
        }
    }
}
