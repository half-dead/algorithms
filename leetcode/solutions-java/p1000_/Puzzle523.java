package p1000_;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 *
 * @author half-dead
 */
public class Puzzle523 {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int mod = 0;
            for (int i = 0; i < nums.length; i++) {
                mod += nums[i];
                if (k != 0) mod %= k;

                Integer prev = map.get(mod);
                if (prev != null) {
                    if (i - prev > 1) return true;
                } else map.put(mod, i);
            }
            return false;
        }
    }

    // Brute Force with prefix sum
    class BFSolution {
        public boolean checkSubarraySum(int[] nums, int k) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
                if (k == 0) {
                    if (nums[i] == 0) return true;
                } else {
                    if (nums[i] % k == 0) return true;
                }
            }
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 2; j < nums.length; j++) {
                    if (k == 0) {
                        if (nums[j] == nums[i]) return true;
                    } else {
                        if ((nums[j] - nums[i]) % k == 0) return true;
                    }
                }
            }
            return false;
        }
    }
}
