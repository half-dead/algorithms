package p2500_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 */
public class Puzzle2448 {

    public static void main(String[] args) {
        Solution s = new Puzzle2448().new Solution();
        System.out.println(s.minCost(new int[]{
                1, 3, 5, 2
        }, new int[]{
                2, 3, 1, 14
        }));
    }

    class Solution {
        public long minCost(int[] nums, int[] cost) {

            long right = 0, left = 0, result = 0L;

            int n = nums.length;
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i] = new int[]{nums[i], cost[i]};
                right += cost[i];
            }

            Arrays.sort(a, Comparator.comparingInt(x -> x[0]));

            int i = 0;
            while (left < right) {
                left += a[i][1];
                right -= a[i][1];
                i++;
            }

            int target = a[i - 1][0];
            for (int j = 0; j < n; j++) {
                result += (long) a[j][1] * Math.abs(a[j][0] - target);
            }
            return result;
        }
    }
}
