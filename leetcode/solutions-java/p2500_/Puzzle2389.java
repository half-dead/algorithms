package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/
 *
 * @author half-dead
 */
public class Puzzle2389 {
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i];
                int pos = Arrays.binarySearch(nums, q);
                if (pos < 0) pos = -pos - 2;
                res[i] = pos + 1;
            }
            return res;
        }
    }
}
