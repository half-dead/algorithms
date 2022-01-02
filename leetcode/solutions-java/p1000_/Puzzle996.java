package p1000_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/number-of-squareful-arrays/
 *
 * @author half-dead
 */
public class Puzzle996 {

    // dfs + bitmasking, worst case O(N!) time
    class Solution {
        int[] nums, res = new int[1];
        Map<Integer, Set<Integer>> g;
        int n, max;

        public int numSquarefulPerms(int[] nums) {
            this.nums = nums;
            n = nums.length;
            max = (1 << n) - 1;
            g = new HashMap<>();
            g.put(-1, Arrays.stream(nums).boxed().collect(Collectors.toSet()));

            for (int a : nums)
                for (int b : nums) {
                    int sum = a + b, sqrt = (int) Math.sqrt(sum);
                    if (sqrt * sqrt == sum) g.computeIfAbsent(a, x -> new HashSet<>()).add(b);
                }

            dfs(-1, 0);
            return res[0];
        }

        void dfs(int num, int state) {
            if (state == max) {
                res[0]++;
                return;
            }

            Set<Integer> pairs = g.get(num);
            if (pairs == null) return;

            Set<Integer> seen = new HashSet<>();
            for (int pair : pairs) {
                if (!seen.add(pair)) continue;

                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] != pair) continue;

                    int nextstate = state | (1 << j);
                    if (state == nextstate) continue;

                    dfs(nums[j], nextstate);
                    break;
                }
            }
        }
    }
}
