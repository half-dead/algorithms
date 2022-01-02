package p0500_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * @author half-dead
 */
public class Puzzle128_LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n);

            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                int len = 1;
                while (set.contains(++n)) {
                    set.remove(n);
                    len++;
                }
                n -= len;
                while (set.contains(--n)) {
                    set.remove(n);
                    len++;
                }
                max = Math.max(max, len);
            }
            return max;
        }
    }
}
