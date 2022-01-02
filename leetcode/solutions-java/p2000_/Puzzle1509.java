package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * @author half-dead
 */
public class Puzzle1509 {

    // complete sorting, O(NlogN)
    // can be improved to O(NlogK) with partial sorting or heapq
    class Solution {
        public int minDifference(int[] nums) {
            int len = nums.length;

            if (len < 5) return 0;
            Arrays.sort(nums);

            int[] x = new int[]{
                    nums[len - 4] - nums[0],
                    nums[len - 3] - nums[1],
                    nums[len - 2] - nums[2],
                    nums[len - 1] - nums[3]
            };
            Arrays.sort(x);
            return x[0];
        }
    }
}
