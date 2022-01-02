package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 * it's just a special case of problem 698
 *
 * @author half-dead
 */
public class Puzzle473 {

    // dp solution, O(N*2^N) time, O(2^N) space
    class Solution {
        public boolean makesquare(int[] nums) {
            int len = nums.length, sum = 0, total = 1 << len;
            if (len < 4) return false;

            Arrays.sort(nums);
            for (int n : nums) sum += n;
            if (sum % 4 != 0 || nums[len - 1] > (sum >>= 2)) return false;

            boolean[] reachable = new boolean[total];
            reachable[0] = true;

            int[] states = new int[total], comps = new int[len];
            for (int i = 0; i < len; i++) comps[i] = 1 << i;

            for (int st = 0; st < total; st++) {
                if (!reachable[st]) continue;

                int mod = states[st] % sum, next;
                for (int j = 0; j < len; j++) {
                    if (st != (next = st | comps[j]) && !reachable[next]) {
                        if (mod + nums[j] <= sum) {
                            states[next] = states[st] + nums[j];
                            reachable[next] = true;
                        } else break;
                    }
                }
            }
            return reachable[total - 1];
        }
    }

    class DfsSolution {
        public boolean makesquare(int[] nums) {
            int len = nums.length, sum = 0, max = 0, target;
            if (len < 4) return false;
            for (int n : nums) {
                sum += n;
                max = Math.max(max, n);
            }
            if (sum % 4 != 0 || max > (target = sum >> 2)) return false;
            return dfs(nums, new boolean[len], target, 0, 4, 0);
        }

        boolean dfs(int[] nums, boolean[] used, int target, int curr, int k, int i) {
            if (k == 0) return true;
            if (curr == target) return dfs(nums, used, target, 0, k - 1, 0);

            for (int j = i; j < nums.length; j++) {
                if (!used[j] && curr + nums[j] <= target) {
                    used[j] = true;
                    if (dfs(nums, used, target, curr + nums[j], k, j + 1)) return true;
                    used[j] = false;
                    // it's impossible to sum nums[j] and other numbers to given target.
                    if (curr == 0) break;
                }
            }
            return false;
        }
    }
}
