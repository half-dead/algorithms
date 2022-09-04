package p2500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-subarrays-with-equal-sum/
 *
 * @author half-dead
 */
public class Puzzle2395 {
    class Solution {
        public boolean findSubarrays(int[] nums) {
            Set<Long> set = new HashSet<>();
            long sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                if (!set.add(sum)) {
                    return true;
                }
                sum -= nums[i - 1];
            }
            return false;
        }
    }
}
