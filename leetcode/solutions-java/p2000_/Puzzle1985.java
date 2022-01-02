package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 *
 * @author half-dead
 */
public class Puzzle1985 {

    class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, (a, b) -> {
                int d = b.length() - a.length();
                return d != 0 ? d : b.compareTo(a);
            });
            return nums[k - 1];
        }
    }
}
