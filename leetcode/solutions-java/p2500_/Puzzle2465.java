package p2500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-averages/
 */
public class Puzzle2465 {
    class Solution {
        public int distinctAverages(int[] nums) {
            Arrays.sort(nums);
            int i = 0, j = nums.length - 1;
            Set<Double> set = new HashSet<>();
            while (i < j) {
                set.add((nums[i++] + nums[j--]) / 2.0D);
            }
            return set.size();
        }
    }
}
