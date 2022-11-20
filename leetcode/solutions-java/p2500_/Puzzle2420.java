package p2500_;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-good-indices/
 */
public class Puzzle2420 {

    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int n = nums.length;
            List<Integer> result = new ArrayList<>();
            if (k * 2 + 1 > n) {
                return result;
            }

            int[] forward = new int[n], backward = new int[n];
            forward[0] = backward[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] >= nums[i]) {
                    forward[i] = forward[i - 1] + 1;
                } else {
                    forward[i] = 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] <= nums[i + 1]) {
                    backward[i] = backward[i + 1] + 1;
                } else {
                    backward[i] = 1;
                }
            }

            
            for (int i = k; i + k < n; i++) {
                if (forward[i - 1] >= k && backward[i + 1] >= k) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
