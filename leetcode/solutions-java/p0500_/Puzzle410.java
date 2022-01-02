package p0500_;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 *
 * @author half-dead
 */
public class Puzzle410 {

    public static void main(String[] args) {
        Solution s = new Puzzle410().new Solution();
        System.out.println(s.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(s.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(s.splitArray(new int[]{1, 4, 4}, 3));
    }

    class Solution {
        public int splitArray(int[] nums, int m) {
            int sum = 0;
            for (int e : nums) sum += e;

            int lo = (sum + m - 1) / m, hi = sum;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (check(nums, mid, m)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        private boolean check(int[] nums, int sum, int m) {
            int i = 0, n = nums.length, runsum = 0;
            while (i < n) {
                if (nums[i] > sum) return false;
                runsum += nums[i];
                if (runsum > sum) {
                    runsum = nums[i];
                    m--;
                }
                i++;
            }
            return m > 0;
        }
    }
}
