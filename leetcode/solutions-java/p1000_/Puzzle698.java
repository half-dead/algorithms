package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * @author half-dead
 */
public class Puzzle698 {
    public static void main(String[] args) {
        Solution s = new Puzzle698().new Solution();
        System.out.println(s.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5));
        System.out.println(s.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(s.canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3));
        System.out.println(s.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
    }

    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) return true;
            Arrays.sort(nums);
            int len = nums.length, sum = 0, max = nums[len - 1], target;
            for (int n : nums) sum += n;
            if (sum % k != 0 || max > (target = sum / k)) return false;
            return bt(nums, new boolean[len], k, target, 0, len - 1);
        }

        boolean bt(int[] nums, boolean[] visited, int k, int target, int sum, int idx) {
            if (k == 0) return true;
            if (sum == target) return bt(nums, visited, k - 1, target, 0, nums.length - 1);

            for (int j = idx; j >= 0; j--) {
                if (visited[j] || nums[j] + sum > target) continue;

                visited[j] = true;
                if (bt(nums, visited, k, target, sum + nums[j], j - 1)) return true;
                visited[j] = false;
            }
            return false;
        }
    }

    // TODO
    class DpSolution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            int len = nums.length, sum = Arrays.stream(nums).sum(), target = sum / k, max = 1 << len;
            if (sum % k > 0 || nums[len - 1] > target) return false;

            int[] total = new int[max];
            boolean[] dp = new boolean[max];
            dp[0] = true;

            for (int state = 0; state < max; state++) {
                if (!dp[state]) continue;

                for (int i = 0; i < len; i++) {
                    int future = state | (1 << i);
                    if (state != future && !dp[future]) {
                        if (nums[i] <= target - (total[state] % target)) {
                            dp[future] = true;
                            total[future] = total[state] + nums[i];
                        } else {
                            break;
                        }
                    }
                }
            }
            return dp[max - 1];
        }
    }

    class Solution2 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int end = nums.length - 1, sum = Arrays.stream(nums).sum(), target;
            if (sum % k > 0) return false;

            Arrays.sort(nums);
            if (nums[end] > (target = sum / k)) return false;
            while (end >= 0 && nums[end] == target) {
                end--;
                k--;
            }
            return search(new int[k], end, nums, target);
        }

        public boolean search(int[] groups, int idx, int[] nums, int target) {
            if (idx < 0) return true;
            int n = nums[idx--];
            for (int i = 0; i < groups.length; i++) {
                if (groups[i] + n <= target) {
                    groups[i] += n;
                    if (search(groups, idx, nums, target)) return true;
                    groups[i] -= n;
                }
                // it's impossible to find a subset containing n that sums to target, just return false;
                if (groups[i] == 0) break;
            }
            return false;
        }
    }

}
