package p1000_;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author half-dead
 */
public class Puzzle560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Puzzle560_SubarraySumEqualsK p = new Puzzle560_SubarraySumEqualsK();
        Solution s = p.new Solution();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
    }

    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

    public class WithoutSpaceSolution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; start++) {
                int sum = 0;
                for (int end = start; end < nums.length; end++) {
                    sum += nums[end];
                    if (sum == k)
                        count++;
                }
            }
            return count;
        }
    }

    // Cummulative sum
    class CummulativeSumSolution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0;
            int[] sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }

            int count = 0;
            for (int i = 0; i < sums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j && sums[i] == k) {
                        count++;
                    } else if (i != j && sums[i] - sums[j] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
