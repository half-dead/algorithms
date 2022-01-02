package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 *
 * @author half-dead
 */
public class Puzzle1695 {

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int[] map = new int[10001];
            Arrays.fill(map, -1);

            int sum = 0, max = 0, left = 0;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];

                if (map[n] < 0) {
                    map[n] = i;
                } else {
                    while (left <= map[n]) {
                        sum -= nums[left++];
                    }
                    map[n] = i;
                }
                sum += n;
                max = Math.max(max, sum);
            }
            max = Math.max(max, sum);
            return max;
        }
    }
}
